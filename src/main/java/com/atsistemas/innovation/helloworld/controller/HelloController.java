package com.atsistemas.innovation.helloworld.controller;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.atsistemas.innovation.helloworld.dto.Hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value = "Hello World API")
public class HelloController {

	private static final String template = "Hello En Mi Local Funciona, %s!";
	private final AtomicLong counter = new AtomicLong();

	@ApiOperation(value = "View Hello Message", code = 200, response = Hello.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully response") })
	@RequestMapping(value = "/hello",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Hello greeting(@RequestParam(value = "name", defaultValue = "anonymous") String name) {
		return new Hello(counter.incrementAndGet(), String.format(template, name));
	}
}
