package com.skplanet.sascm.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2CtrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2CtrDAO")
public class Ara2CtrDAOImpl extends AbstractDAO implements Ara2CtrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ctr.selectItemInfo", param);
	}

	@Override
	public Map<String, Object> selectCampPeriod(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ctr.selectCampPeriod", param);
	}

	@Override
	public List<Map<String, Object>> selectAraCpnTyp(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectAraCpnTyp", param);
	}

	// /coupon/createCampFormPage.do
	@Override
	public Map<String, Object> selectSeqCampKey(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ctr.selectSeqCampKey", param);
	}

	@Override
	public int insertCampInfo(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ctr.insertCampInfo", param);
	}

	// /coupon/executeCampListPage.do
	@Override
	public List<Map<String, Object>> selectCampList1(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectCampList1", param);
	}

	@Override
	public int deleteCampCpnSht(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ctr.deleteCampCpnSht", param);
	}

	@Override
	public Map<String, Object> selectCampNoInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ctr.selectCampNoInfo", param);
	}

	@Override
	public int insertCampCpnSht(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ctr.insertCampCpnSht", param);
	}

	@Override
	public int updateCampNoInfo(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Ctr.updateCampNoInfo", param);
	}

	// /coupon/resultCampListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectCampList2", param);
	}

	// /payment/paymentCpnListPage.do


	// /account/createAcntListPage.do
	@Override
	public List<Map<String, Object>> selectStrAcntList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectStrAcntList", param);
	}

	@Override
	public int insertStrAcnt(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ctr.insertStrAcnt", param);
	}


	// /account/selectAcntListPage.do
	@Override
	public List<Map<String, Object>> selectAcntList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectAcntList", param);
	}


	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectStrList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectStrList", param);
	}

	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Ctr.selectAcntInOutList", param);
	}

	@Override
	public int insertStrDpstProc(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ctr.insertStrDpstProc", param);
	}

	@Override
	public int insertStrWthdProc(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ctr.insertStrWthdProc", param);
	}

}
