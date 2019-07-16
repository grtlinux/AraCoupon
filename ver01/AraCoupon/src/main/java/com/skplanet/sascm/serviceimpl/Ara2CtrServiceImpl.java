package com.skplanet.sascm.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.Ara2CtrDAO;
import com.skplanet.sascm.service.Ara2CtrService;

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
}
