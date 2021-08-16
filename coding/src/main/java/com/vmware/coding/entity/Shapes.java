package com.vmware.coding.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shapes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@Column(name = "task", columnDefinition = "json")
	private Map<String, String> task;

	public int getTaskId() {
		return taskId;
	}

	public void setTask_id(int taskId) {
		this.taskId = taskId;
	}

	public Map<String, String> getTask() {
		return task;
	}

	public void setTask(Map<String, String> task) {
		this.task = task;
	}
}
