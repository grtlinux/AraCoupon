package com.skplanet.sascm.controller;

import java.util.Arrays;
import java.util.Enumeration;
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
			Map<String,Object> map = this.araUsrService.selectUserInfo(modelMap);
			log.debug("map: " + map);
			modelMap.addAttribute("info", map);
		}

		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/*
	 * all coupon list page
	 */
	@RequestMapping(value = "/coupon/allCouponListPage.do", method = RequestMethod.POST)
	public String allCouponListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araUsrService.selectUserInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		return PATH + "/coupon/allCouponListPage";
	}

	/*
	 * get all coupon list
	 */
	@RequestMapping(value = "/coupon/selectAllCpnList.do", method = RequestMethod.POST)
	public void selectAllCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araUsrService.selectAllCpnList(modelMap);
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
	 * use coupon list page
	 */
	@RequestMapping(value = "/coupon/useCouponListPage.do", method = RequestMethod.POST)
	public String useCouponListPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			Map<String,Object> map = this.araUsrService.selectUserInfo(modelMap);
			log.debug("map: " + map);
			modelMap.put("info", map);
		}

		return PATH + "/coupon/useCouponListPage";
	}

	/*
	 * get use coupon list
	 */
	@RequestMapping(value = "/coupon/selectUseCpnList.do", method = RequestMethod.POST)
	public void selectUseCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			List<Map<String,Object>> list = this.araUsrService.selectUseCpnList(modelMap);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
		jsonView.render(modelMap, request, response);
	}


	/*
	 * use coupon list
	 */
	@RequestMapping(value = "/coupon/useCpnList.do", method = RequestMethod.POST)
	public void useCpnList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = setModelMap(modelMap, request);
		}

		if (Flag.flag) {
			String[] arrCpnNo = String.valueOf(modelMap.get("arrCpnNo")).split(",");
			modelMap.addAttribute("arrCpnNo", arrCpnNo);
			this.araUsrService.useCpnList(modelMap);
		}

		modelMap.addAttribute("retCode", "0000");
		modelMap.addAttribute("retMsg", "[성공] 성공적으로 처리 되었습니다.");
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
}
