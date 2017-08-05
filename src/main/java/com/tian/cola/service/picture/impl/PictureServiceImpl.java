package com.tian.cola.service.picture.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tian.cola.dao.picture.PictureDAO;
import com.tian.cola.dto.picture.PictureDTO;
import com.tian.cola.service.picture.PictureService;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	
	@Autowired
	@Qualifier("pictureDAO")
	private PictureDAO pictureDAO;
	
	public List<PictureDTO> getAllPicture() {
		List<PictureDTO> list = new ArrayList<>();
		List<PictureDTO> result = new ArrayList<>();
		list.addAll(pictureDAO.getAllPicture());
		for(int i=0;i<list.size();i++){
			PictureDTO pic = new PictureDTO();
			String picUrl = list.get(i).getPictureUrl();
			String []urls = picUrl.split("/");
			picUrl = "/"+urls[urls.length-2]+"/"+urls[urls.length-1];
			pic.setPictureUrl(picUrl);
			result.add(pic);
		}
		return result;
	}
}
