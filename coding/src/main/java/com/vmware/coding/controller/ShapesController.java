package com.vmware.coding.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.coding.service.ShapesService;
import com.vmware.coding.vo.ShapesVO;

@RestController
@RequestMapping("/shapes")
public class ShapesController {

	@Autowired
	private ShapesService shapesService;
	
	@GetMapping("/{task_id}")
	public ResponseEntity<ShapesVO> fetchCustomer(@PathVariable("task_id") int taskId) 
	{

		return new ResponseEntity<ShapesVO>(shapesService.getTaskResult(taskId), HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<Integer> createCustomer(@RequestBody ShapesVO shapesInput) 
	{
		int taskId = shapesService.saveTask(shapesInput);
		return new ResponseEntity<Integer>(taskId, HttpStatus.CREATED);
	}
}
