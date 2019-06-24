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

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		if (Flag.flag) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("ctrid", Common.nvl(request.getParameter("ctrid"), "01"));
			log.debug("param: " + param);
			Map<String,Object> map = this.araCtrService.selectCenterInfo(param);
			log.debug("map: " + map);
			model.addAttribute("info", map);
		}

		return PATH + "/index";
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
			param.put("ctrid", Common.nvl(request.getParameter("ctrid"), "01"));
			Map<String,Object> map = this.araCtrService.selectCenterInfo(param);
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
			param.put("ctrid", Common.nvl(request.getParameter("ctrid"), "01"));
			List<Map<String,Object>> list = this.araCtrService.selectApprovalReq(param);
			log.debug("list: " + list);
			modelMap.addAttribute("list", list);
		}

		jsonView.render(modelMap, request, response);
	}

	@RequestMapping(value = "/coupon/insertCouponPackage.do", method = RequestMethod.POST)
	public void insertCouponPackage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

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
			System.out.println(">>>>> modelMap: " + modelMap);
		}

		Map<String, Object> param = new HashMap<String, Object>();
		String cpnMst = "";
		int frmSeq = 0;
		int toSeq = 0;
		if (Flag.flag) {
			/* AraCtr.selectCampaignInfo */
			param.put("campid", Common.nvl(request.getParameter("campid"), "1"));
			Map<String,Object> map = this.araCtrService.selectCampaignInfo(param);
			log.debug("map: " + map);
			
			frmSeq = Integer.parseInt(String.valueOf(map.get("FRM_SEQ")));
			toSeq = Integer.parseInt(String.valueOf(map.get("TO_SEQ")));
			
			cpnMst = String.format("%02d%03d%s%d%s"
					, Integer.parseInt(String.valueOf(map.get("CTR_ID")))
					, Integer.parseInt(String.valueOf(map.get("STR_ID")))
					, Flag.getYYYYMMDD()
					, 1
					, (String) map.get("CPN_TYP")
					);
			param.put("str_id"    , map.get("STR_ID"));
			param.put("camp_id"   , map.get("CAMP_ID"));
			param.put("usr_id"    , -1);
			param.put("usd_str_id", -1);
			param.put("cpn_typ"   , (String) map.get("CPN_TYP"));
			param.put("cpn_phs"   , "1");
			param.put("cpn_mst"   , cpnMst);
			param.put("cpn_no"    , Flag.getCouponNo(cpnMst, 123));
			System.out.println(">>>>> param: " + param);
		}

		if (Flag.flag) {
			/* AraCtr.insertCouponSheet */
			//	#{str_id}         /* STR_ID     */
			//	, #{camp_id}      /* CAMP_ID    */
			//	, #{usr_id}       /* USR_ID     */
			//	, #{usd_str_id}   /* USD_STR_ID */
			//	, #{cpn_typ}      /* CPN_TYP    */
			//	, #{cpn_phs}      /* CPN_PHS    */
			//	, #{cpn_no}       /* CPN_NO     */
			for (int seq=frmSeq; 0 < seq && seq <= toSeq; seq++) {
				param.put("cpn_no", Flag.getCouponNo(cpnMst, seq));
				this.araCtrService.insertCouponSheet(param);
			}
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
			param.put("ctrid", Common.nvl(request.getParameter("ctrid"), "01"));
			Map<String,Object> map = this.araCtrService.selectCenterInfo(param);
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
			param.put("ctrid", Common.nvl(request.getParameter("ctrid"), "01"));
			List<Map<String,Object>> list = this.araCtrService.selectApprovalRes(param);
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
