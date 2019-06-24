package com.skplanet.sascm.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.AraStrDAO;
import com.skplanet.sascm.service.AraStrService;

@Service("araStrService")
public class AraStrServiceImpl implements AraStrService {

	@Resource(name = "araStrDAO")
	private AraStrDAO araStrDAO;

	@Override
	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectStoreInfo(param);
	}

	@Override
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectApprovalReq(param);
	}

	@Override
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectApprovalRes(param);
	}

	@Override
	public List<Map<String, Object>> giveCouponList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.giveCouponList(param);
	}

	@Override
	public List<Map<String, Object>> listCouponList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.listCouponList(param);
	}

	@Override
	public List<Map<String, Object>> listPaymentList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.listPaymentList(param);
	}

	@Override
	public List<Map<String, Object>> listCalculateList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.listCalculateList(param);
	}
}
