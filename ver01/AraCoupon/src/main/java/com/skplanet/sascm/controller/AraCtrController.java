package com.skplanet.sascm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skplanet.sascm.service.AraCtrService;
import com.skplanet.sascm.util.Common;
import com.skplanet.sascm.util.Flag;

@Controller
@RequestMapping(value = "/ctr")
public class AraCtrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/ctr";

	@Resource(name = "araCtrService")
	private AraCtrService araCtrService;

	//AJAX
	//@Autowired
	//private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			log.debug("ctrid: " + request.getParameter("ctrid"));
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
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
}
