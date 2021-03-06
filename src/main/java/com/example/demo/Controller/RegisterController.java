package com.example.demo.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Dto.User;
import com.example.demo.Utils.RegisterUtil;
import com.example.demo.Utils.ZeroBounceUtil;

@Controller
@RequestMapping("/")
public class RegisterController {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/register")
	public ResponseEntity<Object> register(@RequestBody @Valid User user, BindingResult bindingResult) {
		System.err.println("USER:: " + user + ":: " + bindingResult.getErrorCount());
		ZeroBounceUtil zbu= new ZeroBounceUtil();
		if (bindingResult.hasErrors()) {
			System.err.println("fail ");
			return RegisterUtil.fieldErrorResponse(user, RegisterUtil.getFieldErrorResponse(bindingResult));
		}
		else if(zbu.checkEmailValidation(user.getEmail().trim()) == false)
		{
			return new ResponseEntity("Email doesn't exist", HttpStatus.BAD_REQUEST);
		}
		else {
			System.err.println("success ");
			return new ResponseEntity("SUCCESS", HttpStatus.OK);
		}
	}

}
