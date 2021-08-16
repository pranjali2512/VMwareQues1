package com.vmware.coding.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmware.coding.entity.Shapes;
import com.vmware.coding.repository.ShapesRepository;
import com.vmware.coding.vo.ShapesVO;

public class ShapesServiceImpl implements ShapesService {

	private final double PI_CONSTANT = Math.PI *2;
	
	@Autowired
	private ShapesRepository shapesRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public int saveTask(ShapesVO input) {
		Shapes shapesEntity = new Shapes();
		Map<String, String> task = new HashMap<String, String>();
		for(Entry<String, String> str : input.getTask().entrySet()) {
			ObjectMapper objectMapper = new ObjectMapper();
        	double area = 0;
            try {

				Map<String, String> shapeMap = objectMapper.readValue(str.getValue(), HashMap.class);
				switch(shapeMap.get("type")) {
				case "circle":
					area = Double.parseDouble(shapeMap.get("radius")) * PI_CONSTANT;
					break;
				case "square":
					area = Double.parseDouble(shapeMap.get("side")) * Double.parseDouble(shapeMap.get("side"));
					break;
				case "rectangle":
					area = Double.parseDouble(shapeMap.get("l")) * Double.parseDouble(shapeMap.get("b"));
					break;
				}
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            task.put(str.getKey(), String.valueOf(area));
		}
		shapesEntity.setTask(task);
		Shapes taskSaved = shapesRepository.saveAndFlush(shapesEntity);
		return taskSaved.getTaskId();
	}

	@Override
	public ShapesVO getTaskResult(int id) {
		Shapes taskSaved = shapesRepository.findByTaskId(id);
		ShapesVO responseTask = new ShapesVO();
		responseTask.copyToVO(taskSaved);
		return responseTask;
	}

}
