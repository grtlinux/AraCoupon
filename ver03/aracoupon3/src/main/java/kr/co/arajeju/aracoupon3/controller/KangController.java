package kr.co.arajeju.aracoupon3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.co.arajeju.aracoupon3.object.CampaignListBO;
import kr.co.arajeju.aracoupon3.service.KangService;
import kr.co.arajeju.aracoupon3.util.Common;

@Controller
@RequestMapping(value = "/kang")
public class KangController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara/usr";

	@Resource(name = "kangService")
	private KangService kangService;

	//AJAX
	@Autowired
	private MappingJackson2JsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Locale locale, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		String msg = this.kangService.getMessage(map);
		model.addAttribute("serverTime", "Hello 강석!!!" + msg);

		return "kang/index";
	}

	@RequestMapping(value = "/getIndex.do", method = RequestMethod.POST)
	public void getIndex(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		Map<String,Object> mapRet = new HashMap<>();

		if (true) {
			Map<String, Object> map = new HashMap<>();
			map.put("serverType", request.getParameter("serverType"));
			map.put("key01", Common.nvl(request.getParameter("key01"), "VAL01"));
			map.put("key02", Common.nvl(request.getParameter("key02"), "VAL02"));

			//paramter
			log.info("=============================================");
			log.info("serverType    : " + request.getParameter("serverType"));
			log.info("key01         : " + request.getParameter("key01"));
			log.info("key02         : " + request.getParameter("key02"));
			log.info("=============================================");

			mapRet.put("serverType", request.getParameter("serverType"));
			mapRet.put("key01", Common.nvl(request.getParameter("key01"), "VAL01"));
			mapRet.put("key02", Common.nvl(request.getParameter("key02"), "VAL02"));
			mapRet.put("map", map);
		}

		if (true) {
			Map<String, Object> param = new HashMap<>();
			param.put("comm_code_id", "");
			param.put("arrKey", new String[] {"C001","C002","PN","PT","OC"});

			List<Map<String, Object>> list = this.kangService.selectCommCodeListOnMap(param);
			mapRet.put("list", list);
		}


		log.info("=============================================");
		log.info("mapRet           : " + mapRet);
		log.info("=============================================");

		jsonView.render(mapRet, request, response);
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

		//log.info("=============================================");
		//log.info("list   : " + list);
		//log.info("=============================================");

		model.addAttribute("serverMsg", "Hello, 강석!!! (/kangRestJsp01.do)");
		return "kang/kangRestJsp01";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/kangList.do", method = RequestMethod.GET)
	public void kangList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serverType", request.getParameter("serverType"));


		//공통코드 목록 조회
		List<CampaignListBO> list = null; // campaignInfoService.getCampaignFolderList(map);

		log.info("=============================================");
		log.info("list   : " + list);
		log.info("=============================================");

		map.put("CampaignFolder", list);
		jsonView.render(map, request, response);
	}

	@RequestMapping(value = "/kang.do", method = RequestMethod.GET)
	public String kang(Locale locale, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		String msg = this.kangService.getMessage(map);

		model.addAttribute("serverTime", "Hello 강석!!!" + msg);
		return "kang/kang";
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

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/index2.do", method = RequestMethod.GET)
	public String index2(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		String msg = this.kangService.getMessage(map);
		modelMap.addAttribute("serverTime", "Hello 강석!!!" + msg);

		return "kang/index2";
	}

}
