package com.skplanet.sascm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skplanet.sascm.service.AraCtrService;
import com.skplanet.sascm.util.Flag;

@Controller
public class AraController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara";

	@Resource(name = "araCtrService")
	private AraCtrService araCtrService;

	//AJAX
	//@Autowired
	//private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/ara.do", method = RequestMethod.GET)
	public String araGet(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 Request URI \t:  " + request.getRequestURI());
		}

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		return PATH + "/index";
	}

	@RequestMapping(value = "/ara.do", method = RequestMethod.POST)
	public String araPost(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 Request URI \t:  " + request.getRequestURI());
		}

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		return PATH + "/index";
	}

	@RequestMapping(value = "/araUsr.do", method = RequestMethod.POST)
	public ModelAndView araUsr(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 Request URI \t:  " + request.getRequestURI());
		}

		if (Flag.flag) {
			Flag.printRequest(request);
		}

		//return "redirect:/usr/index.do?usrid=2";
		return new ModelAndView("redirect:/usr/index.do?usrid=2");
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
}
