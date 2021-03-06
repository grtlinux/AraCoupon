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

	@Override
	public Map<String, Object> selectCampId(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectCampId(param);
	}

	@Override
	public int insertAraCamp(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertAraCamp(param);
	}

	@Override
	public int insertAraCampInfo(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertAraCampInfo(param);
	}

	@Override
	public int insertAraCampOff(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertAraCampOff(param);
	}

	@Override
	public int insertAraCampChl(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertAraCampChl(param);
	}

	@Override
	public int insertAraOffCpn(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertAraOffCpn(param);
	}

	@Override
	public int insertAraChlSms(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertAraChlSms(param);
	}

	@Override
	public int insertApprReq(Map<String, Object> param) throws Exception {
		return this.araStrDAO.insertApprReq(param);
	}

	@Override
	public List<Map<String,Object>> selectApprReqList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectApprReqList(param);
	}

	@Override
	public List<Map<String,Object>> selectApprResList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectApprResList(param);
	}

	@Override
	public List<Map<String, Object>> selectAllCpnList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectAllCpnList(param);
	}

	@Override
	public List<Map<String, Object>> selectCouponList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectCouponList(param);
	}

	@Override
	public int giveCpnList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.giveCpnList(param);
	}

	@Override
	public List<Map<String, Object>> selectPayCpnList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectPayCpnList(param);
	}

	@Override
	public List<Map<String, Object>> selectNoPayCpnList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectNoPayCpnList(param);
	}

	@Override
	public List<Map<String, Object>> selectTempCalcList(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectTempCalcList(param);
	}
}
