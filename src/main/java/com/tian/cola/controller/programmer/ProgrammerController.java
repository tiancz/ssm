package com.tian.cola.controller.programmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tian.cola.service.moment.MomentService;

/**
 *@author 田超哲
 *@date 2016年5月12日下午10:59:53
 *@功能:
 */
@Controller
@RequestMapping("/programmer")
public class ProgrammerController {

	@Autowired
	@Qualifier("momentService")
	private MomentService momentService;
	
	@RequestMapping("/programmer")
	public String programmer(Model model){
		String result = "programmer/programmer";
		model.addAttribute("moments", momentService.getMoment("00001"));
		return result;
	}
}
