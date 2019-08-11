package kr.co.arajeju.aracoupon2.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon2.service.SessionService;
import kr.co.arajeju.aracoupon2.vo.SessionVO;

@Service
public class SessionServiceImpl implements SessionService {

	//////////////////////////////////////////////////////////////
	public Object getSession(HttpServletRequest request, String key) throws Exception {
		return request.getSession().getAttribute(key);
	}

	public void setSession(HttpServletRequest request, String key, Object obj) throws Exception {
		request.getSession().setAttribute(key, obj);
	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	// session object key name
	private static final String SESSION = "sessionVo";

	//////////////////////////////////////////////////////////////
	public SessionVO getSession(HttpServletRequest request) throws Exception {
		return (SessionVO) getMuzSession(request, SESSION);
	}

	public void setSession(HttpServletRequest request, Object obj) throws Exception {
		setMuzSession(request, SESSION, obj);
	}

	//////////////////////////////////////////////////////////////
	public Object getMuzSession(HttpServletRequest request, String str) throws Exception {
		return request.getSession().getAttribute(str);
	}

	public void setMuzSession(HttpServletRequest request, String str, Object obj) throws Exception {
		request.getSession().setAttribute(str, obj);
	}

	//////////////////////////////////////////////////////////////
	public void removeMuzSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
	}
}
