package kr.co.arajeju.aracoupon3.common.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.arajeju.aracoupon3.service.SessionService;
import kr.co.arajeju.aracoupon3.util.Flag;
import kr.co.arajeju.aracoupon3.vo.SessionVO;

public class ActionInterceptor extends HandlerInterceptorAdapter {
	
	protected Log log = LogFactory.getLog(ActionInterceptor.class);

	// server.static.url = http://localhost
	@Value("#{contextProperties['server.static.url']}")
	private String staticURL;

	@Value("#{contextProperties['server.static.path']}")
	private String staticPATH;

	// server.static.url.sasurl = http://11campb-operwb-alp01:7980
	@Value("#{contextProperties['server.static.url.sasurl']}")
	private String staticPATHSasurl;

	// server.static.vaurl=http://11campb-operwb-alp01:7980
	@Value("#{contextProperties['server.static.vaurl']}")
	private String staticPATHSvaurl;

	// server.type.chk = DEV
	@Value("#{contextProperties['server.type.chk']}")
	private String staticServerType;

	// server.type.aprvid = admin
	@Value("#{contextProperties['server.type.aprvid']}")
	private String staticServerTypeAprvid;

	// ara.sales.type       = HH:mm
	@Value("#{contextProperties['ara.sales.type']}")
	private String araSalesType;

	// ara.sales.open.time  = 04:00
	@Value("#{contextProperties['ara.sales.open.time']}")
	private String araSalesOpenTime;

	// ara.sales.close.time = 23:00
	@Value("#{contextProperties['ara.sales.close.time']}")
	private String araSalesCloseTime;


	@Inject
	private SessionService sessionService;

	private static final String CMM_CODE = "USER000099";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 ====================================== ActionInterceptor START  ======================================");
			log.debug("KANG-20190308 Request URI \t:  " + url);
		}

		request.setAttribute("staticURL", staticURL);
		request.setAttribute("staticPATH", staticPATH);
		request.setAttribute("staticPATHSasurl", staticPATHSasurl);
		request.setAttribute("staticPATHSvaurl", staticPATHSvaurl);
		request.setAttribute("staticServerType", staticServerType);
		request.setAttribute("staticServerTypeAprvid", staticServerTypeAprvid);
		request.setAttribute("araSalesType", araSalesType);
		request.setAttribute("araSalesOpenTime", araSalesOpenTime);
		request.setAttribute("araSalesCloseTime", araSalesCloseTime);

		// 저장된 sessionVo
		SessionVO sessionVo = this.sessionService.getSession(request);

		// session
		HttpSession session = request.getSession(false);
		if (session == null) {
			if (Flag.flag) System.out.println("KANG-20190308: >>>>> session is null!!!");
		} else if (session.getAttribute("ACCOUNT") != null) {
			String account = (String) session.getAttribute("ACCOUNT");
			log.debug("KANG-20190308 session.ACCOUNT \t:  " + account);
			if (sessionVo.getUserType().indexOf(CMM_CODE) == -1) {
				this.sessionService.removeMuzSession(request);
				throw new ModelAndViewDefiningException(new ModelAndView("redirect:/autherror.do"));
			}
			if (url.indexOf("/login.do") > -1) {
				new ModelAndView("redirect:/main.do");
			}
		} else {
			// no authentication
			if (url.indexOf("/login.do") > -1) {                    // controller.LoginController
				return true;
			} else if (url.indexOf("/ajax_login_proc.do") > -1) {   // controller.LoginController
				return true;
			} else if (url.indexOf("/loginReload.do") > -1) {       // controller.LoginController
				return true;
			} else if (url.indexOf("/autherror.do") > -1) {         // controller.LoginController
				return true;
			//} else if (url.indexOf("/notice/getNoticeList.do") > -1) {
			//	return true;
			//} else if (url.indexOf("/callCopyCoupon.do") > -1) {
			//	return true;
			} else if (url.indexOf("/kang/") > -1) {                // controller.KangController
				return true;
			} else if (url.indexOf("/ara2/") > -1) {                // controller.Ara2Controller
				return true;
			} else if (url.indexOf("/ctr2/") > -1) {                // controller.Ctr2Controller
				return true;
			} else if (url.indexOf("/str2/") > -1) {                // controller.Str2Controller
				return true;
			} else if (url.indexOf("/usr2/") > -1) {                // controller.Usr2Controller
				return true;
			} else {
				//throw new ModelAndViewDefiningException(new ModelAndView("redirect:/login.do?url="+url));
				throw new ModelAndViewDefiningException(new ModelAndView("redirect:/ara2/index.do"));
			}
		}

		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 ====================================== ActionInterceptor END ======================================\n");
		}
	}
}