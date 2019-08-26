package kr.co.arajeju.aracoupon3.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.GsonBuilder;

import kr.co.arajeju.aracoupon3.service.Ara3IbService;
import kr.co.arajeju.aracoupon3.service.Ara3UsrService;
import kr.co.arajeju.aracoupon3.service.SessionService;
import kr.co.arajeju.aracoupon3.util.Flag;
import kr.co.arajeju.aracoupon3.util.GenerateAraKey;
import kr.co.arajeju.aracoupon3.util.IbMsg;

@Controller
@RequestMapping(value = "/usr3")
public class Ara3UsrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara3/usr";

	@Resource(name = "ara3UsrService")
	private Ara3UsrService ara3UsrService;

	@Resource(name = "ara3IbService")
	private Ara3IbService ara3IbService;

	@Inject
	private SessionService sessionService;

	//AJAX
	@Autowired
	private MappingJackson2JsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * index.jsp POST
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String indexPost(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			if ("Y".equals(modelMap.get("usridSaveYn"))) {
				// usrid 저장
				String usrid = String.valueOf(modelMap.get("usrid"));
				String usridSaveYn = String.valueOf(modelMap.get("usridSaveYn"));
				this.sessionService.setSession(request, "usrid", usrid);
				this.sessionService.setSession(request, "usridSaveYn", usridSaveYn);
				log.debug("KANG-20190808 session.usrid \t:  " + usrid);
			} else {
				// usrid 제거
				this.sessionService.setSession(request, "usrid", null);
				this.sessionService.setSession(request, "usridSaveYn", "N");
				log.debug("KANG-20190808 session.usrid \t:  (remove session.usrid)");
			}
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara3UsrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/stateCpnListPage.do", method = RequestMethod.POST)
	public String stateCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara3UsrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/stateCpnListPage";
	}
	
	@RequestMapping(value = "/coupon/selectStateCpnList", method = RequestMethod.POST)
	public void selectStateCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara3UsrService.selectStateCpnList(modelMap);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("성공적으로 자료를 갖고왔습니다."));
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/useCpnListPage.do", method = RequestMethod.POST)
	public String useCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara3UsrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/useCpnListPage";
	}
	
	
	@RequestMapping(value = "/coupon/selectUseCpnList", method = RequestMethod.POST)
	public void selectUseCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara3UsrService.selectUseCpnList(modelMap);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("성공적으로 자료를 갖고왔습니다."));
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/coupon/sendAraKeyToStr.do", method = RequestMethod.POST)
	public void sendAraKeyToStr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// id를 확인한다.
			Map<String,Object> map = null;
			map = this.ara3UsrService.selectStrInfo(modelMap);
			if (map == null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("요청하신 아이디가 존재하지 않습니다."));
			} else {
				// modelMap <- map
				modelMap.putAll(map);
				//
				if (Flag.flag) {
					// 이미 진행중인 아라키는 사용하지 못하도록 한다.
					this.ara3UsrService.updateAllCnntByCnntid(modelMap);
				}
				if (Flag.flag) {
					// arakey를 얻는다.
					String arakey = GenerateAraKey.getAraKey();
					//arakey = "2025";  // KANG-20190716: imsi
					modelMap.addAttribute("arakey", arakey);
				}
				if (Flag.flag) {
					// arakey를 ARA_CNNT 테이블에 넣는다.
					this.ara3UsrService.insertCnntAraKey(modelMap);
				}
				if (Flag.flag) {
					// SMS 전송
					map = this.ara3IbService.selectLastIbTkn(null);
					if (map == null || ((BigDecimal) map.get("DIFF_HOURS")).compareTo(new BigDecimal("2")) > 0) {
						// more then 2 hours.....and select new token information....so, insert the infos
						map = this.ara3IbService.selectAraInfo(null);
						map = IbMsg.getIbTokenInfo(map);
						map.put("tknNm", String.format("to update token at %s", Flag.getDateTime("yyyy-MM-dd HH:mm:ss")));
						map.put("accsTkn", (String) map.get("accessToken"));
						map.put("schm", (String) map.get("schema"));
						map.put("expd", (String) map.get("expired"));
						this.ara3IbService.insertIbTkn(map);
						map = this.ara3IbService.selectLastIbTkn(null);
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

	@RequestMapping(value = "/coupon/useCpnNoList.do", method = RequestMethod.POST)
	public void useCpnNoList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara3UsrService.selectCnntArakeyInfo(modelMap);
			if (map == null && String.valueOf(modelMap.get("arakeyYn")) == "Y") {
				// (userid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("쿠폰사용에 실패하였습니다."));
				}
				this.ara3UsrService.updateAllCnntByCnntid(modelMap);
			} else {
				if (Flag.flag) {
					// 쿠폰번호를 정리한다.
					String[] arrCpnNo = String.valueOf(modelMap.get("cpnNoList")).split(",");
					modelMap.addAttribute("arrCpnNo", arrCpnNo);
				}
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				this.ara3UsrService.updateCpnNoList(modelMap);
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("정상적으로 처리되었습니다."));
				}
				modelMap.addAttribute("map", map);
				this.ara3UsrService.updateCnntByCnntid(modelMap);
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
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
