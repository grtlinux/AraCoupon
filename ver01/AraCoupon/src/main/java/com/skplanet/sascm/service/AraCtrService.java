package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface AraCtrService {

	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws Exception;
}
