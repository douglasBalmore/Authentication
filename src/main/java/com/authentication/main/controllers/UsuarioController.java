package com.authentication.main.controllers;

import java.security.Principal;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.authentication.main.entities.Usuario;
import com.authentication.main.entities.UsuarioForm;
import com.authentication.main.repositories.IUsuarioRepository;

@Controller
@RequestMapping(value = "userController")
public class UsuarioController {
	
	private final IUsuarioRepository iUsuarioRepository;
	
	public UsuarioController(IUsuarioRepository iUsuarioRepository) {
		this.iUsuarioRepository = iUsuarioRepository;
	}
	
	@GetMapping("/register")
	public String register(Model model, UsuarioForm usuarioForm) {
		return "register";
	}

	@PostMapping("/register")
	public String register(Model model, Usuario usuario, UsuarioForm usuarioForm, HttpServletRequest req , BindingResult result) throws ParseException {
		
		if (usuarioForm.getName().matches("^[a-zA-Z0-9]{3,}$") && req.getParameter("repetirContrasenhia") != null && req.getParameter("repetirContrasenhia").equals(usuarioForm.getPassword())){
			usuario = new Usuario(usuarioForm.getName().trim(), 
					usuarioForm.getApellido().trim(),
					usuarioForm.getTelefono().trim(),
					usuarioForm.getEmail().trim(),
					new BCryptPasswordEncoder().encode(usuarioForm.getPassword()),
					usuarioForm.getSexo(),
					usuarioForm.getNombreContactoEmergencia(),
					usuarioForm.getNumeroContactoEmergencia(),
					true);
		}
		else {
			result.rejectValue("name", "username");
			return "register";
		}

		try {
			this.iUsuarioRepository.save(usuario);
		} catch(DataIntegrityViolationException ex){
			ex.printStackTrace();
			result.rejectValue("name", "name");
			return "register";
		}

		return "redirect:/";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model){
		model.addAttribute("users", iUsuarioRepository.findAll());
		return "users";
	}

	/*@GetMapping("/login")
	public String login() {
		return "login";
	}*/
	
	//Primer método que se carga al arrancar el programa
	@GetMapping("/")
	public String profile(Model model, Principal principal, UsuarioForm usuarioForm) throws Exception {
		if (principal == null) {
			model.addAttribute("usuarioForm", usuarioForm);
			return "index";
		}
		
		Usuario user = iUsuarioRepository.findByEmail(principal.getName()).orElseThrow(() -> new Exception());
		
		model.addAttribute("usuario", user);
		
		return "profile";
	
	}
}
