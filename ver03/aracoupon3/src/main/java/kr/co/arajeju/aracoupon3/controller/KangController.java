package kr.co.arajeju.aracoupon3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.GsonBuilder;

import kr.co.arajeju.aracoupon3.util.Flag;

@Controller
public class KangController {

	private final Log log = LogFactory.getLog(getClass());

	//@Inject
	//private SessionService sessionService;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/kang/barcodePage.do", method = {RequestMethod.GET})
	public String barcodePage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/barcodePage";
	}
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/kang/fileuploadPage.do", method = {RequestMethod.GET})
	public String fileuploadPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/fileuploadPage";
	}
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/kang/bootstrap3-01Page.do", method = {RequestMethod.GET})
	public String bootstrap3_01Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> sessionVo = " + modelMap.get("sessionVo"));
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap3-01Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap3-02Page.do", method = {RequestMethod.GET})
	public String bootstrap3_02Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap3-02Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap3-03Page.do", method = {RequestMethod.GET})
	public String bootstrap3_03Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap3-03Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap3-04Page.do", method = {RequestMethod.GET})
	public String bootstrap3_04Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap3-04Page";
	}
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/kang/bootstrap4-01Page.do", method = {RequestMethod.GET})
	public String bootstrap4_01Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap4-01Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap4-02Page.do", method = {RequestMethod.GET})
	public String bootstrap4_02Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap4-02Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap4-03Page.do", method = {RequestMethod.GET})
	public String bootstrap4_03Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap4-03Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap4-04Page.do", method = {RequestMethod.GET})
	public String bootstrap4_04Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap4-04Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap4-05Page.do", method = {RequestMethod.GET})
	public String bootstrap4_05Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap4-05Page";
	}
	//
	@RequestMapping(value = "/kang/bootstrap4-06Page.do", method = {RequestMethod.GET})
	public String bootstrap4_06Page(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/kang/bootstrap4-06Page";
	}
}
