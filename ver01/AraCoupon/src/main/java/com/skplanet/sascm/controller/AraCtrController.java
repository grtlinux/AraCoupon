package com.skplanet.sascm.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Enumeration;
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
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.gson.GsonBuilder;
import com.skplanet.sascm.service.AraCtrService;
import com.skplanet.sascm.util.Common;
import com.skplanet.sascm.util.Flag;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping(value = "/ctr")
public class AraCtrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/ctr";

	@Resource(name = "araCtrService")
	private AraCtrService araCtrService;

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
		
		return modelMap;
	}

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
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araCtrService.selectCenterInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/index";
	}

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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
	 * 쿠폰목록 페이지
	 */
	@RequestMapping(value = "/calculate/calcListPage.do", method = RequestMethod.POST)
	public String tempCalcListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
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
	 * 쿠폰목록 자료를 얻어 온다.
	 */
	@RequestMapping(value = "/calculate/selectCalcList.do", method = RequestMethod.POST)
	public void selectTempCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
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

	@RequestMapping(value = "/calculate/listCalculate.do", method = RequestMethod.POST)
	public String listCalculate(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			if (Flag.flag) System.out.println(">>>>> modelMap: " + modelMap);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("ctrid", request.getParameter("ctrid"));
			Map<String,Object> map = this.araCtrService.selectCenterInfo(param);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/calculate/listCalculate";
	}

	@RequestMapping(value = "/calculate/listCalculateList.do", method = RequestMethod.POST)
	public void listCalculateList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			if (Flag.flag) System.out.println(">>>>> modelMap: " + modelMap);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("ctrid", Common.nvl(request.getParameter("ctrid"), "7"));
			List<Map<String,Object>> list = this.araCtrService.listCalculateList(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
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
}
