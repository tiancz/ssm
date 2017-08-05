package com.tian.cola.controller.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tian.cola.dto.article.ArticleDTO;
import com.tian.cola.service.article.ArticleService;
import com.tian.cola.service.category.CategoryService;
import com.tian.cola.service.comment.CommentService;

/**
 *@author 田超哲
 *@date 2016年4月4日下午1:06:44
 *@功能:
 */
@Controller
@RequestMapping("/note")
public class NoteController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	@Autowired
	@Qualifier("articleService")
	private ArticleService articleService;
	
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	

	@RequestMapping("/checkNote")
	public String checkNote(HttpServletRequest req,Model model){
		LOGGER.info("get all article");
		String result = "note/note";
		model.addAttribute("notes", parseArticleContent());
		//model.addAttribute("comments", commentService.countComment(articleId));
		return result;
	}
	
	private List<ArticleDTO> parseArticleContent(){
		return articleService.getAllArticle();
	}
	
	@RequestMapping("/createNote")
	public String createNote(HttpServletRequest req,Model model){
		String result = "";
		result = "note/createNote";
		return result;
	}
	@RequestMapping("/finishNote")
	public String finishNote(HttpServletRequest req,Model model){
		String result = "";
		String res = "";
		res = create(req);
		if(res!=""||!res.equals("")){
			model.addAttribute("note", articleService.getArticleById(res));
			result = "note/finishNote";
		}else{
			result = "home";
		}
		return result;
	}
	private String create(HttpServletRequest req){
		String result = "";
		String title = req.getParameter("note_title");
		String content = req.getParameter("note_text");
		String tags = req.getParameter("tag_val");
//		写入数据库
		ArticleDTO article = new ArticleDTO();
		article.setArticleTitle(title);
		article.setArticleContent(content);
		article.setTag(tags);
		
		ArticleDTO returnArticle = new ArticleDTO();
		returnArticle = articleService.insertArticle(article);

//		List<ArticleDTO> journal = new ArrayList<>();
//		journal.add(returnArticle);
//		model.addAttribute("note", journal);
		if(returnArticle!=null){
			result = returnArticle.getArticleId();
		}
		return result;
	}

	@RequestMapping("/edit/{note_id}")
	public String edit(@PathVariable("note_id")String note_id,Model model){
		String result = "";
		ArticleDTO returnArticle = new ArticleDTO();
		returnArticle = articleService.getArticleById(note_id);
		model.addAttribute("note", returnArticle);
		result = "note/editNote";
		return result;
	}
	
	@RequestMapping("/updateNote")
	public String update(@PathVariable("note_id")String note_id,Model model){
		String result = "";
		ArticleDTO returnArticle = new ArticleDTO();
		returnArticle = articleService.getArticleById(note_id);
		model.addAttribute("note", returnArticle);
		result = "note/editNote";
		return result;
	}
	
	@RequestMapping("/delete/{note_id}")
	public String deleteNote(@PathVariable("note_id")String note_id,Model model){
		String result = "";
		String res = "";
		res = delete(note_id);
		if(res=="success"||res.equals("success")){
			LOGGER.info("delete a article");
			result = "home";
		}else{
			res = "fail";
			result = "note/finishNote";
		}
		model.addAttribute("result", res);
		return "redirect:/"+result;
	}
	private String delete(String note_id){
		String result = "";
		int res = 0;
		res = articleService.deleteArticleById(note_id);
		if(res>0){
			result = "success";
		}
		return result;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}
