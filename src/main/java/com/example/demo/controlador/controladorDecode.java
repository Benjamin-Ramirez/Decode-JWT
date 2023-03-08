package com.example.demo.controlador;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controladorDecode {

	@PostMapping(value="/jwt/decode",
			consumes = MediaType.TEXT_PLAIN_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String decodeJwt(@RequestBody String token) throws UnsupportedEncodingException {

		String payload = token.split("\\.")[1];
		return new String(Base64.decodeBase64(payload), "UTF-8");
		
	}
	
}
