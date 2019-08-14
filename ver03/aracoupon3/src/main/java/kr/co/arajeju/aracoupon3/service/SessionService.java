package kr.co.arajeju.aracoupon3.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.arajeju.aracoupon3.vo.SessionVO;

public interface SessionService {
	
	public SessionVO getSessionVo(HttpServletRequest request) throws Exception;
	public void setSessionVo(HttpServletRequest request, Object obj) throws Exception;
	
	public String getItmNo(HttpServletRequest request) throws Exception;
	public void setItmNo(HttpServletRequest request, Object obj) throws Exception;
	
	public Object getSession(HttpServletRequest request, String key) throws Exception;
	public void setSession(HttpServletRequest request, String key, Object obj) throws Exception;
	public void removeSession(HttpServletRequest request) throws Exception;
}
