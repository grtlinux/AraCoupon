package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.Ara3StrDAO;
import kr.co.arajeju.aracoupon3.service.Ara3StrService;

@Service("ara3StrService")
public class Ara3StrServiceImpl implements Ara3StrService {

	@Resource(name = "ara3StrDAO")
	private Ara3StrDAO ara3StrDAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectItemInfo(param);
	}

	// /coupon/buyCpnListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectCampList2(param);
	}

	@Override
	public Map<String, Object> selectStrAcntInfo(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectStrAcntInfo(param);
	}

	@Override
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateBuyCpnSht(param);
	}

	@Override
	public int insertBuyCpnSum(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.insertBuyCpnSum(param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectStateCpnList(param);
	}

	// /coupon/giveCpnListPage.do
	@Override
	public List<Map<String, Object>> selectTrmList(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectTrmList(param);
	}

	@Override
	public List<Map<String, Object>> selectGiveCpnList(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectGiveCpnList(param);
	}

	@Override
	public Map<String, Object> selectUsrInfo(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectUsrInfo(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.insertCnntAraKey(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectCnntArakeyInfo(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateCnntByCnntid(param);
	}

	@Override
	public int updateCpnNo(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateCpnNo(param);
	}

	// /payment/paymentCpnListPage.do
	@Override
	public List<Map<String, Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectPaymentCpnList(param);
	}

	@Override
	public Map<String, Object> selectCtrInfo(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectCtrInfo(param);
	}

	@Override
	public int updateAllCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateAllCnntByCnntidOnCtr(param);
	}

	@Override
	public int insertCnntAraKeyOnCtr(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.insertCnntAraKeyOnCtr(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfoOnCtr(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectCnntArakeyInfoOnCtr(param);
	}

	@Override
	public int updateCpnNoListOnCtr(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateCpnNoListOnCtr(param);
	}

	@Override
	public int updateCnntByCnntidOnCtr(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.updateCnntByCnntidOnCtr(param);
	}

	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return this.ara3StrDAO.selectAcntInOutList(param);
	}
}
