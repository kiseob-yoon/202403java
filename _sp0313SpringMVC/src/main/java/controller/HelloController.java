package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello") //get방식으로 요청 들어오면 url매핑
	public String hell() {
		return "hello";
	}
}
