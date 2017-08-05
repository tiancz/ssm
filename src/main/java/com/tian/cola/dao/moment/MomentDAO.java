package com.tian.cola.dao.moment;

import java.util.List;
import java.util.Map;

import com.tian.cola.dto.moment.MomentDTO;

public interface MomentDAO {
	/**
	 * 根据用户id获取用户全部
	 *@author tianchaozhe665
	 *@Email nathanieltian@163.com
	 *@date 2016年11月28日 下午9:02:38
	 *@param @param param
	 *@param @return
	 *@return List<MomentDTO>
	 *
	 */
	public List<MomentDTO> getMoment(Map<String,String> param);
	/**
	 * 获取全部
	 *@author tianchaozhe665
	 *@Email nathanieltian@163.com
	 *@date 2016年11月28日 下午9:03:24
	 *@param @return
	 *@return List<MomentDTO>
	 *
	 */
	public List<MomentDTO> getMoments();
	
	public void createMoment(MomentDTO moment);
}
