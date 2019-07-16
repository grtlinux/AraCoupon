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

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2DAO.selectItemInfo(param);
	}

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
}
