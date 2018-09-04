package com.whx.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/hi")
    public String hi(String name) {
        return restTemplate.getForEntity("http://EUREKA-SERVICE/hi?name={1}",String.class,name).getBody();
    }
}
