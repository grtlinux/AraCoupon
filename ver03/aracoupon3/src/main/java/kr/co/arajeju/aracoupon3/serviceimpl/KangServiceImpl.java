package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.KangDAO;
import kr.co.arajeju.aracoupon3.service.KangService;

@Service("kangService")
public class KangServiceImpl implements KangService {

	@Resource(name = "kangDAO")
	private KangDAO kangDAO;

	@Override
	public String getMessage(Map<String, Object> param) throws Exception {
		return this.kangDAO.getMessage(param);
	}

	@Override
	public List<Map<String,Object>> selectCommCodeListOnMap(Map<String, Object> param) throws Exception {
		return this.kangDAO.selectCommCodeListOnMap(param);
	}
}
