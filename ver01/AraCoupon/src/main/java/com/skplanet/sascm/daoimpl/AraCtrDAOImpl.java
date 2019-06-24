package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraCtrDAO;

@SuppressWarnings("unchecked")
@Repository("araCtrDAO")
public class AraCtrDAOImpl extends AbstractDAO implements AraCtrDAO {

	@Override
	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraCtr.selectCenterInfo", param);
	}
	
	@Override
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraCtr.selectApprovalReq", param);
	}

	@Override
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraCtr.selectApprovalRes", param);
	}

	@Override
	public Map<String, Object> selectCampaignInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraCtr.selectCampaignInfo", param);
	}

	@Override
	public int insertCouponSheet(Map<String, Object> param) throws SQLException {
		return (int) insert("AraCtr.insertCouponSheet", param);
	}

	@Override
	public List<Map<String, Object>> listCalculateList(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraCtr.listCalculateList", param);
	}
}
