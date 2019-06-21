package com.skplanet.sascm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skplanet.sascm.service.KangService;

@Controller
@RequestMapping(value = "/usr")
public class AraUsrController {

	private final Log log = LogFactory.getLog(getClass());
	
	private static final String PATH = "ara/usr";

	@Resource(name = "kangService")
	private KangService kangService;

	//AJAX
	//@Autowired
	//private MappingJacksonJsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value="/kangJsp01.do", method=RequestMethod.GET)
	public String kangJsp01(Locale locale, Model model) throws Exception {
		model.addAttribute("serverMsg", "Hello, 강석!!! (/kangJsp01.do)");
		return "kang/kangJsp01";
	}

	@RequestMapping(value="/kangRestJsp01.do", method=RequestMethod.GET)
	public String kangRestJsp01(Locale locale, Model model) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("comm_code_id", "");
		param.put("arrKey", new String[] {"C001","C002","PN","PT","OC"});

		List<Map<String, Object>> list = this.kangService.selectCommCodeListOnMap(param);
		model.addAttribute("list", list);
		
		log.info("=============================================");
		log.info("list   : " + list);
		log.info("=============================================");
		
		model.addAttribute("serverMsg", "Hello, 강석!!! (/kangRestJsp01.do)");
		return "kang/kangRestJsp01";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		String msg = this.kangService.getMessage(map);

		model.addAttribute("serverTime", "Hello 강석!!!" + msg);
		return PATH + "/home";
	}

	@RequestMapping(value = "/info.do", method = RequestMethod.GET)
	public String info(Locale locale, Model model) throws Exception {
		return PATH + "/info";
	}
	
	@RequestMapping(value = "/coupon/take.do", method = RequestMethod.GET)
	public String couponTake(Locale locale, Model model) throws Exception {
		return PATH + "/coupon/take";
	}
	
	@RequestMapping(value = "/coupon/list.do", method = RequestMethod.GET)
	public String couponList(Locale locale, Model model) throws Exception {
		return PATH + "/coupon/list";
	}
	
	@RequestMapping(value = "/login/login.do", method = RequestMethod.GET)
	public String loginLogin(Locale locale, Model model) throws Exception {
		return PATH + "/login/login";
	}
	
	@RequestMapping(value = "/login/logout.do", method = RequestMethod.GET)
	public String loginLogout(Locale locale, Model model) throws Exception {
		return PATH + "/login/logout";
	}
	
	@RequestMapping(value = "/login/register.do", method = RequestMethod.GET)
	public String loginRegister(Locale locale, Model model) throws Exception {
		return PATH + "/login/register";
	}
}
