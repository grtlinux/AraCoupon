package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraStrDAO;

@SuppressWarnings("unchecked")
@Repository("araStrDAO")
public class AraStrDAOImpl extends AbstractDAO implements AraStrDAO {

	@Override
	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraStr.selectStoreInfo", param);
	}
	
	@Override
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraStr.selectApprovalReq", param);
	}

	@Override
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraStr.selectApprovalRes", param);
	}

	@Override
	public List<Map<String, Object>> giveCouponList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.giveCouponList", param);
	}

	@Override
	public List<Map<String, Object>> listCouponList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.listCouponList", param);
	}

	@Override
	public List<Map<String, Object>> listPaymentList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.listPaymentList", param);
	}

	@Override
	public List<Map<String, Object>> listCalculateList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.listCalculateList", param);
	}
}
