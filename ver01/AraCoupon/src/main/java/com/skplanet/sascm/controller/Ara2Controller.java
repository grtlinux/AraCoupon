package com.skplanet.sascm.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.GsonBuilder;
import com.skplanet.sascm.service.Ara2IbService;
import com.skplanet.sascm.service.Ara2Service;
import com.skplanet.sascm.util.Flag;
import com.skplanet.sascm.util.GenerateAraKey;
import com.skplanet.sascm.util.IbMsg;

@Controller
@RequestMapping(value = "/ara2")
public class Ara2Controller {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara2/ara";

	@Resource(name = "ara2Service")
	private Ara2Service ara2Service;

	@Resource(name = "ara2IbService")
	private Ara2IbService ara2IbService;

	//AJAX
	@Autowired
	private MappingJackson2JsonView jsonView;

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
			modelMap = Flag.setModelMap(modelMap, request);
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
			modelMap = Flag.setModelMap(modelMap, request);
		}
		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/register/registerUsrFormPage.do", method = RequestMethod.POST)
	public String registerUsrFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2Service.selectLocInfoList(modelMap);
			log.debug("listLoc: " + list);
			modelMap.addAttribute("listLoc", list);
		}
		return PATH + "/register/registerUsrFormPage";
	}

	@RequestMapping(value = "/register/createUsrInfo.do", method = RequestMethod.POST)
	public void createUsrInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			modelMap.putAll(this.ara2Service.selectChkNmMblEml(modelMap));
			if (modelMap.get("USR_NM") != null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("이미 등록된 고객명 입니다."));
			} else if (modelMap.get("MBL_NUM") != null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("이미 등록된 모바일번호 입니다."));
			} else if (modelMap.get("EML_ADDR") != null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("이미 등록된 이메일 입니다."));
			} else {
				modelMap.putAll(this.ara2Service.selectUsrNo(modelMap));
				this.ara2Service.insertAra2Usr(modelMap);
				this.ara2Service.insertAra2Mbl(modelMap);
				this.ara2Service.insertAra2Eml(modelMap);
				this.ara2Service.insertAra2Mrrg(modelMap);
				//
				modelMap.putAll(this.ara2Service.selectLoginInfo(modelMap));
				List<String> loginSrch = new ArrayList<>();
				loginSrch.add(String.valueOf(modelMap.get("ITM_NM")));
				loginSrch.add(String.valueOf(modelMap.get("MBL_NUM")));
				loginSrch.add(String.valueOf(modelMap.get("EML_ADDR")));
				loginSrch.add(String.valueOf(modelMap.get("MRRG_DT")));
				modelMap.put("loginSrch", StringUtils.join(loginSrch.toArray(new String[loginSrch.size()]), ":"));
				List<String> loginList = new ArrayList<>();
				loginList.add(String.valueOf(modelMap.get("ITM_NM")));
				loginList.add(Flag.getPhoneNumberWithMask(String.valueOf(modelMap.get("MBL_NUM"))));
				loginList.add(Flag.getEmailWithMask(String.valueOf(modelMap.get("EML_ADDR"))));
				loginList.add(String.valueOf(modelMap.get("MRRG_DT")));
				modelMap.put("loginList", StringUtils.join(loginList.toArray(new String[loginList.size()]), ":"));
				this.ara2Service.insertLoginInfo(modelMap);
				//
				modelMap.addAttribute("retCode", "0000");
				modelMap.addAttribute("retMsg", String.format("고객이 정상적으로 등록되었습니다.\n고객번호는 [%s] 입니다.", String.valueOf(modelMap.get("USR_NO"))));
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Ara
	
	@RequestMapping(value = "/requestAraKey.do", method = RequestMethod.POST)
	public void requestAraKey(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// id를 확인한다.
			Map<String,Object> map = null;
			map = this.ara2Service.selectItemInfo(modelMap);
			if (map == null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("요청하신 아이디가 존재하지 않습니다."));
			} else {
				// modelMap <- map
				modelMap.putAll(map);
				//
				if (Flag.flag) {
					// 이미 진행중인 아라키는 사용하지 못하도록 한다.
					this.ara2Service.updateAllCnntByCnntid(modelMap);
				}
				if (Flag.flag) {
					// arakey를 얻는다.
					String arakey = GenerateAraKey.getAraKey();
					//arakey = "2025";  // KANG-20190716: imsi
					modelMap.addAttribute("arakey", arakey);
				}
				if (Flag.flag) {
					// arakey를 ARA_CNNT 테이블에 넣는다.
					this.ara2Service.insertCnntAraKey(modelMap);
				}
				if (Flag.flag) {
					// SMS 전송
					map = this.ara2IbService.selectLastIbTkn(null);
					if (map == null || ((BigDecimal) map.get("DIFF_HOURS")).compareTo(new BigDecimal("2")) > 0) {
						// more then 2 hours.....and select new token information....so, insert the infos
						map = this.ara2IbService.selectAraInfo(null);
						map = IbMsg.getIbTokenInfo(map);
						map.put("tknNm", String.format("to update token at %s", Flag.getDateTime("yyyy-MM-dd HH:mm:ss")));
						map.put("accsTkn", (String) map.get("accessToken"));
						map.put("schm", (String) map.get("schema"));
						map.put("expd", (String) map.get("expired"));
						this.ara2IbService.insertIbTkn(map);
						map = this.ara2IbService.selectLastIbTkn(null);
					} else {
						// less then and equal to 2 hours.....
					}
					modelMap.addAttribute("mapToken", map);
					modelMap.addAttribute("retIbSend", IbMsg.sendIbSms(modelMap));
				}
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("아라키를 모바일에 전송하였습니다. 인증에 사용하세요."));
				}
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/connect.do", method = RequestMethod.POST)
	public void connect(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// arakey를 ARA_CNNT 테이블에 넣는다.
			Map<String,Object> map = this.ara2Service.selectCnntArakeyInfo(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("인증에 실패하였습니다."));
				}
				this.ara2Service.updateAllCnntByCnntid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("인증에 성공하였습니다."));
				}
				modelMap.addAttribute("map", map);
				this.ara2Service.updateCnntByCnntid(modelMap);
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/underConstruct/underConstructPage.do", method = RequestMethod.POST)
	public String underConstructPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		return PATH + "/underConstruct/underConstructPage";
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
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
}
