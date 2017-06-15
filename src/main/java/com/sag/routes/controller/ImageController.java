package com.sag.routes.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sag.routes.model.ImageUrl;
import com.sag.routes.service.ImageService;

//Rest Controller with all REST endpoints
@RestController
@RequestMapping("/cities")
public class ImageController {
	
	/*
	 * @GetMapping--specifies GET method
	 * 
	 */
	@Autowired
	private ImageService imageService;
	// Sample: localhost:8080/rest/city
	public String getCities() {
		String folders=imageService.getCities();
		return folders;
	}

	@GetMapping("/{cityname}") //Sample: localhost:8080/rest/city/Guindy
	public List<ImageUrl> getCityName(@PathVariable("cityname") String cityname, HttpServletRequest request) {
		List<ImageUrl> cityimages=imageService.getCityImageUrl(cityname,request);
		return cityimages;
	}
   
	@GetMapping(value = "{cityname}/{imagename}")
	public byte[] getImage(@PathVariable("cityname") String cityname, @PathVariable("imagename") String imagename)
			throws IOException {
		byte[] images=imageService.getImage( cityname, imagename);
				return images;
	}
}
