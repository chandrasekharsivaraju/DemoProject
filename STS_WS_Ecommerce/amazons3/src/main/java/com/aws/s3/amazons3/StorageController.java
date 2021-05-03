package com.aws.s3.amazons3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storage")
public class StorageController {
	
	@Autowired
	private StorageService storageService;

	
	@GetMapping
	public void performAction()
	{
		storageService.createBucket();
	}
}
