package com.vmware.coding.service;



import com.vmware.coding.vo.ShapesVO;

public interface ShapesService {

	public int saveTask(ShapesVO input);
	
	public ShapesVO getTaskResult(int id);
}
