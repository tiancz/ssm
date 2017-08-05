package com.tian.cola.dao.picture.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.picture.PictureDAO;
import com.tian.cola.dto.picture.PictureDTO;

@Repository("pictureDAO")
public class PictureDAOImpl extends BaseDAO implements PictureDAO {

	public List<PictureDTO> getAllPicture() {
		List<PictureDTO> pictures = new ArrayList<>();
		pictures = CDUtil().selectList("getPictures");
		return pictures;
	}
}
