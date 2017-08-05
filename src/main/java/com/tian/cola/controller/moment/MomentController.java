package com.tian.cola.controller.moment;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tian.cola.controller.home.Home;
import com.tian.cola.dto.moment.MomentDTO;
import com.tian.cola.service.moment.MomentService;

/**
 * <p>Title:MomentController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年11月28日 下午8:57:03
 **/
@Controller
@RequestMapping("/moment")
public class MomentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Home.class);
	
	@Autowired
	@Qualifier("momentService")
	public MomentService momentService;
	
	@RequestMapping("/moment")
	public String moment(Model model){
		LOGGER.info("start moment");
		model.addAttribute("moments", momentService.getMoments());
		return "moment/moment";
	}
	
	@RequestMapping("/createMoment")//MomentDTO moment
	public String createMoment(HttpServletRequest req,Model model){
		LOGGER.info("start createMoment");
		String result = "";
		String momentContent = req.getParameter("moment");
		MomentDTO moment = new MomentDTO();
		if(!"".equals(momentContent)&&momentContent!=null){
			moment.setMomentContent(momentContent);
		}
		//String momentContent = moment.getMomentContent();
		if(!"".equals(momentContent)&&momentContent!=null){
			momentService.createMoment(moment);
			model.addAttribute("moments", momentService.getMoments());
			result = "moment/moment";
			LOGGER.info("end createMoment");
		}else{
			result = "errorPage/404";
		}
		LOGGER.info("result:"+result);
		return result;
	}
}
