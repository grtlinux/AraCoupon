package kr.co.arajeju.aracoupon2.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	private static final Log log = LogFactory.getLog(AbstractDAO.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId + ", sqlSessionTemplate = " + this.sqlSessionTemplate);
		}
	}

	// insert
	public Object insert(String queryId, Object params){
		printQueryId(queryId);
		return this.sqlSessionTemplate.insert(queryId, params);
	}

	// update
	public Object update(String queryId, Object params){
		printQueryId(queryId);
		return this.sqlSessionTemplate.update(queryId, params);
	}

	// delete
	public Object delete(String queryId, Object params){
		printQueryId(queryId);
		return this.sqlSessionTemplate.delete(queryId, params);
	}

	// selectOne - 1
	public Object selectOne(String queryId){
		printQueryId(queryId);
		return this.sqlSessionTemplate.selectOne(queryId);
	}

	// selectOne - 2
	public Object selectOne(String queryId, Object params){
		printQueryId(queryId);
		return this.sqlSessionTemplate.selectOne(queryId, params);
	}

	// selectList - 1
	public List<?> selectList(String queryId){
		printQueryId(queryId);
		return this.sqlSessionTemplate.selectList(queryId);
	}

	// selectList - 2
	public List<?> selectList(String queryId, Object params){
		printQueryId(queryId);
		return this.sqlSessionTemplate.selectList(queryId,params);
	}
}
