package com.tian.cola.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <p>Title:BaseDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年11月28日 下午9:34:02
 **/
public class BaseDAO {

	@Autowired
	@Qualifier("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory;
	
	public SqlSession session;
	
	public SqlSession CDUtil(){
		session = sqlSessionFactory.openSession();
		return session;
	}
	
}
