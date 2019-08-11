package kr.co.arajeju.aracoupon2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon2.vo.MemberVO;
import kr.co.arajeju.aracoupon2.vo.SessionVO;

/**
 * <pre>
 * kr.co.arajeju.aracoupon3.dao
 * LoginDAO.java
 * </pre>
 *
 * @Author 		: dev
 * @Date		: 2015. 9. 21.
 * @Version	:
 */
@Repository("loginDao")
public class LoginDAO extends AbstractDAO {

	/**
	 * <pre>
	 * Description	:  Login ID/PW 조회
	 * </pre>
	 * @Method Name : getMemberLogin
	 *
	 * @param memberVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SessionVO> getMemberLogin(MemberVO memberVo) throws Exception {
		return (List<SessionVO>) selectList("member.getMemberLogin", memberVo);
	}

	public MemberVO getMemberView(MemberVO memberVo) throws Exception {
		return (MemberVO) selectOne("member.getMemberView", memberVo);
	}
}
