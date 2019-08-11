package kr.co.arajeju.aracoupon2.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.arajeju.aracoupon2.vo.SessionVO;

public interface SessionService {
	
	public Object getSession(HttpServletRequest request, String key) throws Exception;
	public void setSession(HttpServletRequest request, String key, Object obj) throws Exception;

	public SessionVO getSession(HttpServletRequest request) throws Exception;
	public void setSession(HttpServletRequest request, Object obj) throws Exception;
	public Object getMuzSession(HttpServletRequest request, String str) throws Exception;
	public void setMuzSession(HttpServletRequest request, String str, Object obj) throws Exception;
	public void removeMuzSession(HttpServletRequest request) throws Exception;
}
