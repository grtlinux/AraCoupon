package kr.co.arajeju.aracoupon3.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.co.arajeju.aracoupon3.service.Ara2IbService;
import kr.co.arajeju.aracoupon3.util.Flag;
import kr.co.arajeju.aracoupon3.util.IbMsg;

@Controller
@RequestMapping(value = "/ara2/ib")
public class Ara2IbController {

	private final Log log = LogFactory.getLog(getClass());

	private static final String PATH = "ara2/ara";

	@Resource(name = "ara2IbService")
	private Ara2IbService ara2IbService;

	//AJAX
	@Autowired
	private MappingJackson2JsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * index.jsp GET
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexGet(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		return PATH + "/index";
	}

	/*
	 * index.jsp POST
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String indexPost(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		return PATH + "/index";
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	// Ara
	
	@RequestMapping(value = "/selectLastIbTkn.do", method = RequestMethod.POST)
	public void selectLastIbTkn(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		if (Flag.flag) {
			// 이미 진행중인 아라키는 사용하지 못하도록 한다.
			Map<String,Object> map = this.ara2IbService.selectLastIbTkn(null);
			if (map == null || ((BigDecimal) map.get("DIFF_HOURS")).compareTo(new BigDecimal("2")) > 0) {
				log.debug("1. map: " + map);
				log.debug(">>>>> more then 2 hours.....and select new token information....so, insert the infos");
				map = this.ara2IbService.selectAraInfo(null);
				log.debug("2. map: " + map);
				map = IbMsg.getIbTokenInfo(map);
				map.put("tknNm", String.format("to update token at %s", Flag.getDateTime("yyyy-MM-dd HH:mm:ss")));
				map.put("accsTkn", (String) map.get("accessToken"));
				map.put("schm", (String) map.get("schema"));
				map.put("expd", (String) map.get("expired"));
				log.debug("3. map: " + map);
				this.ara2IbService.insertIbTkn(map);
				map = this.ara2IbService.selectLastIbTkn(null);
				log.debug("4. map: " + map);
			} else {
				log.debug(">>>>> less then and equal to 2 hours.....");
				log.debug("1. map: " + map);
			}
			modelMap.addAttribute("info", map);
			
			modelMap.addAttribute("retIbSend", IbMsg.sendIbSms(map));
		}
		if (Flag.flag) {
			modelMap.addAttribute("retCode", "0000");
			modelMap.addAttribute("retMsg", String.format("정상적으로 처리하고 성공적으로 마무리함.", modelMap.get("arakey")));
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
