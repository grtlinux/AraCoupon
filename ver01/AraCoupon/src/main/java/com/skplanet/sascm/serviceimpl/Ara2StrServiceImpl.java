package com.skplanet.sascm.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.Ara2StrDAO;
import com.skplanet.sascm.service.Ara2StrService;

@Service("ara2StrService")
public class Ara2StrServiceImpl implements Ara2StrService {

	@Resource(name = "ara2StrDAO")
	private Ara2StrDAO ara2StrDAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectItemInfo(param);
	}

	// /coupon/buyCpnListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectCampList2(param);
	}

	@Override
	public Map<String, Object> selectStrAcntInfo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectStrAcntInfo(param);
	}

	@Override
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateBuyCpnSht(param);
	}

	@Override
	public int insertBuyCpnSum(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.insertBuyCpnSum(param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectStateCpnList(param);
	}

	// /coupon/giveCpnListPage.do
	@Override
	public List<Map<String, Object>> selectGiveCpnList(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectGiveCpnList(param);
	}

	@Override
	public Map<String, Object> selectUsrInfo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectUsrInfo(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.insertCnntAraKey(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectCnntArakeyInfo(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateCnntByCnntid(param);
	}

	@Override
	public int updateCpnNo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateCpnNo(param);
	}

	// /payment/paymentCpnListPage.do
	@Override
	public List<Map<String, Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectPaymentCpnList(param);
	}

	@Override
	public Map<String, Object> selectCtrInfo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectCtrInfo(param);
	}

	@Override
	public int updateAllCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateAllCnntByCnntidOnCtr(param);
	}

	@Override
	public int insertCnntAraKeyOnCtr(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.insertCnntAraKeyOnCtr(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfoOnCtr(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectCnntArakeyInfoOnCtr(param);
	}

	@Override
	public int updateCpnNoListOnCtr(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateCpnNoListOnCtr(param);
	}

	@Override
	public int updateCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateCnntByCnntidOnCtr(param);
	}

	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectAcntInOutList(param);
	}
}
