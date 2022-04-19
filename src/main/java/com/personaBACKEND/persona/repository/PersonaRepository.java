package com.personaBACKEND.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personaBACKEND.persona.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
