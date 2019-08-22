package kr.co.arajeju.aracoupon3.common.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.arajeju.aracoupon3.service.ContextService;
import kr.co.arajeju.aracoupon3.service.SessionService;
import kr.co.arajeju.aracoupon3.util.Flag;
import kr.co.arajeju.aracoupon3.vo.SessionVO;

public class ActionInterceptor extends HandlerInterceptorAdapter {
	
	protected Log log = LogFactory.getLog(ActionInterceptor.class);
	
	@Inject
	private SessionService sessionService;

	@Inject
	private ContextService contextService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		// request information
		String url = request.getRequestURI();
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 ====================================== ActionInterceptor START  ======================================");
			log.debug("KANG-20190308 Request URI \t:  " + url);
			log.debug("KANG-20190811" + this.contextService);
		}
		request.setAttribute("araOpenOk", "yes");
		request.setAttribute("xForwardedFor", request.getHeader("X-Forwarded-For"));
		request.setAttribute("remoteAddr", request.getRemoteAddr());
		request.setAttribute("remoteHost", request.getRemoteHost());
		//
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		// sales time
		if (Flag.flag) {
			// 업무시간에 대한 처리를 한다.
			String araNowTime = Flag.getDateTime(this.contextService.getAraSalesType());
			request.setAttribute("araNowTime", araNowTime);
			
			String openTime = this.contextService.getAraSalesOpenTime();
			String closeTime = this.contextService.getAraSalesCloseTime();
			
			if (araNowTime.compareTo(openTime) < 0 || closeTime.compareTo(araNowTime) < 0) {
				// 업무시간이 아니면 접속페이지로 이동한다.
				if (Flag.flag) log.debug(String.format("KANG-20190807 redirect:/index.do   because of not sales time: %s (%s~%s)"
						, araNowTime , openTime , closeTime));
				request.setAttribute("araOpenOk", "no");
				new ModelAndView("redirect:/index.do");
				return super.preHandle(request, response, handler);
			}
		}
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		// session process
		if (!Flag.flag) {
			// session에 대한 처리
			//if (Flag.flag) Flag.printRequestSession(request);

			SessionVO sessionVo = this.sessionService.getSessionVo(request);
			String itmNo = this.sessionService.getItmNo(request);
			if (itmNo != null) {
				// 이전에 로그인 확인됨.
				String itmTyp = sessionVo.getItmTyp();
				switch (itmTyp) {
				case "CTR":
					break;
				case "STR":
					break;
				case "USR":
					break;
				default:
					break;
				}
				this.sessionService.removeSession(request);
			} else {
				// 로그인 안된 상태
				this.sessionService.setSessionVo(request, new SessionVO());
				this.sessionService.setItmNo(request, this.sessionService.getSessionVo(request).getItmNo());
				if (Flag.flag) System.out.println("\t>>>>> 로그인이 안된 상태임. 그래서 로그인 처리를 함...");
			}
			new ModelAndView("redirect:/index.do");
		}
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		// mapping controller
		if (Flag.flag) {
			if (!Flag.flag) {
				// dummy condition
				return true;
			} else if (Flag.flag && url.indexOf("/barcodePage.do") > -1) {             // controller.IndexController
				return true;
			} else if (Flag.flag && url.indexOf("/fileuploadPage.do") > -1) {          // controller.IndexController
				return true;
			} else if (Flag.flag && url.indexOf("/file/") > -1) {                      // controller.UploadController
				return true;
			} else {
				if (Flag.flag) log.debug("KANG-20190807 redirect:/index.do   <- url:" + url);
				new ModelAndView("redirect:/index.do");
			}
		}
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		/*
		if (!Flag.flag) {
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
					if (Flag.flag) log.debug("KANG-20190807 redirect:/index.do   <- url:" + url);
					//throw new ModelAndViewDefiningException(new ModelAndView("redirect:/login.do?url="+url));
					//throw new ModelAndViewDefiningException(new ModelAndView("redirect:/ara2/index.do"));
					new ModelAndView("redirect:/index.do");
				}
			}
		}
		*/
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190308 ====================================== ActionInterceptor END ======================================\n");
		}
	}
}