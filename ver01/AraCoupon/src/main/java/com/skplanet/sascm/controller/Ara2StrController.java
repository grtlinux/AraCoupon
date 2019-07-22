package com.skplanet.sascm.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.gson.GsonBuilder;
import com.skplanet.sascm.service.Ara2IbService;
import com.skplanet.sascm.service.Ara2StrService;
import com.skplanet.sascm.service.AraStrService;
import com.skplanet.sascm.util.Flag;
import com.skplanet.sascm.util.GenerateAraKey;
import com.skplanet.sascm.util.IbMsg;

@Controller
@RequestMapping(value = "/str2")
public class Ara2StrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara2/str";

	@Resource(name = "araStrService")
	private AraStrService araStrService;

	@Resource(name = "ara2StrService")
	private Ara2StrService ara2StrService;

	@Resource(name = "ara2IbService")
	private Ara2IbService ara2IbService;

	//AJAX
	@Autowired
	private MappingJacksonJsonView jsonView;

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
			Map<String,Object> map = this.ara2StrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/buyCpnListPage.do", method = RequestMethod.POST)
	public String buyCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2StrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/buyCpnListPage";
	}
	
	@RequestMapping(value = "/coupon/selectCampList2.do", method = RequestMethod.POST)
	public void selectCampList2(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2StrService.selectCampList2(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 자료를 얻었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/coupon/buyCpnList.do", method = RequestMethod.POST)
	public void buyCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// 소유하고 있는 계좌금액을 얻는다.
			modelMap.putAll(this.ara2StrService.selectStrAcntInfo(modelMap));
		}
		if (Flag.flag) {
			//
			// 구매하려는 쿠폰금액이 계좌에 충분한지 확인한다.
			//
			long acntBlnc = ((BigDecimal) modelMap.get("ACNT_BLNC")).longValue();
			//
			int cpnSiz = Integer.parseInt(String.valueOf(modelMap.get("cpnSiz")));
			long cpnMny = Long.parseLong(String.valueOf(modelMap.get("cpnMny")));
			long cpnSum = cpnMny * cpnSiz;  // 계좌에 이 금액 이상이 있는지 확인한다.
			if (cpnSum <= acntBlnc) {
				// 쿠폰을 원하는 갯수 만큼 구매한다.
				int updCnt = 0;
				for (int i=0; i < cpnSiz; i++) {
					int ret = this.ara2StrService.updateBuyCpnSht(modelMap);
					if (Flag.flag) log.debug(">>>>> ret of this.ara2StrService.updateBuyCpnSht is " + ret);
					updCnt += ret;
				}
				cpnSum = cpnMny * updCnt;  // 실재 쿠폰구매에 사용한 금액
				//
				// 구매한 쿠폰금액은 계좌에서 차감한다.
				//
				modelMap.addAttribute("cpnSum", cpnSum);
				int ret = this.ara2StrService.insertBuyCpnSum(modelMap);
				if (Flag.flag) log.debug(">>>>> ret of this.ara2StrService.insertBuyCpnSum is " + ret);
				//
				modelMap.addAttribute("updCnt", updCnt);
				modelMap.addAttribute("retCode", "0000");
				modelMap.addAttribute("retMsg", String.format("액면가[%,d] 쿠폰 [%,d]장을 금액[%,d]에 구매하였습니다.", cpnMny, updCnt, cpnSum));
			} else {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("쿠폰구매금액이 부족합니다. (잔액: %,d)", acntBlnc));
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
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
			Map<String,Object> map = this.ara2StrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/stateCpnListPage";
	}
	
	@RequestMapping(value = "/coupon/selectStateCpnList.do", method = RequestMethod.POST)
	public void selectStateCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2StrService.selectStateCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 자료를 얻었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/giveCpnListPage.do", method = RequestMethod.POST)
	public String giveCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2StrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/giveCpnListPage";
	}
	
	@RequestMapping(value = "/coupon/selectGiveCpnList.do", method = RequestMethod.POST)
	public void selectGiveCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2StrService.selectGiveCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 자료를 얻었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/coupon/sendAraKeyToUsr.do", method = RequestMethod.POST)
	public void sendAraKeyToUsr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// id를 확인한다.
			Map<String,Object> map = null;
			map = this.ara2StrService.selectUsrInfo(modelMap);
			if (map == null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("요청하신 아이디가 존재하지 않습니다."));
			} else {
				// modelMap <- map
				modelMap.putAll(map);
				//
				if (Flag.flag) {
					// 이미 진행중인 아라키는 사용하지 못하도록 한다.
					this.ara2StrService.updateAllCnntByCnntid(modelMap);
				}
				if (Flag.flag) {
					// arakey를 얻는다.
					String arakey = GenerateAraKey.getAraKey();
					//arakey = "2025";  // KANG-20190716: imsi
					modelMap.addAttribute("arakey", arakey);
				}
				if (Flag.flag) {
					// arakey를 ARA_CNNT 테이블에 넣는다.
					this.ara2StrService.insertCnntAraKey(modelMap);
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

	@RequestMapping(value = "/coupon/giveCpnList.do", method = RequestMethod.POST)
	public void giveCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2StrService.selectCnntArakeyInfo(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("쿠폰제공에 실패하였습니다."));
				}
				this.ara2StrService.updateAllCnntByCnntid(modelMap);
			} else {
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				int cpnSiz = Integer.parseInt(String.valueOf(modelMap.get("cpnSiz")));
				long cpnMny = Long.parseLong(String.valueOf(modelMap.get("cpnMny")));
				long cpnSum = cpnMny * cpnSiz; // 쿠폰으로 제공하려는 금액
				int updCnt = 0;
				for (int i=0; i < cpnSiz; i++) {
					int ret = this.ara2StrService.updateCpnNo(modelMap);
					if (Flag.flag) log.debug(">>>>> ret of this.ara2StrService.updateBuyCpnSht is " + ret);
					updCnt += ret;
				}
				cpnSum = cpnMny * updCnt;  // 실재 쿠폰으로 제공한 금액
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("금액[%,d]에 해당하는 액면가[%,d] 쿠폰 [%,d]장을 제공하였습니다.", cpnSum, cpnMny, updCnt));
				}
				modelMap.addAttribute("map", map);
				this.ara2StrService.updateCnntByCnntid(modelMap);
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/payment/paymentCpnListPage.do", method = RequestMethod.POST)
	public String paymentCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2StrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/payment/paymentCpnListPage";
	}
	
	@RequestMapping(value = "/payment/selectPaymentCpnList", method = RequestMethod.POST)
	public void selectPaymentCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2StrService.selectPaymentCpnList(modelMap);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("성공적으로 자료를 갖고왔습니다."));
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	
	@RequestMapping(value = "/payment/sendAraKeyToCtr.do", method = RequestMethod.POST)
	public void sendAraKeyToCtr(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// id를 확인한다.
			Map<String,Object> map = null;
			map = this.ara2StrService.selectCtrInfo(modelMap);
			if (map == null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", String.format("요청하신 아이디가 존재하지 않습니다."));
			} else {
				// modelMap <- map
				modelMap.putAll(map);
				//
				if (Flag.flag) {
					// 이미 진행중인 아라키는 사용하지 못하도록 한다.
					this.ara2StrService.updateAllCnntByCnntidOnCtr(modelMap);
				}
				if (Flag.flag) {
					// arakey를 얻는다.
					String arakey = GenerateAraKey.getAraKey();
					//arakey = "2025";  // KANG-20190716: imsi
					modelMap.addAttribute("arakey", arakey);
				}
				if (Flag.flag) {
					// arakey를 ARA_CNNT 테이블에 넣는다.
					this.ara2StrService.insertCnntAraKeyOnCtr(modelMap);
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

	@RequestMapping(value = "/payment/calculateCpnNoList.do", method = RequestMethod.POST)
	public void calculateCpnNoList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2StrService.selectCnntArakeyInfoOnCtr(modelMap);
			if (map == null) {
				// (userid, arakey) 존재하지 않으면 인증 실패
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "9999");
					modelMap.addAttribute("retMsg", String.format("쿠폰사용에 실패하였습니다."));
				}
				this.ara2StrService.updateAllCnntByCnntidOnCtr(modelMap);
			} else {
				if (Flag.flag) {
					// 쿠폰번호를 정리한다.
					String[] arrCpnNo = String.valueOf(modelMap.get("cpnNoList")).split(",");
					modelMap.addAttribute("arrCpnNo", arrCpnNo);
				}
				// (userid, arakey) 존재하면 정보를 리턴하고 자료를 update 한다.
				this.ara2StrService.updateCpnNoListOnCtr(modelMap);
				if (Flag.flag) {
					modelMap.addAttribute("retCode", "0000");
					modelMap.addAttribute("retMsg", String.format("정상적으로 처리되었습니다."));
				}
				modelMap.addAttribute("map", map);
				this.ara2StrService.updateCnntByCnntidOnCtr(modelMap);
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/account/selectAcntInOutListPage.do", method = RequestMethod.POST)
	public String selectAcntInOutListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2StrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/account/selectAcntInOutListPage";
	}
	
	@RequestMapping(value = "/account/selectAcntInOutList.do", method = RequestMethod.POST)
	public void selectInOutAcntList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2StrService.selectAcntInOutList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
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
