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

import com.skplanet.sascm.service.AraUsrService;
import com.skplanet.sascm.util.Flag;

@Controller
@RequestMapping(value = "/usr")
public class AraUsrController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/usr";

	@Resource(name = "araUsrService")
	private AraUsrService araUsrService;

	//AJAX
	//@Autowired
	//private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		if (Flag.flag) {
			log.debug("usrid: " + request.getParameter("usrid"));
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
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
}
