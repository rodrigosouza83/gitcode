package com.autenticacao.apirest.resources;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autenticacao.apirest.repository.AutenticacaoRepository;
import com.autenticacao.apirest.models.Autenticacao;


//Essa API possui os CRUDs necessários para o projeto AUTENTICAR ALUNO - <TCC PUC MINAS>.

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AutenticacaoResource {
	
	@Autowired
	AutenticacaoRepository autenticacaoRepository;
	
	@GetMapping("/alunos")
	public List<Autenticacao> listaAutenticacao(){
		return autenticacaoRepository.findAll();
	
	}
	
	//Esse método irá consultar um aluno apenas buscando pelo ID.
	@GetMapping("/aluno/{id}")
	public Optional<Autenticacao> listaAutenticacaoUnica(@PathVariable(value="id") Long id){
		return autenticacaoRepository.findById(id);
	}
	
	//Método para salvar um registro de aluno
	@PostMapping("/aluno")
	public Autenticacao salvaAutenticacao(@RequestBody Autenticacao autenticacao) {
		return autenticacaoRepository.save(autenticacao);
	}
	
	//Método para deletar um registro de aluno
		@DeleteMapping("/aluno")
		public void deletaAutenticacao(@RequestBody Autenticacao autenticacao) {
			autenticacaoRepository.delete(autenticacao);
		}
		
		//Método para atualizar um registro de aluno
				@PutMapping("/aluno")
				public Autenticacao atualizaAutenticacao(@RequestBody Autenticacao autenticacao) {
					return autenticacaoRepository.save(autenticacao);
				}
					
					//Fazer login no APP
				@PostMapping("/login")
				public boolean login(@RequestBody Autenticacao user) {

					Autenticacao userLoggedIn = this.autenticacaoRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

					return Objects.nonNull(userLoggedIn);
				}
}



