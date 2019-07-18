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
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.updateBuyCpnSht(param);
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
}
