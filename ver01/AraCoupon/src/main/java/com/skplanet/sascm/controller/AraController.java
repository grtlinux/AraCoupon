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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.skplanet.sascm.service.AraService;
import com.skplanet.sascm.util.Flag;
import com.skplanet.sascm.util.GenerateAraKey;

@SuppressWarnings("unchecked")
@Controller
public class AraController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara";

	@Resource(name = "araService")
	private AraService araService;

	//AJAX
	@Autowired
	private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/ara.do", method = RequestMethod.GET)
	public String araGet(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		return PATH + "/index";
	}

	@RequestMapping(value = "/ara.do", method = RequestMethod.POST)
	public String araPost(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		return PATH + "/index";
	}

	// not be used
	@RequestMapping(value = "/araUsr.do", method = RequestMethod.POST)
	public ModelAndView araUsr(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		//return "redirect:/usr/index.do?usrid=2";
		return new ModelAndView("redirect:/usr/index.do?usrid=2");
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Usr
	
	@RequestMapping(value = "/requestUsrAraKey.do", method = RequestMethod.POST)
	public void requestUsrAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			this.araService.updateAllCnntByUsrid(modelMap);
		}
		if (Flag.flag) {
			// arakey를 얻는다.
			String arakey = GenerateAraKey.getAraKey();
			modelMap.addAttribute("arakey", arakey);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			this.araService.insertUsrAraKey(modelMap);
			modelMap.addAttribute("retMsg", "정상적으로 아라키(AraKey)를 생성하였습니다. => " + modelMap.get("arakey"));
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
		}
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/confirmUsr.do", method = RequestMethod.POST)
	public void confirmUsr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.araService.selectUsrAraKeyInfo(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				modelMap.addAttribute("retMsg", "FAIL");
				this.araService.updateAllCnntByUsrid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				modelMap.addAttribute("map", map);
				modelMap.addAttribute("retMsg", "SUCCESS");
				this.araService.updateCnntByUsrid(modelMap);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
		}
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Str
	
	@RequestMapping(value = "/requestStrAraKey.do", method = RequestMethod.POST)
	public void requestStrAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			this.araService.updateAllCnntByStrid(modelMap);
		}
		if (Flag.flag) {
			// arakey를 얻는다.
			String arakey = GenerateAraKey.getAraKey();
			modelMap.addAttribute("arakey", arakey);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			this.araService.insertStrAraKey(modelMap);
			modelMap.addAttribute("retMsg", "정상적으로 아라키(AraKey)를 생성하였습니다. => " + modelMap.get("arakey"));
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
		}
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/confirmStr.do", method = RequestMethod.POST)
	public void confirmStr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.araService.selectStrAraKeyInfo(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				modelMap.addAttribute("retMsg", "FAIL");
				this.araService.updateAllCnntByStrid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				modelMap.addAttribute("map", map);
				modelMap.addAttribute("retMsg", "SUCCESS");
				this.araService.updateCnntByStrid(modelMap);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
		}
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Ctr
	
	@RequestMapping(value = "/requestCtrAraKey.do", method = RequestMethod.POST)
	public void requestCtrAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			this.araService.updateAllCnntByCtrid(modelMap);
		}
		if (Flag.flag) {
			// arakey를 얻는다.
			String arakey = GenerateAraKey.getAraKey();
			modelMap.addAttribute("arakey", arakey);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			this.araService.insertCtrAraKey(modelMap);
			modelMap.addAttribute("retMsg", "정상적으로 아라키(AraKey)를 생성하였습니다. => " + modelMap.get("arakey"));
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
		}
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/confirmCtr.do", method = RequestMethod.POST)
	public void confirmCtr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
		}
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.araService.selectCtrAraKeyInfo(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				modelMap.addAttribute("retMsg", "FAIL");
				this.araService.updateAllCnntByCtrid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				modelMap.addAttribute("map", map);
				modelMap.addAttribute("retMsg", "SUCCESS");
				this.araService.updateCnntByCtrid(modelMap);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190626 >>>>> modelMap: " + modelMap);
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
