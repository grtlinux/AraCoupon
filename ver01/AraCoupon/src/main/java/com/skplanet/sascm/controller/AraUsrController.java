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

import com.skplanet.sascm.service.AraUsrService;
import com.skplanet.sascm.util.Flag;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping(value = "/usr")
public class AraUsrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/usr";

	@Resource(name = "araUsrService")
	private AraUsrService araUsrService;

	//AJAX
	@Autowired
	private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexGet(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("usrid", request.getParameter("usrid"));
			Map<String,Object> map = this.araUsrService.selectUserInfo(param);
			log.debug("map: " + map);
			model.addAttribute("info", map);
		}

		return PATH + "/index";
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String indexPost(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("usrid", request.getParameter("usrid"));
			Map<String,Object> map = this.araUsrService.selectUserInfo(param);
			log.debug("map: " + map);
			model.addAttribute("info", map);
		}

		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/coupon/takeCoupon.do", method = RequestMethod.GET)
	public String takeCoupon(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("usrid", request.getParameter("usrid"));
			Map<String,Object> map = this.araUsrService.selectUserInfo(param);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/coupon/takeCoupon";
	}

	@RequestMapping(value = "/coupon/takeCouponList.do", method = RequestMethod.POST)
	public void takeCouponList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			param.put("usrid", request.getParameter("usrid"));
			List<Map<String,Object>> list = this.araUsrService.takeCouponList(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		jsonView.render(modelMap, request, response);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/coupon/listCoupon.do", method = RequestMethod.GET)
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
			param.put("usrid", request.getParameter("usrid"));
			Map<String,Object> map = this.araUsrService.selectUserInfo(param);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/coupon/listCoupon";
	}

	@RequestMapping(value = "/coupon/listCouponList.do", method = RequestMethod.POST)
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
			param.put("usrid", request.getParameter("usrid"));
			List<Map<String,Object>> list = this.araUsrService.listCouponList(param);
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
