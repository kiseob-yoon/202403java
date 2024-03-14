package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.LoginRequest;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		return "index";
	}
	@GetMapping("/hello") 
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/login") 
	public String login() {
		return "inputForm";
	}
	@GetMapping("/result")
	public String result(LoginRequest loginRequest) {
		System.out.println(loginRequest.getId());
		System.out.println(loginRequest.getEmail());
		return "result";
	}
	
	@GetMapping("/move")
	public String move() {
		return "redirect:/";
	}
	
//	@GetMapping("/result")
//	public String result(@RequestParam String id,
//						 @RequestParam String email) {
//		System.out.println(id);
//		System.out.println(email);
//		return "result";
//	public String result(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String email = request.getParameter("email");
//		return "result";
	}

//요청이 있으면 Controller에 등록한다(jsp에서는 jsp파일끼리 페이지 이동)