package com.skplanet.sascm.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.Ara2DAO;
import com.skplanet.sascm.service.Ara2Service;

@Service("ara2Service")
public class Ara2ServiceImpl implements Ara2Service {

	@Resource(name = "ara2DAO")
	private Ara2DAO ara2DAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2DAO.selectItemInfo(param);
	}

	// /registArakey.do
	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara2DAO.insertCnntAraKey(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara2DAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara2DAO.updateCnntByCnntid(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara2DAO.selectCnntArakeyInfo(param);
	}

	// /register/registerUsrFormPage.do
	@Override
	public Map<String, Object> selectChkNmMblEml(Map<String, Object> param) throws Exception {
		return this.ara2DAO.selectChkNmMblEml(param);
	}

	@Override
	public Map<String, Object> selectUsrNo(Map<String, Object> param) throws Exception {
		return this.ara2DAO.selectUsrNo(param);
	}

	@Override
	public int insertAra2Usr(Map<String, Object> param) throws Exception {
		return this.ara2DAO.insertAra2Usr(param);
	}

	@Override
	public int insertAra2Mbl(Map<String, Object> param) throws Exception {
		return this.ara2DAO.insertAra2Mbl(param);
	}

	@Override
	public int insertAra2Eml(Map<String, Object> param) throws Exception {
		return this.ara2DAO.insertAra2Eml(param);
	}
}
