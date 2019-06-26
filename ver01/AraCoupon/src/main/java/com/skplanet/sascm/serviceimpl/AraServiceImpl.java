package com.skplanet.sascm.serviceimpl;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.AraDAO;
import com.skplanet.sascm.service.AraService;

@Service("araService")
public class AraServiceImpl implements AraService {

	@Resource(name = "araDAO")
	private AraDAO araDAO;

	// Usr
	@Override
	public int insertUsrAraKey(Map<String, Object> param) throws SQLException {
		return this.araDAO.insertUsrAraKey(param);
	}

	@Override
	public Map<String, Object> selectUsrAraKeyInfo(Map<String, Object> param) throws SQLException {
		return this.araDAO.selectUsrAraKeyInfo(param);
	}

	@Override
	public int updateCnntByUsrid(Map<String, Object> param) throws SQLException {
		return this.araDAO.updateCnntByUsrid(param);
	}

	@Override
	public int updateAllCnntByUsrid(Map<String, Object> param) throws SQLException {
		return this.araDAO.updateAllCnntByUsrid(param);
	}



	// Str
	@Override
	public int insertStrAraKey(Map<String, Object> param) throws SQLException {
		return this.araDAO.insertStrAraKey(param);
	}

	@Override
	public Map<String, Object> selectStrAraKeyInfo(Map<String, Object> param) throws SQLException {
		return this.araDAO.selectStrAraKeyInfo(param);
	}

	@Override
	public int updateCnntByStrid(Map<String, Object> param) throws SQLException {
		return this.araDAO.updateCnntByStrid(param);
	}

	@Override
	public int updateAllCnntByStrid(Map<String, Object> param) throws SQLException {
		return this.araDAO.updateAllCnntByStrid(param);
	}



	// Ctr
	@Override
	public int insertCtrAraKey(Map<String, Object> param) throws SQLException {
		return this.araDAO.insertCtrAraKey(param);
	}

	@Override
	public Map<String, Object> selectCtrAraKeyInfo(Map<String, Object> param) throws SQLException {
		return this.araDAO.selectCtrAraKeyInfo(param);
	}

	@Override
	public int updateCnntByCtrid(Map<String, Object> param) throws SQLException {
		return this.araDAO.updateCnntByCtrid(param);
	}

	@Override
	public int updateAllCnntByCtrid(Map<String, Object> param) throws SQLException {
		return this.araDAO.updateAllCnntByCtrid(param);
	}




}
