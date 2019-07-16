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
