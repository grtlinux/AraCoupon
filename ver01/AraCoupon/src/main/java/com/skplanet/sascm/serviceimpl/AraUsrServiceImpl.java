package com.skplanet.sascm.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.AraUsrDAO;
import com.skplanet.sascm.service.AraUsrService;

@Service("araUsrService")
public class AraUsrServiceImpl implements AraUsrService {

	@Resource(name = "araUsrDAO")
	private AraUsrDAO araUsrDAO;

	@Override
	public Map<String,Object> selectUserInfo(Map<String, Object> param) throws Exception {
		return this.araUsrDAO.selectUserInfo(param);
	}

	@Override
	public List<Map<String, Object>> listCouponList(Map<String, Object> param) throws Exception {
		return this.araUsrDAO.listCouponList(param);
	}

	@Override
	public List<Map<String, Object>> takeCouponList(Map<String, Object> param) throws Exception {
		return this.araUsrDAO.takeCouponList(param);
	}
}
