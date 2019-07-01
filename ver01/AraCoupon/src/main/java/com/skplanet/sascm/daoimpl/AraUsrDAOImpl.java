package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraUsrDAO;

@SuppressWarnings("unchecked")
@Repository("araUsrDAO")
public class AraUsrDAOImpl extends AbstractDAO implements AraUsrDAO {

	@Override
	public List<Map<String, Object>> listCouponList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) this.selectList("AraUsr.listCouponList", param);
	}

	@Override
	public List<Map<String, Object>> takeCouponList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) this.selectList("AraUsr.takeCouponList", param);
	}




	@Override
	public Map<String,Object> selectUserInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) this.selectOne("AraUsr.selectUserInfo", param);
	}

	@Override
	public List<Map<String, Object>> selectAllCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) this.selectList("AraUsr.selectAllCpnList", param);
	}

	@Override
	public List<Map<String, Object>> selectUseCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) this.selectList("AraUsr.selectUseCpnList", param);
	}

	@Override
	public int useCpnList(Map<String, Object> param) throws Exception {
		return (int) this.update("AraUsr.useCpnList", param);
	}
}
