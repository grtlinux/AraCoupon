package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraStrDAO;

@SuppressWarnings("unchecked")
@Repository("araStrDAO")
public class AraStrDAOImpl extends AbstractDAO implements AraStrDAO {

	@Override
	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraStr.selectStoreInfo", param);
	}
	
	@Override
	public List<Map<String, Object>> giveCouponList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.giveCouponList", param);
	}

	@Override
	public List<Map<String, Object>> listCouponList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.listCouponList", param);
	}

	@Override
	public List<Map<String, Object>> listPaymentList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.listPaymentList", param);
	}

	@Override
	public List<Map<String, Object>> listCalculateList(Map<String, Object> param) throws Exception {
		return (List<Map<String, Object>>) selectList("AraStr.listCalculateList", param);
	}

	@Override
	public Map<String, Object> selectCampId(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraStr.selectCampId", param);
	}

	@Override
	public int insertAraCamp(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertAraCamp", param);
	}

	@Override
	public int insertAraCampInfo(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertAraCampInfo", param);
	}

	@Override
	public int insertAraCampOff(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertAraCampOff", param);
	}

	@Override
	public int insertAraCampChl(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertAraCampChl", param);
	}

	@Override
	public int insertAraOffCpn(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertAraOffCpn", param);
	}

	@Override
	public int insertAraChlSms(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertAraChlSms", param);
	}

	@Override
	public int insertApprReq(Map<String, Object> param) throws SQLException {
		return (int) insert("AraStr.insertApprReq", param);
	}

	@Override
	public List<Map<String,Object>> selectApprReqList(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraStr.selectApprReqList", param);
	}

	@Override
	public List<Map<String,Object>> selectApprResList(Map<String, Object> param) throws SQLException {
		return (List<Map<String, Object>>) selectList("AraStr.selectApprResList", param);
	}
}
