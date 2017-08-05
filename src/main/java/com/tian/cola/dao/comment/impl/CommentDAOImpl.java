package com.tian.cola.dao.comment.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.comment.CommentDAO;
import com.tian.cola.dto.comment.CommentDTO;

/**
 * <p>Title:CommentDAOImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年11月24日 下午11:04:34
 **/
@Repository("commentDao")
public class CommentDAOImpl extends BaseDAO implements CommentDAO  {

	@Override
	public List<CommentDTO> queryComments(String articleId) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("articleId", articleId);
		List<CommentDTO> comments = new ArrayList<>();
		comments = CDUtil().selectList("getComments",param);
		return comments;
	}
	
	public int countComment(String articleId){
		Map<String,String> param = new HashMap<String,String>();
		param.put("articleId", articleId);
		int count = 0;
		count = CDUtil().selectOne("countComments",param);
		return count;
	}
}
