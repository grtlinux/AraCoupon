package kr.co.arajeju.aracoupon3.service;

import java.util.List;

import kr.co.arajeju.aracoupon3.vo.MemberVO;
import kr.co.arajeju.aracoupon3.vo.SessionVO;

/**
 * <pre>
 * com.skplanet.sascm.login.service
 * LoginService.java
 * </pre>
 *
 * @Author 		: dev
 * @Date		: 2015. 9. 21.
 * @Version	:
 */
public interface LoginService {
	/**
	 * <pre>
	 * Description	:  Login ID/PW DB 조회
	 * </pre>
	 * @Method Name : getLoginInfo
	 *
	 * @param memberVo
	 * @return
	 * @throws Exception
	 */
	public List<SessionVO> getLoginInfo(MemberVO memberVo) throws Exception;
	public MemberVO getMemberView(MemberVO memberVo) throws Exception;
}
