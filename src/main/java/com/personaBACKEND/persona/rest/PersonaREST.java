package com.personaBACKEND.persona.rest;

import java.net.URI;
import java.util.List;

import com.personaBACKEND.persona.model.Persona;
import com.personaBACKEND.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas/")
public class PersonaREST {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersonas (){
		return ResponseEntity.ok(personaService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Persona> savePersona (@RequestBody Persona persona){
		try {
			Persona personaGuardada = personaService.save(persona);		
		return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deletePersona (@PathVariable ("id") Long id){
		personaService.deleteById(id);
		return ResponseEntity.ok(!(personaService.findById(id)!=null));
		
	}

}
