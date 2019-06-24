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

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

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

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/coupon/create.do", method = RequestMethod.GET)
	public String create(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

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

		return PATH + "/coupon/create";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/coupon/approvalReq.do", method = RequestMethod.GET)
	public String approvalReq(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

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

		return PATH + "/coupon/approvalReq";
	}

	@RequestMapping(value = "/coupon/selectApprovalReq.do", method = RequestMethod.POST)
	public void selectApprovalReq(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			List<Map<String,Object>> list = this.araStrService.selectApprovalReq(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

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
