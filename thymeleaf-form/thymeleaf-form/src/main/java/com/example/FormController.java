package com.example;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
	
	/*
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
	    binder.addValidators(new Validator() {
			
			@Override
			public void validate(Object target, Errors errors) {
				FormData fd = (FormData) target;
				if(! fd.isAccept()) {
					errors.rejectValue("accept", "you must accept this!");
				}
			}
			
			@Override
			public boolean supports(Class<?> clazz) {
				return FormData.class.isAssignableFrom(clazz);
			}
		});
	}
	*/
	
	@GetMapping("/form")
	public String openForm(FormData formData) {
		return "form";
	}
	
	@PostMapping("/form")
	public String submitForm(@Valid FormData formData, BindingResult result, Model model) {
		System.err.println(formData);
		
		if(result.hasErrors()) {
//			model.addAttribute("infoForm", data);
//			System.err.println(result);
			return "form :: info-form";
		}
		
		return  "form :: info-success";
	}
}
