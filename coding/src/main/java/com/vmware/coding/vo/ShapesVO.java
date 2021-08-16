package com.vmware.coding.vo;

import java.util.Map;

import com.vmware.coding.entity.Shapes;

public class ShapesVO {


	private Map<String, String> task;

	public Map<String, String> getTask() {
		return task;
	}
	public void setTask(Map<String, String> task) {
		this.task = task;
	}

	public void copyToVO(Shapes shape) {
		shape.setTask(this.task);
	}

}
