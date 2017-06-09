package com.sag.routes.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sag.routes.model.ImageUrl;
import com.sag.routes.service.ImageService;

//Rest Controller with all REST endpoints
@RestController
public class ImageController {
	
	/*
	 * @GetMapping--specifies GET method
	 * 
	 */
	@Autowired
	private ImageService imageService;
	@GetMapping("/city")// Sample: localhost:8080/rest/city
	public String method1() {
		String folders=imageService.getCities();
		return folders;
	}

	@GetMapping("/city/{cname}/") //Sample: localhost:8080/rest/city/Guindy
	public List<ImageUrl> method2(@PathVariable("cname") String cityname, HttpServletRequest request) {
		List<ImageUrl> cityimages=imageService.getCityImageUrl(cityname,request);
		return cityimages;
	}
   
	@GetMapping(value = "/city/{cname}/{name}")
	public byte[] method3(@PathVariable("cname") String cityname, @PathVariable("name") String imagename)
			throws IOException {
		byte[] images=imageService.getImage( cityname, imagename);
				return images;
	}
}
