package kr.co.arajeju.aracoupon2.common.interceptor;

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

import kr.co.arajeju.aracoupon2.service.SessionService;
import kr.co.arajeju.aracoupon2.util.Flag;
import kr.co.arajeju.aracoupon2.vo.SessionVO;

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

	// ara.db.backup.time = 23:30
	@Value("#{contextProperties['ara.db.backup.time']}")
	private String araDbBackupTime;

	// ara.file.base.path1       = ${HOME}
	@Value("#{contextProperties['ara.file.base.path1']}")
	private String araFileBasePath1;

	// ara.file.base.path2       = ${basedir}
	@Value("#{contextProperties['ara.file.base.path2']}")
	private String araFileBasePath2;

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

		if (Flag.flag) {
			if (!Flag.flag) {
				if (Flag.flag) System.getProperties().forEach((k,v) -> System.out.println("\tProperty [" + k + ":" + v + "]"));
				if (Flag.flag) System.getenv().forEach((k,v) -> System.out.println("\tEnv [" + k + ":" + v + "]"));
			}
			// ara.file.base.path1       = ${HOME}
			if (araFileBasePath1.indexOf("${HOME}") > -1) {
				this.araFileBasePath1 = this.araFileBasePath1.replaceAll("\\$\\{HOME\\}", System.getenv("HOME"));
			} else if (araFileBasePath1.indexOf("${user.home}") > -1) {
				this.araFileBasePath1 = this.araFileBasePath1.replaceAll("\\$\\{user.home\\}", System.getProperty("user.home", "null"));
			}
			// ara.file.base.path2       = ${user.home}
			if (araFileBasePath2.indexOf("${HOME}") > -1) {
				this.araFileBasePath2 = this.araFileBasePath2.replaceAll("\\$\\{HOME\\}", System.getenv("HOME"));
			} else if (araFileBasePath2.indexOf("${user.home}") > -1) {
				this.araFileBasePath2 = this.araFileBasePath2.replaceAll("\\$\\{user.home\\}", System.getProperty("user.home", "null"));
			}
		}
		request.setAttribute("staticURL", this.staticURL);
		request.setAttribute("staticPATH", this.staticPATH);
		request.setAttribute("staticPATHSasurl", this.staticPATHSasurl);
		request.setAttribute("staticPATHSvaurl", this.staticPATHSvaurl);
		request.setAttribute("staticServerType", this.staticServerType);
		request.setAttribute("staticServerTypeAprvid", this.staticServerTypeAprvid);
		request.setAttribute("araSalesType", this.araSalesType);
		request.setAttribute("araSalesOpenTime", this.araSalesOpenTime);
		request.setAttribute("araSalesCloseTime", this.araSalesCloseTime);
		request.setAttribute("araDbBackupTime", this.araDbBackupTime);
		request.setAttribute("araSalesOk", "yes");
		request.setAttribute("araFileBasePath1", this.araFileBasePath1);
		request.setAttribute("araFileBasePath2", this.araFileBasePath2);
		request.setAttribute("xForwardedFor", request.getHeader("X-Forwarded-For"));
		request.setAttribute("remoteAddr", request.getRemoteAddr());
		request.setAttribute("remoteHost", request.getRemoteHost());

		if (Flag.flag) {
			// 업무시간에 대한 처리를 한다.
			String araNowTime = Flag.getDateTime(araSalesType);
			request.setAttribute("araNowTime", araNowTime);
			
			if (araNowTime.compareTo(araSalesOpenTime) < 0 || araSalesCloseTime.compareTo(araNowTime) < 0) {
				// 업무시간이 아니면 접속페이지로 이동한다.
				if (Flag.flag) log.debug(String.format("KANG-20190807 redirect:/ara2/index.do   because of not sales time: %s (%s~%s)", araNowTime, araSalesOpenTime, araSalesCloseTime));
				request.setAttribute("araSalesOk", "no");
				new ModelAndView("redirect:/ara2/index.do");
				return super.preHandle(request, response, handler);
			}
		}
		
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
			if (Flag.flag) {
				Integer count = (Integer) this.sessionService.getSession(request, "count");
				if (count == null) {
					count = 100;
					this.sessionService.setSession(request, "count", count);
				} else {
					count ++;
					this.sessionService.setSession(request, "count", count);
				}
				log.debug("KANG-20190808 session.count \t:  " + count);
			}
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
			//} else if (url.equals("/index.do")) {
			//	if (Flag.flag) log.debug("KANG-20190807 redirect:/ara2/index.do");
			//	new ModelAndView("redirect:/ara2/index.do");
			} else if (url.indexOf("/file/") > -1) {                // controller.UploadController
				return true;
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
				if (Flag.flag) log.debug("KANG-20190807 redirect:/ara2/index.do   <- url:" + url);
				//throw new ModelAndViewDefiningException(new ModelAndView("redirect:/login.do?url="+url));
				//throw new ModelAndViewDefiningException(new ModelAndView("redirect:/ara2/index.do"));
				new ModelAndView("redirect:/ara2/index.do");
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