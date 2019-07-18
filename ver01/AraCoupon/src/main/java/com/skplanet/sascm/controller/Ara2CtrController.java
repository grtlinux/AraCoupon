package com.skplanet.sascm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
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
	 * 승인요청 목록 페이지
	 */
	@RequestMapping(value = "/coupon/apprReqListPage.do", method = RequestMethod.POST)
	public String apprReqListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araCtrService.selectCenterInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/coupon/apprReqListPage";
	}

	/*
	 * 승인요청한 자료를 얻는다.
	 */
	@RequestMapping(value = "/coupon/selectApprReqList.do", method = RequestMethod.POST)
	public void selectApprReqList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araCtrService.selectApprReqList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		jsonView.render(modelMap, request, response);
	}

	/*
	 * 승인처리를 한다.
	 */
	@RequestMapping(value = "/coupon/insertCouponPackage.do", method = RequestMethod.POST)
	public void insertCouponPackage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		String[] arrCampId = new String[] {};
		if (Flag.flag) {
			arrCampId = String.valueOf(modelMap.get("campIds")).split(",");
			modelMap.addAttribute("arrCampId", arrCampId);
		}

		if (Flag.flag) {
			// insert ara_apprres
			this.araCtrService.insertApprRes(modelMap);
		}
		
		if (Flag.flag) {
			// insert ara_cpn
			for (int i=0; i < arrCampId.length; i++) {
				modelMap.put("campid", arrCampId[i]);
				Map<String,Object> param = this.araCtrService.selectCampInfoForCpnPkg(modelMap);
				if (Flag.flag) System.out.println(">>>>> param: " + new GsonBuilder().setPrettyPrinting().create().toJson(param));
				
				if (Flag.flag) {
					// insert Coupon Sheet
					String cpnMst = (String) param.get("CPN_MST");
					String cpnTyp = (String) param.get("CPN_TYP");
					int cpnCnt = ((BigDecimal) param.get("CPN_CNT")).intValue();
					for (int cpnNo = 1; cpnNo <= cpnCnt; cpnNo++) {
						param.put("CPN_NO", Flag.getCouponNo(cpnMst, cpnTyp, cpnNo));
						if (!Flag.flag) System.out.println(">>>>> param: " + param);
						this.araCtrService.insertCouponSheet(param);
					}
				}
			}
		}
		
		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 캠페인을 승인했습니다. 쿠폰을 발행했습니다.");
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 승인완료 목록 페이지
	 */
	@RequestMapping(value = "/coupon/apprResListPage.do", method = RequestMethod.POST)
	public String apprResListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araCtrService.selectCenterInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/coupon/apprResListPage";
	}

	/*
	 * 승인완료한 자료를 얻는다.
	 */
	@RequestMapping(value = "/coupon/selectApprResList.do", method = RequestMethod.POST)
	public void selectApprResList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araCtrService.selectApprResList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * 정산 확인을 위한 페이지
	 */
	@RequestMapping(value = "/calculate/calcListPage.do", method = RequestMethod.POST)
	public String calcListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araCtrService.selectCenterInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		return PATH + "/calculate/calcListPage";
	}

	/*
	 * 정산처리 목록을 얻는다.
	 */
	@RequestMapping(value = "/calculate/selectCalcList.do", method = RequestMethod.POST)
	public void selectCalcList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araCtrService.selectCalcList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (!Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

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
