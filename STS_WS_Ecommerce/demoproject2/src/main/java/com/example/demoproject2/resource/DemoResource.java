package com.example.demoproject2.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoproject2.model.DemoClient;
import com.example.demoproject2.model.DemoEntity;

@RestController
@RequestMapping("/demo")
public class DemoResource {
	
	@Autowired
	DemoRepository demoRepository;
	
	@GetMapping(path = "/clients")
	public ResponseEntity<Object> getDemoClients()
	{
		DemoEntity dc = new DemoEntity();
		dc.setId(1L);
		dc.setName("chandra");
		return new ResponseEntity<>(dc,HttpStatus.OK);
	}
	
	@GetMapping(path = "/clients/{clientId}")
	public Optional<DemoEntity> getDemoClientsByID(@PathVariable Long clientId)
	{
		Optional<DemoEntity> dc = demoRepository.findById(clientId);
		
		return dc;
	}
	
	@PostMapping(path = "/updateClient")
	public DemoEntity getDemoClientsByID(@RequestBody DemoClient demoClient)
	{
		
		
		DemoEntity de = new DemoEntity();
		de.setId(123L);
		de.setName("sekharsivarajudbsaved");
		
		DemoEntity df = demoRepository.save(de);
		
		return df;
	}

}
