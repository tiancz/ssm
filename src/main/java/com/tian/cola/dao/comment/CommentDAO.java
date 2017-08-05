package com.tian.cola.dao.comment;

import java.util.List;

import com.tian.cola.dto.comment.CommentDTO;

/**
 * <p>Title:Comment</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年11月24日 下午11:03:57
 **/
public interface CommentDAO {
	public List<CommentDTO> queryComments(String articleId);
	
	public int countComment(String articleId);
}
