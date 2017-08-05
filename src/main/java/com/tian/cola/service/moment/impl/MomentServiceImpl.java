package com.tian.cola.service.moment.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tian.cola.dao.moment.MomentDAO;
import com.tian.cola.dto.moment.MomentDTO;
import com.tian.cola.service.moment.MomentService;

@Service("momentService")
public class MomentServiceImpl implements MomentService {
	
	@Autowired
	@Qualifier("momentDAO")
	private MomentDAO momentDAO;
	
	public List<MomentDTO> getMoment(String userId){
		Map<String,String> param = new HashMap<String,String>();
		param.put("id", userId);
		return momentDAO.getMoment(param);
	}
	
	public List<MomentDTO> getMoments(){
		return momentDAO.getMoments();
	}
	
	public void createMoment(MomentDTO moment){
		Date d = new Date();
		Random r = new Random();
		Map<String,MomentDTO> param = new HashMap<String,MomentDTO>();
		String momentContent = moment.getMomentContent();
		MomentDTO momentDTO = new MomentDTO();
		if(!"".equals(momentContent)&&momentContent!=null){
			momentDTO.setMomentContent(momentContent);
			momentDTO.setCreatedBy("tian");
			momentDTO.setIdMoment(d.getTime()+""+r.nextInt(10));
			momentDTO.setUpdatedBy("tian");
			momentDTO.setUserId("00001");
			param.put("moment", momentDTO);
		}
		momentDAO.createMoment(momentDTO);
	}
}
