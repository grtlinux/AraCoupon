package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara3CtrDAO;

@SuppressWarnings("unchecked")
@Repository("ara3CtrDAO")
public class Ara3CtrDAOImpl extends AbstractDAO implements Ara3CtrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Ctr.selectItemInfo", param);
	}

	@Override
	public Map<String, Object> selectCampPeriod(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Ctr.selectCampPeriod", param);
	}

	@Override
	public List<Map<String, Object>> selectAraCpnTyp(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectAraCpnTyp", param);
	}

	// /coupon/createCampFormPage.do
	@Override
	public Map<String, Object> selectSeqCampKey(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Ctr.selectSeqCampKey", param);
	}

	@Override
	public int insertCampInfo(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertCampInfo", param);
	}

	// /coupon/executeCampListPage.do
	@Override
	public List<Map<String, Object>> selectCampList1(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectCampList1", param);
	}

	@Override
	public int deleteCampCpnSht(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.deleteCampCpnSht", param);
	}

	@Override
	public Map<String, Object> selectCampNoInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Ctr.selectCampNoInfo", param);
	}

	@Override
	public int insertCampCpnSht(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertCampCpnSht", param);
	}

	@Override
	public int updateCampNoInfo(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Ctr.updateCampNoInfo", param);
	}

	// /coupon/resultCampListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectCampList2", param);
	}

	// /payment/paymentCpnListPage.do
	@Override
	public List<Map<String, Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectPaymentCpnList", param);
	}

	@Override
	public int updateCpnNosPhs(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Ctr.updateCpnNosPhs", param);
	}

	@Override
	public int insertAcntDpst(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertAcntDpst", param);
	}

	// /payment/completeCalcListPage.do
	@Override
	public List<Map<String, Object>> selectCompleteCalcList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectCompleteCalcList", param);
	}

	// /payment/notUsedCpnListPage.do
	@Override
	public List<Map<String, Object>> selectNotUsedCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectNotUsedCpnList", param);
	}

	// /payment/settlementDiscardListPage.do
	@Override
	public List<Map<String, Object>> selectSettlementDiscardList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectSettlementDiscardList", param);
	}


	// /account/createAcntListPage.do
	@Override
	public List<Map<String, Object>> selectStrAcntList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectStrAcntList", param);
	}

	@Override
	public int insertStrAcnt(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertStrAcnt", param);
	}


	// /account/selectAcntListPage.do
	@Override
	public List<Map<String, Object>> selectAcntList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectAcntList", param);
	}


	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectStrList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectStrList", param);
	}

	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectAcntInOutList", param);
	}

	@Override
	public int insertStrDpstProc(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertStrDpstProc", param);
	}

	@Override
	public int insertStrWthdProc(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertStrWthdProc", param);
	}

	// /manage/manageForTestPage.do
	@Override
	public int deleteTableAcnt(Map<String, Object> param) throws Exception {
		return (int) delete("Ara3Ctr.deleteTableAcnt", param);
	}

	@Override
	public int deleteTableAcnthist(Map<String, Object> param) throws Exception {
		return (int) delete("Ara3Ctr.deleteTableAcnthist", param);
	}

	@Override
	public int deleteTableCamp(Map<String, Object> param) throws Exception {
		return (int) delete("Ara3Ctr.deleteTableCamp", param);
	}

	@Override
	public int deleteTableCpn(Map<String, Object> param) throws Exception {
		return (int) delete("Ara3Ctr.deleteTableCpn", param);
	}

	@Override
	public int deleteTableCnnt(Map<String, Object> param) throws Exception {
		return (int) delete("Ara3Ctr.deleteTableCnnt", param);
	}

	@Override
	public int deleteTableLogin(Map<String, Object> param) throws Exception {
		return (int) delete("Ara3Ctr.deleteTableLogin", param);
	}

	@Override
	public List<Map<String, Object>> selectAllLoginInfo(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectAllLoginInfo", param);
	}

	@Override
	public int insertLoginInfo(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ctr.insertLoginInfo", param);
	}

	@Override
	public List<Map<String, Object>> selectLikeLoginSrch(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectLikeLoginSrch", param);
	}

	// /manage/selectStrListPage.do
	@Override
	public List<Map<String, Object>> selectStrInfoList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectStrInfoList", param);
	}

	// /manage/selectUsrListPage.do
	@Override
	public List<Map<String, Object>> selectUsrInfoList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Ctr.selectUsrInfoList", param);
	}
}
