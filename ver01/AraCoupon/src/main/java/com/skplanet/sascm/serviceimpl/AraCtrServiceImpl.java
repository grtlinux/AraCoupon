package com.skplanet.sascm.serviceimpl;

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
	public List<Map<String,Object>> selectApprReqList(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectApprReqList(param);
	}

	@Override
	public int insertApprRes(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.insertApprRes(param);
	}

	@Override
	public Map<String, Object> selectCampInfoForCpnPkg(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectCampInfoForCpnPkg(param);
	}

	@Override
	public List<Map<String,Object>> selectApprResList(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectApprResList(param);
	}

	
	
	
	@Override
	public int insertCouponSheet(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.insertCouponSheet(param);
	}

	@Override
	public List<Map<String, Object>> selectCalcList(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectCalcList(param);
	}





	@Override
	public List<Map<String, Object>> listCalculateList(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.listCalculateList(param);
	}
}
