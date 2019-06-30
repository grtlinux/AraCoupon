package com.skplanet.sascm.controller;

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
import com.skplanet.sascm.service.AraStrService;
import com.skplanet.sascm.util.Common;
import com.skplanet.sascm.util.Flag;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping(value = "/str")
public class AraStrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/str";

	@Resource(name = "araStrService")
	private AraStrService araStrService;

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
			Map<String,Object> map = this.araStrService.selectStoreInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/index";
	}

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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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
	@RequestMapping(value = "/coupon/apprResListPage.do", method = RequestMethod.GET)
	public String approvalRes(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
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
			modelMap = setModelMap(modelMap, request);
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

	@RequestMapping(value = "/provide/giveCoupon.do", method = RequestMethod.GET)
	public String giveCoupon(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("strid", request.getParameter("strid"));
			Map<String,Object> map = this.araStrService.selectStoreInfo(param);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/provide/giveCoupon";
	}

	@RequestMapping(value = "/provide/giveCouponList.do", method = RequestMethod.POST)
	public void giveCouponList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("strid", Common.nvl(request.getParameter("strid"), "7"));
			List<Map<String,Object>> list = this.araStrService.giveCouponList(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/provide/listCoupon.do", method = RequestMethod.GET)
	public String listCoupon(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("strid", request.getParameter("strid"));
			Map<String,Object> map = this.araStrService.selectStoreInfo(param);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/provide/listCoupon";
	}

	@RequestMapping(value = "/provide/listCouponList.do", method = RequestMethod.POST)
	public void listCouponList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("strid", Common.nvl(request.getParameter("strid"), "7"));
			List<Map<String,Object>> list = this.araStrService.listCouponList(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/payment/listPayment.do", method = RequestMethod.GET)
	public String listPayment(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("strid", request.getParameter("strid"));
			Map<String,Object> map = this.araStrService.selectStoreInfo(param);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/payment/listPayment";
	}

	@RequestMapping(value = "/payment/listPaymentList.do", method = RequestMethod.POST)
	public void listPaymentList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("strid", Common.nvl(request.getParameter("strid"), "7"));
			List<Map<String,Object>> list = this.araStrService.listPaymentList(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/calculate/listCalculate.do", method = RequestMethod.GET)
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
			param.put("strid", request.getParameter("strid"));
			Map<String,Object> map = this.araStrService.selectStoreInfo(param);
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
			param.put("strid", Common.nvl(request.getParameter("strid"), "7"));
			List<Map<String,Object>> list = this.araStrService.listCalculateList(param);
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
