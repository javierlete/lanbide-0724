package com.ipartek.formacion.spring.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(required = false, defaultValue = "Mundo") String name, Model model) {
		model.addAttribute("name", "compadre " + name);
		return "greeting";
	}
}
