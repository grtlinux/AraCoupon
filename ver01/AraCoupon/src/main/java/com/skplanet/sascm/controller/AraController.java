package com.skplanet.sascm.controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.skplanet.sascm.service.AraService;
import com.skplanet.sascm.util.Flag;
import com.skplanet.sascm.util.GenerateAraKey;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping(value = "/ara")
public class AraController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/ara";

	@Resource(name = "araService")
	private AraService araService;

	//AJAX
	@Autowired
	private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * request.Parameters   ->  modelMap
	 */
	private ModelMap setModelMap(ModelMap modelMap, HttpServletRequest request) throws Exception {
		//copy request.Parameters to modelMap
		//modelMap.putAll(request.getParameterMap());
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		//modelMap.addAttribute("TODAY1", Flag.getDateTime("yyyy-MM-dd"));
		//modelMap.addAttribute("TODAY2", Flag.getDateTime("yyyyMMdd"));
		if (log.isDebugEnabled()) {
			//log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
		}
		return modelMap;
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * index.jsp GET
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexGet(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		return PATH + "/index";
	}

	/*
	 * index.jsp POST
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String indexPost(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	// not be used
	//@RequestMapping(value = "/araUsr.do", method = RequestMethod.POST)
	//public ModelAndView araUsr(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
	//	if (Flag.flag) {
	//		Flag.printRequest(request);
	//	}
	//	//return "redirect:/usr/index.do?usrid=2";
	//	return new ModelAndView("redirect:/usr/index.do?usrid=2");
	//}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Usr-2
	
	@RequestMapping(value = "/requestUsrAraKey.do", method = RequestMethod.POST)
	public void requestUsrAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			this.araService.updateAllCnntByUsrid(modelMap);
		}
		if (Flag.flag) {
			// arakey를 얻는다.
			String arakey = GenerateAraKey.getAraKey();
			arakey = "2025";  // KANG-20190702: 임시 for test
			modelMap.addAttribute("arakey", arakey);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			this.araService.insertUsrAraKey(modelMap);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("정상적으로 아라키(AraKey)[%s]를 생성하였습니다. 인증에 사용하세요.", modelMap.get("arakey")));
		}
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/confirmUsr.do", method = RequestMethod.POST)
	public void confirmUsr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.araService.selectUsrAraKeyInfo(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("아라키(AraKey)가 존재하지 않아 인증에 실패했습니다. 아라키(AraKey)요청부터 다시 진행 해주세요."));
				}
				this.araService.updateAllCnntByUsrid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("정상적으로 인증처리 되었습니다."));
				}
				modelMap.addAttribute("map", map);
				this.araService.updateCnntByUsrid(modelMap);
			}
		}
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Str-2
	
	@RequestMapping(value = "/requestStrAraKey.do", method = RequestMethod.POST)
	public void requestStrAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			this.araService.updateAllCnntByStrid(modelMap);
		}
		if (Flag.flag) {
			// arakey를 얻는다.
			String arakey = GenerateAraKey.getAraKey();
			arakey = "2025";  // KANG-20190702: 임시 for test
			modelMap.addAttribute("arakey", arakey);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			this.araService.insertStrAraKey(modelMap);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("정상적으로 아라키(AraKey)[%s]를 생성하였습니다. 인증에 사용하세요.", modelMap.get("arakey")));
		}
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/confirmStr.do", method = RequestMethod.POST)
	public void confirmStr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.araService.selectStrAraKeyInfo(modelMap);
			if (map == null) {
				// (strid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("아라키(AraKey)가 존재하지 않아 인증에 실패했습니다. 아라키(AraKey)요청부터 다시 진행 해주세요."));
				}
				this.araService.updateAllCnntByStrid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("정상적으로 인증처리 되었습니다."));
				}
				modelMap.addAttribute("map", map);
				this.araService.updateCnntByStrid(modelMap);
			}
		}
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Ctr-2
	
	@RequestMapping(value = "/requestCtrAraKey.do", method = RequestMethod.POST)
	public void requestCtrAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			this.araService.updateAllCnntByCtrid(modelMap);
		}
		if (Flag.flag) {
			// arakey를 얻는다.
			String arakey = GenerateAraKey.getAraKey();
			arakey = "2025";  // KANG-20190702: 임시 for test
			modelMap.addAttribute("arakey", arakey);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			this.araService.insertCtrAraKey(modelMap);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("정상적으로 아라키(AraKey)[%s]를 생성하였습니다. 인증에 사용하세요.", modelMap.get("arakey")));
		}
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/confirmCtr.do", method = RequestMethod.POST)
	public void confirmCtr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.araService.selectCtrAraKeyInfo(modelMap);
			if (map == null) {
				// (ctrid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("아라키(AraKey)가 존재하지 않아 인증에 실패했습니다. 아라키(AraKey)요청부터 다시 진행 해주세요."));
				}
				this.araService.updateAllCnntByCtrid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("정상적으로 인증처리 되었습니다."));
				}
				modelMap.addAttribute("map", map);
				this.araService.updateCnntByCtrid(modelMap);
			}
		}
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
}
