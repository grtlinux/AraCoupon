package kr.co.arajeju.aracoupon3.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.GsonBuilder;

import kr.co.arajeju.aracoupon3.service.SessionService;
import kr.co.arajeju.aracoupon3.util.Flag;

@Controller
public class IndexController {

	private final Log log = LogFactory.getLog(getClass());

	@SuppressWarnings("unused")
	@Inject
	private SessionService sessionService;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * index.jsp GET
	 */
	@RequestMapping(value = "/index.do", method = {RequestMethod.GET})
	public String indexGet(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		if (Flag.flag) {
			Flag.printRequest(request);
			modelMap = Flag.setModelMap(modelMap, request);
		}
		/*
		if (Flag.flag) {
			String usridSaveYn = (String) this.sessionService.getSession(request, "usridSaveYn");
			if (usridSaveYn != null && "Y".equals(usridSaveYn)) {
				// session.usrid 저장됨
				String usrid = (String) this.sessionService.getSession(request, "usrid");
				modelMap.put("usrid", usrid);
				modelMap.put("usridSaveYn", usridSaveYn);
			} else {
				// session.usrid 미저장
				modelMap.put("usrid", "");
				modelMap.put("usridSaveYn", "N");
			}
		}
		*/
		if (Flag.flag) log.debug(">>>>> modelMap: " + new GsonBuilder().setPrettyPrinting().create().toJson(modelMap));
		return "/ara3/ara/index";
	}
}
