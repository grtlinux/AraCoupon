package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara3IbDAO;

@SuppressWarnings("unchecked")
@Repository("ara3IbDAO")
public class Ara3IbDAOImpl extends AbstractDAO implements Ara3IbDAO {

	@Override
	public Map<String, Object> selectAraInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Ib.selectAraInfo", param);
	}

	@Override
	public Map<String, Object> selectLastIbTkn(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Ib.selectLastIbTkn", param);
	}

	@Override
	public int insertIbTkn(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Ib.insertIbTkn", param);
	}
}
