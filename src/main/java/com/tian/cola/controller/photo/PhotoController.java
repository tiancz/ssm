package com.tian.cola.controller.photo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.tian.cola.controller.music.MusicController;
import com.tian.cola.dto.picture.PictureDTO;
import com.tian.cola.service.picture.PictureService;

/**
 *@author 田超哲
 *@date 2016年5月12日下午10:56:11
 *@功能:
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MusicController.class);
	@Autowired
	@Qualifier("pictureService")
	private PictureService pictureService;

	@RequestMapping("/photo")
	public String checkPhoto(Model model){
		LOGGER.info("start get picture controller");
		String result = "photo/photo";
		for (int i=0;i<pictureService.getAllPicture().size();i++) {
			System.out.println("url:"
		+pictureService.getAllPicture().get(i).getPictureUrl());
		}
		List<PictureDTO> list = new ArrayList<>();
		list.addAll(pictureService.getAllPicture());
		model.addAttribute("photos", pictureService.getAllPicture());
		return result;
	}
	
	@RequestMapping("/sendPhoto")
	//@RequestParam(value="file",required=false)MultipartFile file
	public String sendPhoto(HttpServletRequest request,Model model){
		LOGGER.info("start send picture controller");
		if(request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			MultipartFile multifile = multiRequest.getFile("pic");
			File file = (File)transferToDestFile(multifile).get("file");
			try{
				ImageInputStream img = new FileImageInputStream(file);
				BufferedImage bi = ImageIO.read(img);
				System.out.println("height:"+bi.getHeight());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		String result = "photo/photo";
		List<PictureDTO> list = new ArrayList<>();
		list.addAll(pictureService.getAllPicture());
		JSONObject jObj = new JSONObject();
		jObj.put("result", "success");
		model.addAttribute("photos", pictureService.getAllPicture());
		return result;
	}
	private Map transferToDestFile(MultipartFile multifile){
		Map result = new HashMap();
		File dest = null;
		try{
			if(!multifile.isEmpty()){
				String filename = multifile.getOriginalFilename();
				String extName = filename.substring(filename.lastIndexOf("."));
				long size = multifile.getSize();
				String newName = System.currentTimeMillis()+"";
				BufferedImage bi = ImageIO.read(multifile.getInputStream());
				dest = new File(newName+extName);
				multifile.transferTo(dest);
				result.put("file", dest);
				result.put("size", size);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
