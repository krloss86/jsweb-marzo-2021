package ar.com.educacionit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.educacionit.enums.ViewsEnum;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/home"})
	public String home() {
		return ViewsEnum.INDEX.toString();//templates/index.html
	}
}
