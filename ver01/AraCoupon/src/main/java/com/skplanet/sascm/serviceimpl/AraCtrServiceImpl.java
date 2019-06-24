package com.skplanet.sascm.serviceimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.AraCtrDAO;
import com.skplanet.sascm.service.AraCtrService;

@Service("araCtrService")
public class AraCtrServiceImpl implements AraCtrService {

	@Resource(name = "araCtrDAO")
	private AraCtrDAO araCtrDAO;

	@Override
	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectCenterInfo(param);
	}

	@Override
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectApprovalReq(param);
	}

	@Override
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectApprovalRes(param);
	}

	@Override
	public Map<String, Object> selectCampaignInfo(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectCampaignInfo(param);
	}

	@Override
	public int insertCouponSheet(Map<String, Object> param) throws SQLException {
		return this.araCtrDAO.insertCouponSheet(param);
	}

	@Override
	public List<Map<String, Object>> listCalculateList(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.listCalculateList(param);
	}
}
