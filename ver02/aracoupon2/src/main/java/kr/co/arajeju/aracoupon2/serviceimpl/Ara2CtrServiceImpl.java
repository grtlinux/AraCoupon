package kr.co.arajeju.aracoupon2.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon2.dao.Ara2CtrDAO;
import kr.co.arajeju.aracoupon2.service.Ara2CtrService;

@Service("ara2CtrService")
public class Ara2CtrServiceImpl implements Ara2CtrService {

	@Resource(name = "ara2CtrDAO")
	private Ara2CtrDAO ara2CtrDAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectItemInfo(param);
	}

	@Override
	public Map<String, Object> selectCampPeriod(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectCampPeriod(param);
	}

	@Override
	public List<Map<String, Object>> selectAraCpnTyp(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectAraCpnTyp(param);
	}

	// /coupon/createCampFormPage.do
	@Override
	public Map<String, Object> selectSeqCampKey(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectSeqCampKey(param);
	}

	@Override
	public int insertCampInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertCampInfo(param);
	}

	// /coupon/executeCampListPage.do
	@Override
	public List<Map<String, Object>> selectCampList1(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectCampList1(param);
	}

	@Override
	public int deleteCampCpnSht(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteCampCpnSht(param);
	}

	@Override
	public Map<String, Object> selectCampNoInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectCampNoInfo(param);
	}

	@Override
	public int insertCampCpnSht(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertCampCpnSht(param);
	}

	@Override
	public int updateCampNoInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.updateCampNoInfo(param);
	}

	// /coupon/resultCampListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectCampList2(param);
	}


	// /payment/paymentCpnListPage.do
	@Override
	public List<Map<String, Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectPaymentCpnList(param);
	}

	@Override
	public int updateCpnNosPhs(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.updateCpnNosPhs(param);
	}

	@Override
	public int insertAcntDpst(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertAcntDpst(param);
	}

	// /payment/completeCalcListPage.do
	@Override
	public List<Map<String, Object>> selectCompleteCalcList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectCompleteCalcList(param);
	}

	// /payment/notUsedCpnListPage.do
	@Override
	public List<Map<String, Object>> selectNotUsedCpnList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectNotUsedCpnList(param);
	}

	// /payment/settlementDiscardListPage.do
	@Override
	public List<Map<String, Object>> selectSettlementDiscardList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectSettlementDiscardList(param);
	}



	// /account/createAcntListPage.do
	@Override
	public List<Map<String, Object>> selectStrAcntList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectStrAcntList(param);
	}

	@Override
	public int insertStrAcnt(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertStrAcnt(param);
	}



	// /account/selectAcntListPage.do
	public List<Map<String,Object>> selectAcntList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectAcntList(param);
	}


	// /account/selectAcntInOutListPage.do
	@Override
	public List<Map<String, Object>> selectStrList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectStrList(param);
	}

	@Override
	public List<Map<String, Object>> selectAcntInOutList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectAcntInOutList(param);
	}

	@Override
	public int insertStrDpstProc(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertStrDpstProc(param);
	}

	@Override
	public int insertStrWthdProc(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertStrWthdProc(param);
	}

	// /manage/manageForTestPage.do
	@Override
	public int deleteTableAcnt(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteTableAcnt(param);
	}

	@Override
	public int deleteTableAcnthist(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteTableAcnthist(param);
	}

	@Override
	public int deleteTableCamp(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteTableCamp(param);
	}

	@Override
	public int deleteTableCpn(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteTableCpn(param);
	}

	@Override
	public int deleteTableCnnt(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteTableCnnt(param);
	}

	@Override
	public int deleteTableLogin(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.deleteTableLogin(param);
	}

	@Override
	public List<Map<String, Object>> selectAllLoginInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectAllLoginInfo(param);
	}

	@Override
	public int insertLoginInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.insertLoginInfo(param);
	}

	@Override
	public List<Map<String, Object>> selectLikeLoginSrch(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectLikeLoginSrch(param);
	}

	// /manage/selectStrListPage.do
	@Override
	public List<Map<String, Object>> selectStrInfoList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectStrInfoList(param);
	}

	// /manage/selectUsrListPage.do
	@Override
	public List<Map<String, Object>> selectUsrInfoList(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectUsrInfoList(param);
	}
}
