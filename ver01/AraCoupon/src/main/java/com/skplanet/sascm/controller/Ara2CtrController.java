package com.skplanet.sascm.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.skplanet.sascm.service.Ara2CtrService;
import com.skplanet.sascm.service.Ara2IbService;
import com.skplanet.sascm.service.AraCtrService;
import com.skplanet.sascm.util.Flag;

@Controller
@RequestMapping(value = "/ctr2")
public class Ara2CtrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara2/ctr";

	@Resource(name = "araCtrService")
	private AraCtrService araCtrService;

	@Resource(name = "ara2CtrService")
	private Ara2CtrService ara2CtrService;

	@Resource(name = "ara2IbService")
	private Ara2IbService ara2IbService;

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
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/createCampFormPage.do", method = RequestMethod.POST)
	public String createCampFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("info: " + map);
			modelMap.addAttribute("info", map);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectCampPeriod(modelMap);
			log.debug("period: " + map);
			modelMap.addAttribute("period", map);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectAraCpnTyp(modelMap);
			log.debug("lstAraCpnTyp: " + list);
			modelMap.addAttribute("lstAraCpnTyp", list);
		}
		return PATH + "/coupon/createCampFormPage";
	}
	
	
	@RequestMapping(value = "/coupon/createCampInfo.do", method = RequestMethod.POST)
	public void createCampInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// get CAMP_ID
			Map<String,Object> map = this.ara2CtrService.selectSeqCampKey(modelMap);
			if (map == null) {
				modelMap.addAttribute("retCode", "9999");
				modelMap.addAttribute("retMsg", "쿠폰 마스터키를 얻는데 에러가 발생함.");
			} else {
				modelMap.putAll(map);
				String cpnMst = String.format("%2s%6s%3s%03d"
						, String.valueOf(modelMap.get("ctrid"))
						, Flag.getYYMMDD()
						, String.valueOf(modelMap.get("campCpnTyp"))
						, ((BigDecimal)modelMap.get("KEY_SEQ_CAMP")).intValue()
						);
				modelMap.put("cpnMst", cpnMst);
				this.ara2CtrService.insertCampInfo(modelMap);
				modelMap.addAttribute("retCode", "0000");
				modelMap.addAttribute("retMsg", "성공적으로 캠페인이 생성 되었습니다.");
			}
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/executeCampListPage.do", method = RequestMethod.POST)
	public String executeCampListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/executeCampListPage";
	}
	
	@RequestMapping(value = "/coupon/selectCampList1.do", method = RequestMethod.POST)
	public void selectCampList1(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectCampList1(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/coupon/createCouponPackage.do", method = RequestMethod.POST)
	public void insertApprReq(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// 처리할 캠페인번호
			String[] arrCampNo = String.valueOf(modelMap.get("campNos")).split(",");
			modelMap.addAttribute("arrCampNo", arrCampNo);
			// 쿠폰생성에 사용할 맵
			Map<String,Object> map = new HashMap<>();
			map.put("ctrid", modelMap.get("ctrid"));
			for (int i=0; i < arrCampNo.length; i++) {
				map.put("campNo", arrCampNo[i]);
				// 해당 캠페인의 쿠폰을 모두 삭제한다.
				this.ara2CtrService.deleteCampCpnSht(map);
				// 해당 캠페인정보를 얻는다.
				map.putAll(this.ara2CtrService.selectCampNoInfo(map));
				String cpnMst = String.valueOf(map.get("CPN_MST"));
				int cnt = ((BigDecimal) map.get("CPN_CNT")).intValue();
				for (int seq=1; seq <= cnt; seq++) {
					// 쿠폰번호를 구한다.
					String cpnNo = Flag.getCouponNo(cpnMst, seq);
					map.put("cpnNo", cpnNo);
					// 쿠폰 한장을 생성한다.
					this.ara2CtrService.insertCampCpnSht(map);
				}
				// 해당 캠페인에 대한 쿠폰페키지를 발행했으면 캠페인정보를 변경한다.
				this.ara2CtrService.updateCampNoInfo(map);
			}
			// 정상 쿠폰발행
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/coupon/resultCampListPage.do", method = RequestMethod.POST)
	public String resultCampListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/coupon/resultCampListPage";
	}
	
	@RequestMapping(value = "/coupon/selectCampList2.do", method = RequestMethod.POST)
	public void selectCampList2(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectCampList2(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
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
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/payment/paymentCpnListPage";
	}
	
	@RequestMapping(value = "/payment/selectPaymentCpnList.do", method = RequestMethod.POST)
	public void selectPaymentCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectPaymentCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
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
			String[] arrCpnNo = String.valueOf(modelMap.get("cpnNoList")).split(",");
			modelMap.addAttribute("arrCpnNo", arrCpnNo);
		}
		if (Flag.flag) {
			int ret = 0;
			// ara2_cpn.cpn_phs: 5 -> 0
			modelMap.addAttribute("phsFrm", "5");
			modelMap.addAttribute("phsTo", "0");
			ret = this.ara2CtrService.updateCpnNosPhs(modelMap);
			if (Flag.flag) log.debug(">>>>> ret of this.ara2CtrService.updateCpnNosPhs is " + ret);
			
			// group by str -> sum, insert into ara2_acnthist
			ret = this.ara2CtrService.insertAcntDpst(modelMap);
			if (Flag.flag) log.debug(">>>>> ret of this.ara2CtrService.insertAcntDpst is " + ret);
			
			// ara2_cpn.cpn_phs: P -> 6
			modelMap.addAttribute("phsFrm", "0");
			modelMap.addAttribute("phsTo", "6");
			ret = this.ara2CtrService.updateCpnNosPhs(modelMap);
			if (Flag.flag) log.debug(">>>>> ret of this.ara2CtrService.updateCpnNosPhs is " + ret);
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
	
	@RequestMapping(value = "/payment/completeCalcListPage.do", method = RequestMethod.POST)
	public String completeCalcListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/payment/completeCalcListPage";
	}

	@RequestMapping(value = "/payment/selectCompleteCalcList.do", method = RequestMethod.POST)
	public void selectCompleteCalcList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectCompleteCalcList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/payment/notUsedCpnListPage.do", method = RequestMethod.POST)
	public String notUsedCpnListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/payment/notUsedCpnListPage";
	}

	@RequestMapping(value = "/payment/selectNotUsedCpnList.do", method = RequestMethod.POST)
	public void selectNotUsedCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectNotUsedCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/payment/settlementDiscardListPage.do", method = RequestMethod.POST)
	public String settlementDiscardListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/payment/settlementDiscardListPage";
	}

	@RequestMapping(value = "/payment/selectSettlementDiscardList.do", method = RequestMethod.POST)
	public void selectSettlementDiscardList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectSettlementDiscardList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/account/createAcntListPage.do", method = RequestMethod.POST)
	public String createAcntListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		}
		return PATH + "/account/createAcntListPage";
	}
	
	@RequestMapping(value = "/account/selectStrAcntList.do", method = RequestMethod.POST)
	public void selectStrAcntList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectStrAcntList(modelMap);
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

	@RequestMapping(value = "/account/createStrAcnt.do", method = RequestMethod.POST)
	public void createStrAcnt(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.insertStrAcnt(modelMap);
			log.debug("ret: " + ret);
			modelMap.addAttribute("ret", ret);
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
	
	@RequestMapping(value = "/account/selectAcntListPage.do", method = RequestMethod.POST)
	public String selectAcntListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		}
		return PATH + "/account/selectAcntListPage";
	}
	
	@RequestMapping(value = "/account/selectAcntList.do", method = RequestMethod.POST)
	public void selectAcntList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectAcntList(modelMap);
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
	
	@RequestMapping(value = "/account/selectAcntInOutListPage.do", method = RequestMethod.POST)
	public String selectAcntInOutListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		if (Flag.flag) {
			List<Map<String,Object>> listStr = this.ara2CtrService.selectStrList(modelMap);
			log.debug("listStr: " + listStr);
			modelMap.addAttribute("listStr", listStr);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
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
			List<Map<String,Object>> list = this.ara2CtrService.selectAcntInOutList(modelMap);
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

	@RequestMapping(value = "/account/insertStrDpstProc.do", method = RequestMethod.POST)
	public void insertStrDpstProc(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.insertStrDpstProc(modelMap);
			log.debug("ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/account/insertStrWthdProc.do", method = RequestMethod.POST)
	public void insertStrWthdProc(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.insertStrWthdProc(modelMap);
			log.debug("ret: " + ret);
			modelMap.addAttribute("ret", ret);
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
	
	@RequestMapping(value = "/manage/manageForTestPage.do", method = RequestMethod.POST)
	public String manageForTestPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/manage/manageForTestPage";
	}

	@RequestMapping(value = "/manage/deleteTablesForOpen.do", method = RequestMethod.POST)
	public void deleteTablesForOpen(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableAcnt(modelMap);
			log.debug("deleteTableAcnt.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableAcnthist(modelMap);
			log.debug("deleteTableAcnthist.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableCamp(modelMap);
			log.debug("deleteTableCamp.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableCpn(modelMap);
			log.debug("deleteTableCpn.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableCnnt(modelMap);
			log.debug("deleteTableCnnt.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableLogin(modelMap);
			log.debug("deleteTableLogin.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/manage/createAllLoginInfo.do", method = RequestMethod.POST)
	public void createAllLoginInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			int ret = this.ara2CtrService.deleteTableLogin(modelMap);
			log.debug("deleteTableLogin.ret: " + ret);
			modelMap.addAttribute("ret", ret);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectAllLoginInfo(modelMap);
			List<String> loginSrch = new ArrayList<>();
			List<String> loginList = new ArrayList<>();
			for (Map<String,Object> map : list) {
				loginSrch.clear();
				loginSrch.add(String.valueOf(map.get("ITM_NM")));
				loginSrch.add(String.valueOf(map.get("MBL_NUM")));
				loginSrch.add(String.valueOf(map.get("EML_ADDR")));
				loginSrch.add(String.valueOf(map.get("MRRG_DT")));
				map.put("loginSrch", StringUtils.join(loginSrch.toArray(new String[loginSrch.size()]), ":"));
				loginList.clear();
				loginList.add(String.valueOf(map.get("ITM_NM")));
				loginList.add(Flag.getPhoneNumberWithMask(String.valueOf(map.get("MBL_NUM"))));
				loginList.add(Flag.getEmailWithMask(String.valueOf(map.get("EML_ADDR"))));
				loginList.add(String.valueOf(map.get("MRRG_DT")));
				map.put("loginList", StringUtils.join(loginList.toArray(new String[loginList.size()]), ":"));
				int ret = this.ara2CtrService.insertLoginInfo(map);
				log.debug("deleteTableLogin.ret: " + ret);
			}
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/manage/selectLikeLoginSrch.do", method = RequestMethod.POST)
	public void selectLikeLoginSrch(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectLikeLoginSrch(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/manage/selectStrListPage.do", method = RequestMethod.POST)
	public String selectStrListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/manage/selectStrListPage";
	}

	@RequestMapping(value = "/manage/selectStrInfoList.do", method = RequestMethod.POST)
	public void selectStrInfoList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectStrInfoList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/manage/selectUsrListPage.do", method = RequestMethod.POST)
	public String selectUsrListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			Map<String,Object> map = this.ara2CtrService.selectItemInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}
		return PATH + "/manage/selectUsrListPage";
	}

	@RequestMapping(value = "/manage/selectUsrInfoList.do", method = RequestMethod.POST)
	public void selectUsrInfoList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			List<Map<String,Object>> list = this.ara2CtrService.selectUsrInfoList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", "성공적으로 처리 되었습니다.");
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
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
}
