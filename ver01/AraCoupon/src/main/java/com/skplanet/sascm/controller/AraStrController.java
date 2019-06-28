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
import org.springframework.ui.Model;
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
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexGet(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strid", request.getParameter("strid"));
			Map<String,Object> map = this.araStrService.selectStoreInfo(param);
			log.debug("map: " + map);
			model.addAttribute("info", map);
		}

		return PATH + "/index";
	}
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

	@RequestMapping(value = "/coupon/create.do", method = RequestMethod.GET)
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

		return PATH + "/coupon/create";
	}

	@RequestMapping(value = "/coupon/saveCampInfo.do", method = RequestMethod.POST)
	public void saveCampInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			modelMap.put("cpnTyp", ((String)modelMap.get("campCpnTyp")).substring(0,2));
			modelMap.put("frmSeq", 1);
			modelMap.put("toSeq", Integer.parseInt(String.valueOf(modelMap.get("campCpnCnt"))));
		}
		
		if (Flag.flag) {
			// get CAMP_ID
			Map<String,Object> map = this.araStrService.selectCampId(modelMap);
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
		
		if (Flag.flag) {
			modelMap.addAttribute("RET", "[성공] 성공적으로 처리 되었습니다.");
		} else {
			modelMap.addAttribute("RET", "[실패] 처리되지 못했습니다.");
		}
		
		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/coupon/approvalReq.do", method = RequestMethod.POST)
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

		return PATH + "/coupon/approvalReq";
	}

	@RequestMapping(value = "/coupon/selectApprovalReq.do", method = RequestMethod.POST)
	public void selectApprovalReq(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araStrService.selectApprovalReq(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		if (Flag.flag) System.out.println(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/coupon/approvalRes.do", method = RequestMethod.GET)
	public String approvalRes(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strid", request.getParameter("strid"));
			Map<String,Object> map = this.araStrService.selectStoreInfo(param);
			log.debug("map: " + map);
			model.addAttribute("info", map);
		}

		return PATH + "/coupon/approvalRes";
	}

	@RequestMapping(value = "/coupon/selectApprovalRes.do", method = RequestMethod.POST)
	public void selectApprovalRes(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strid", request.getParameter("strid"));
			List<Map<String,Object>> list = this.araStrService.selectApprovalRes(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		jsonView.render(modelMap, request, response);
	}

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
