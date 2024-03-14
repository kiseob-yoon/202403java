package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/") //get방식으로 요청 들어오면 url매핑
	public String hello(Model model) { //model servlet의 request,response가 매개변수로 받는 것과 같음
		model.addAttribute("str", "훈민정음"); //포워딩 하는 것(view에서 참조해서 표현언어로 사용가능)
		return "hello";
	}
}

//MVC에서 Controller의 역할
//포워딩(Forwarding)은 웹 애플리케이션에서 요청을 다른 리소스로 전달하는 기술