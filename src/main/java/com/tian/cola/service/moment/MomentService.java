package com.tian.cola.service.moment;

import java.util.List;

import com.tian.cola.dto.moment.MomentDTO;

public interface MomentService {
	/**
	 * 根据用户id获取全部
	 *@author tianchaozhe665
	 *@Email nathanieltian@163.com
	 *@date 2016年11月28日 下午9:07:07
	 *@param @param userId
	 *@param @return
	 *@return List<MomentDTO>
	 *
	 */
	public List<MomentDTO> getMoment(String userId);
	/**
	 * 获取全部
	 *@author tianchaozhe665
	 *@Email nathanieltian@163.com
	 *@date 2016年11月28日 下午9:07:38
	 *@param @return
	 *@return List<MomentDTO>
	 *
	 */
	public List<MomentDTO> getMoments();
	
	public void createMoment(MomentDTO moment);
}
