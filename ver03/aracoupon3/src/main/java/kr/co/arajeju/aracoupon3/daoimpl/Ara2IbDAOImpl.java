package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara2IbDAO;

@SuppressWarnings("unchecked")
@Repository("ara2IbDAO")
public class Ara2IbDAOImpl extends AbstractDAO implements Ara2IbDAO {

	@Override
	public Map<String, Object> selectAraInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ib.selectAraInfo", param);
	}

	@Override
	public Map<String, Object> selectLastIbTkn(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ib.selectLastIbTkn", param);
	}

	@Override
	public int insertIbTkn(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Ib.insertIbTkn", param);
	}
}
