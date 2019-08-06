package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.common.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.KangDAO;

@SuppressWarnings("unchecked")
@Repository("kangDAO")
public class KangDAOImpl extends AbstractDAO implements KangDAO {

	@Override
	public String getMessage(Map<String, Object> param) throws Exception {
		return (String) selectOne("Kang.selectMessage");
	}

	@Override
	public List<Map<String,Object>> selectCommCodeListOnMap(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Kang.selectCommCodeListOnMap", param);
	}
}
