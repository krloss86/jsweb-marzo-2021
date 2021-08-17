package ar.com.educacionit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.educacionit.domain.Cupones;
import ar.com.educacionit.enums.CuponesKeysEnum;
import ar.com.educacionit.enums.ViewsEnum;
import ar.com.educacionit.services.CuponesService;

@Controller()
@RequestMapping("/cupon")
public class CuponesController {

	@Autowired
	private CuponesService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Cupones> list = this.service.findAll();
		
		model.addAttribute(CuponesKeysEnum.CUPONES.toString(), list);
		
		return ViewsEnum.LISTADO.toString();
	}
	
	@RequestMapping("/edit/{id}")
	public String edit( @PathVariable(name="id")
						Long id,
						Model model) {
		
		Cupones cupon = this.service.getById(id);
		
		model.addAttribute(CuponesKeysEnum.CUPON.toString(), cupon);
		
		return ViewsEnum.EDITAR.toString();	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			@Valid
			@ModelAttribute(name = "CUPON")
			Cupones cupon,
			BindingResult result,
			Model model
			) {
		
		if(result.hasErrors()) {
			
			model.addAttribute(CuponesKeysEnum.CUPON.toString(), cupon);
			
			return ViewsEnum.EDITAR.toString();
		}
		
		this.service.update(cupon);
		
		return ViewsEnum.LISTADO_REDIRECT.toString();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(
			@PathVariable(name = "id") Long id
			) {		
		
		this.service.delete(id);		
		
		return ViewsEnum.LISTADO_REDIRECT.toString();
	}
	
	@RequestMapping("/delete2")
	public String delete2(
			@RequestParam(value = "id", required = true) Long id
			) {		
		
		this.service.delete(id);		
		
		return ViewsEnum.LISTADO_REDIRECT.toString();
	}
	
	@RequestMapping("/new")
	public ModelAndView newCupon() {
		
		Cupones cupon = new Cupones();
		
		ModelAndView modelAndView =  new ModelAndView(ViewsEnum.NEW.toString());
		
		modelAndView.addObject(CuponesKeysEnum.CUPON.toString(), cupon);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(
		@Valid
		@ModelAttribute(name = "CUPON")
		
		Cupones cupon, BindingResult result) {
	
		if(result.hasErrors()) {
			return ViewsEnum.NEW.toString();
		}
		
		this.service.update(cupon);
		
		return ViewsEnum.LISTADO_REDIRECT.toString();
	}
}
