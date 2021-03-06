package com.example.demo.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.Dto.User;

public class RegisterUtil {
	public static Map<String, Object> getFieldErrorResponse(BindingResult result) {
		Map<String, Object> fielderror = new HashMap<String, Object>();
		List<FieldError> errors = result.getFieldErrors();
		errors.stream().forEach(dto -> {
			fielderror.put(dto.getField(), dto.getDefaultMessage());
		});
		return fielderror;
	}

	public static ResponseEntity<Object> fieldErrorResponse(User user, Object fielderror) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", false);
		map.put("data", user);
		map.put("status", HttpStatus.BAD_REQUEST);
		map.put("timestamp", new Date());
		map.put("fielderror", fielderror);
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
