package com.tian.cola.dao.moment.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.moment.MomentDAO;
import com.tian.cola.dto.moment.MomentDTO;

@Repository("momentDAO")
public class MomentDAOImpl extends BaseDAO implements MomentDAO {
	
	public List<MomentDTO> getMoment(Map<String,String> param){
		List<MomentDTO> moment = new ArrayList<>();
		moment = CDUtil().selectList("getUserMoment",param);
		return moment;
	}
	
	public List<MomentDTO> getMoments(){
		List<MomentDTO> moment = new ArrayList<>();
		moment = CDUtil().selectList("getMoments");
		return moment;
	}
	public void createMoment(MomentDTO moment){
		CDUtil().insert("createMoment",moment);
	}
}
