package kr.co.arajeju.aracoupon3.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.service.SessionService;
import kr.co.arajeju.aracoupon3.vo.SessionVO;

@Service
public class SessionServiceImpl implements SessionService {

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	private static final String SESSION = "sessionVo";

	public SessionVO getSessionVo(HttpServletRequest request) throws Exception {
		return (SessionVO) this.getSession(request, SESSION);
	}

	public void setSessionVo(HttpServletRequest request, Object obj) throws Exception {
		this.setSession(request, SESSION, obj);
	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	private static final String ITEM_NO = "itmNo";

	public String getItmNo(HttpServletRequest request) throws Exception {
		return (String) this.getSession(request, ITEM_NO);
	}

	public void setItmNo(HttpServletRequest request, Object obj) throws Exception {
		this.setSession(request, ITEM_NO, obj);
	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	
	public Object getSession(HttpServletRequest request, String key) throws Exception {
		return request.getSession().getAttribute(key);
	}

	public void setSession(HttpServletRequest request, String key, Object obj) throws Exception {
		request.getSession().setAttribute(key, obj);
	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	public void removeSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
	}
}
