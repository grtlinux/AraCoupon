package com.skplanet.sascm.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2StrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2StrDAO")
public class Ara2StrDAOImpl extends AbstractDAO implements Ara2StrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectItemInfo", param);
	}

	// /coupon/buyCpnListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectCampList2", param);
	}

	@Override
	public Map<String, Object> selectStrAcntInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectStrAcntInfo", param);
	}

	@Override
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateBuyCpnSht", param);
	}

	@Override
	public int insertBuyCpnSum(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Str.insertBuyCpnSum", param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectStateCpnList", param);
	}

	// /coupon/giveCpnListPage.do
	@Override
	public List<Map<String, Object>> selectTrmList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectTrmList", param);
	}

	@Override
	public List<Map<String, Object>> selectGiveCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectGiveCpnList", param);
	}

	@Override
	public Map<String, Object> selectUsrInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectUsrInfo", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateAllCnntByCnntid", param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Str.insertCnntAraKey", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectCnntArakeyInfo", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateCnntByCnntid", param);
	}

	@Override
	public int updateCpnNo(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateCpnNo", param);
	}

	// /payment/paymentCpnListPage.do
	@Override
	public List<Map<String, Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectPaymentCpnList", param);
	}

	@Override
	public Map<String, Object> selectCtrInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectCtrInfo", param);
	}

	@Override
	public int updateAllCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateAllCnntByCnntidOnCtr", param);
	}

	@Override
	public int insertCnntAraKeyOnCtr(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Str.insertCnntAraKeyOnCtr", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfoOnCtr(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectCnntArakeyInfoOnCtr", param);
	}

	@Override
	public int updateCpnNoListOnCtr(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateCpnNoListOnCtr", param);
	}

	@Override
	public int updateCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateCnntByCnntidOnCtr", param);
	}

	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectAcntInOutList", param);
	}
}
