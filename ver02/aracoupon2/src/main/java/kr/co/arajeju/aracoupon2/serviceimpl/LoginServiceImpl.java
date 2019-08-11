package kr.co.arajeju.aracoupon2.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon2.dao.LoginDAO;
import kr.co.arajeju.aracoupon2.service.LoginService;
import kr.co.arajeju.aracoupon2.vo.MemberVO;
import kr.co.arajeju.aracoupon2.vo.SessionVO;

/**
 * <pre>
 * kr.co.arajeju.aracoupon3.login.service
 * LoginServiceImpl.java
 * </pre>
 *
 * @Author 		: dev
 * @Date		: 2015. 9. 21.
 * @Version	:
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDao;

	public List<SessionVO> getLoginInfo(MemberVO memberVo) throws Exception {
		return (List<SessionVO>) this.loginDao.getMemberLogin(memberVo);
	}

	public MemberVO getMemberView(MemberVO memberVo) throws Exception {
		return (MemberVO) this.loginDao.getMemberView(memberVo);
	}
}
