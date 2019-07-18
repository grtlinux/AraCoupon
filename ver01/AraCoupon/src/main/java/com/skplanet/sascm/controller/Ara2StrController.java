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
			//
			// 구매하려는 쿠폰금액이 계좌에 충분한지 확인한다.
			//
			int cpnSiz = Integer.parseInt(String.valueOf(modelMap.get("cpnSiz")));
			long cpnMny = Long.parseLong(String.valueOf(modelMap.get("cpnMny")));
			long cpnSum = cpnMny * cpnSiz;  // 계좌에 이 금액 이상이 있는지 확인한다.
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
			modelMap.addAttribute("updCnt", updCnt);
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("액면가[%,d] 쿠폰 [%,d]장을 금액[%,d]에 구매하였습니다.", cpnMny, updCnt, cpnSum));
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
				/*
				  "strid": "101",
				  "campNo": "110",
				  "cpnSiz": "1",
				  "cpnMny": "5000",
				  "usrid": "1001",
				  "arakey": "7348",
				*/
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

	/*
	 * createCampFormPage.jsp   POST
	 */
	@RequestMapping(value = "/coupon/createCampFormPage.do", method = RequestMethod.POST)
	public String create(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		
		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/coupon/createCampFormPage";
	}

	/*
	 * create campaign
	 */
	@RequestMapping(value = "/coupon/saveCampInfo.do", method = RequestMethod.POST)
	public void saveCampInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			// get CAMP_ID
			Map<String,Object> map = this.araStrService.selectCampId(modelMap);
			int seq = 0;
			if (map.get("MAX_CPN_MST") != null) {
				String cpnMst = String.valueOf(map.get("MAX_CPN_MST"));
				seq = Integer.parseInt(cpnMst.substring(11)) + 1;
			}
			if (seq >= 10) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", "[FAIL] 하루에 10개 이상의 쿠폰패키지를 만들 수 없습니다.");
				jsonView.render(modelMap, request, response);
				return;
			}
			String cpnMst = String.format("%2s%3s%6s%1d"
					, String.valueOf(map.get("CTR_ID"))
					, String.valueOf(map.get("STR_ID"))
					, String.valueOf(map.get("TODAY"))
					, seq);
			modelMap.put("cpnMst", cpnMst);
			modelMap.put("CAMP_ID", map.get("CAMP_ID"));
		}
		
		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		if (Flag.flag) {
			// insert
			this.araStrService.insertAraCamp(modelMap);
			this.araStrService.insertAraCampInfo(modelMap);
			this.araStrService.insertAraCampOff(modelMap);
			this.araStrService.insertAraCampChl(modelMap);
			this.araStrService.insertAraOffCpn(modelMap);
			this.araStrService.insertAraChlSms(modelMap);
		}
		
		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 캠페인을 생성한 후 승인요청을 위한 목록 페이지
	 */
	@RequestMapping(value = "/coupon/apprReqListPage.do", method = RequestMethod.POST)
	public String approvalReqPost(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		
		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/coupon/apprReqListPage";
	}

	/*
	 * 승인요청에 대한 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/coupon/selectApprReqList.do", method = RequestMethod.POST)
	public void selectApprovalReq(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectApprReqList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/*
	 * 승인요청을 보낸다.
	 */
	@RequestMapping(value = "/coupon/insertApprReq.do", method = RequestMethod.POST)
	public void insertApprReq(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		
		if (Flag.flag) {
			String[] arrCampId = String.valueOf(modelMap.get("campIds")).split(",");
			modelMap.addAttribute("arrCampId", arrCampId);
		}

		if (Flag.flag) {
			this.araStrService.insertApprReq(modelMap);
			
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 승인완료된 캠페인목록 페이지
	 */
	@RequestMapping(value = "/coupon/apprResListPage.do", method = RequestMethod.POST)
	public String approvalRes(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/coupon/apprResListPage";
	}

	/*
	 * 승인완료된 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/coupon/selectApprResList.do", method = RequestMethod.POST)
	public void selectApprovalRes(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectApprResList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 쿠폰목록 페이지
	 */
	@RequestMapping(value = "/provide/allCpnListPage.do", method = RequestMethod.POST)
	public String allCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/provide/allCpnListPage";
	}

	/*
	 * 쿠폰목록 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/provide/selectAllCpnList.do", method = RequestMethod.POST)
	public void selectAllCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectAllCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 쿠폰목록 페이지
	 */
	@RequestMapping(value = "/provide/givableCpnListPage.do", method = RequestMethod.POST)
	public String givableCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/provide/givableCpnListPage";
	}

	/*
	 * 쿠폰목록 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/provide/selectCouponList.do", method = RequestMethod.POST)
	public void selectCouponList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectCouponList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/*
	 * 선택된 쿠폰을 제공한다.
	 */
	/*
	@RequestMapping(value = "/provide/giveCpnList.do", method = RequestMethod.POST)
	public void giveCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			String[] arrCpnNo = String.valueOf(modelMap.get("arrCpnNo")).split(",");
			modelMap.addAttribute("arrCpnNo", arrCpnNo);
			this.araStrService.giveCpnList(modelMap);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		
		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 성공적으로 쿠폰을 제공하였습니다.");

		jsonView.render(modelMap, request, response);
	}
	*/
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 쿠폰목록 페이지
	 */
	@RequestMapping(value = "/payment/payCpnListPage.do", method = RequestMethod.POST)
	public String payCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/payment/payCpnListPage";
	}

	/*
	 * 쿠폰목록 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/payment/selectPayCpnList.do", method = RequestMethod.POST)
	public void selectPayCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectPayCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 쿠폰목록 페이지
	 */
	@RequestMapping(value = "/payment/noPayCpnListPage.do", method = RequestMethod.POST)
	public String noPayCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/payment/noPayCpnListPage";
	}

	/*
	 * 쿠폰목록 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/payment/selectNoPayCpnList.do", method = RequestMethod.POST)
	public void selectNoPayCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectNoPayCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 쿠폰목록 페이지
	 */
	@RequestMapping(value = "/calculate/tempCalcListPage.do", method = RequestMethod.POST)
	public String tempCalcListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/calculate/tempCalcListPage";
	}

	/*
	 * 쿠폰목록 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/calculate/selectTempCalcList.do", method = RequestMethod.POST)
	public void selectTempCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectTempCalcList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

}
