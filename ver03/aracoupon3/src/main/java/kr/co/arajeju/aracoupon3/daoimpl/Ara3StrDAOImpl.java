package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara3StrDAO;

@SuppressWarnings("unchecked")
@Repository("ara3StrDAO")
public class Ara3StrDAOImpl extends AbstractDAO implements Ara3StrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Str.selectItemInfo", param);
	}

	// /coupon/buyCpnListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Str.selectCampList2", param);
	}

	@Override
	public Map<String, Object> selectStrAcntInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Str.selectStrAcntInfo", param);
	}

	@Override
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateBuyCpnSht", param);
	}

	@Override
	public int insertBuyCpnSum(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Str.insertBuyCpnSum", param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Str.selectStateCpnList", param);
	}

	// /coupon/giveCpnListPage.do
	@Override
	public List<Map<String, Object>> selectTrmList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Str.selectTrmList", param);
	}

	@Override
	public List<Map<String, Object>> selectGiveCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Str.selectGiveCpnList", param);
	}

	@Override
	public Map<String, Object> selectUsrInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Str.selectUsrInfo", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateAllCnntByCnntid", param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Str.insertCnntAraKey", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Str.selectCnntArakeyInfo", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateCnntByCnntid", param);
	}

	@Override
	public int updateCpnNo(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateCpnNo", param);
	}

	// /payment/paymentCpnListPage.do
	@Override
	public List<Map<String, Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Str.selectPaymentCpnList", param);
	}

	@Override
	public Map<String, Object> selectCtrInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Str.selectCtrInfo", param);
	}

	@Override
	public int updateAllCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateAllCnntByCnntidOnCtr", param);
	}

	@Override
	public int insertCnntAraKeyOnCtr(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Str.insertCnntAraKeyOnCtr", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfoOnCtr(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Str.selectCnntArakeyInfoOnCtr", param);
	}

	@Override
	public int updateCpnNoListOnCtr(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateCpnNoListOnCtr", param);
	}

	@Override
	public int updateCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Str.updateCnntByCnntidOnCtr", param);
	}

	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Str.selectAcntInOutList", param);
	}
}
