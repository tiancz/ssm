package com.tian.cola.service.comment;

import java.util.List;

import com.tian.cola.dto.comment.CommentDTO;

/**
 * <p>Title:CommentService</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年11月24日 下午11:02:41
 **/
public interface CommentService {

	public List<CommentDTO> queryComments(String articleId);
	
	public int countComment(String articleId);
}
