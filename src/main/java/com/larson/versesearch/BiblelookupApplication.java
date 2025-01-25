package com.larson.versesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BiblelookupApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BiblelookupApplication.class, args);
	}

  

}
