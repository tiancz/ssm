package com.tian.cola.service.comment.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tian.cola.dao.comment.CommentDAO;
import com.tian.cola.dto.comment.CommentDTO;
import com.tian.cola.service.comment.CommentService;

/**
 * <p>Title:CommentServiceImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年11月24日 下午11:02:17
 **/
@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CommentService.class); 
	
	@Autowired
	@Qualifier("commentDao")
	private CommentDAO commentDao;

	@Override
	public List<CommentDTO> queryComments(String articleId) {
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		LOGGER.info("start queryComments "+articleId);
		comments = commentDao.queryComments(articleId);
		LOGGER.info("end queryComments "+articleId);
		return comments;
	}

	@Override
	public int countComment(String articleId) {
		int count = 0;
		LOGGER.info("start countComment "+articleId);
		count = commentDao.countComment(articleId);
		LOGGER.info("end countComment "+articleId);
		return count;
	}
}
