package com.autenticacao.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autenticacao.apirest.models.Autenticacao;


//Objetivo de criar persistencia com Banco de dados
public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long> {
	
	Autenticacao findById(long id);
	Autenticacao findByEmail(String email, int password);
	
	
	

}