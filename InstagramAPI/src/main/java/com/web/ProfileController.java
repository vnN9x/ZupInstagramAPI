package com.web;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.model.Img;
import com.model.Seguidores;
import com.model.Seguindo;
import com.model.User;
import com.model.UserDetailRequest;
import com.repository.ImgRepository;
import com.repository.SeguidoresRepository;
import com.repository.SeguindoRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/perfil")
public class ProfileController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ImgRepository imgRepository;
	@Autowired
	SeguindoRepository seguindoRepository;
	@Autowired
	SeguidoresRepository seguidoresRepository;
	
	@PostMapping //cria um novo perfil
	public ResponseEntity<?> registerUserAccount(@RequestBody User user) {
		User saveUser = userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/perfil").path("{/id}")
				.buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping //mostra todos os perfis criados
	public ResponseEntity<List<User>> listUser(){
		return ResponseEntity.ok().body(userRepository.findAll());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //mostra as informações de um unico perfil em "/perfil/id"
	public ResponseEntity<User> getById(@PathVariable long id){
		return ResponseEntity.ok().body(userRepository.findById(id).get());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST) //posta uma imagem de um perfil especifico em "/perfil/id"
	public ResponseEntity<?> addImgById(@PathVariable long id, @RequestBody Img img){
		User users = userRepository.findById(id).get();
		img.setUser(users);
		Img saveImg = imgRepository.save(img);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/perfil").path("{/id}")
				.buildAndExpand(saveImg.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path="/{id}") //atualiza as informações de uma perfil selecionado em "/perfil/id"
	public ResponseEntity<User> updateProfileById(@PathVariable long id, @Valid @RequestBody UserDetailRequest userDetail) {
		User user = userRepository.findById(id).get();
		user.setBiografia(userDetail.getBiografia());
		user.setEmail(userDetail.getEmail());
		user.setGenero(userDetail.getGenero());
		user.setNomeCompleto(userDetail.getNomeCompleto());
		user.setPerfilImg(userDetail.getPerfilImg());
		user.setSenha(userDetail.getSenha());
		user.setSite(userDetail.getSite());
		user.setUserName(userDetail.getUserName());
		user.setTelefone(userDetail.getTelefone());
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}") //deleta completamente um perfil em "/perfil/id"
	public ResponseEntity<Void> deleteProfile(@PathVariable long id){
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/feed/{id}") //mostra todas as imagens postadas por um id "/feed/id"
	public List<Img> findByUserId(@PathVariable long id){
		List<Img> imgs = imgRepository.findByUserId(id);
		return imgs;
	}
	
	@PostMapping(path= "/seguindo/{id}") //Utiliza o perfil do path para seguir outro perfil informando seu ID
	public ResponseEntity<Seguindo> seguir(@PathVariable long id, @RequestBody Seguindo seguindo, Seguidores seguidores){
		User users = userRepository.findById(id).get();
		seguindo.setUser(users);
		seguidores.setUser(users);
		seguidores.setRequestId(id);
		seguidoresRepository.save(seguidores);
		Seguindo saveSeguindo = seguindoRepository.save(seguindo);
		return new ResponseEntity<Seguindo>(saveSeguindo, HttpStatus.OK);
	}
	
	
	@GetMapping("/seguindo/{id}") //Vê quem o perfil do path(ID) está seguindo
	public List<Seguindo> follow(@PathVariable long id){
		List<Seguindo> seguindos = seguindoRepository.findByUserId(id);
		return seguindos;
	}
	
	@GetMapping("/seguidores/{id}") //Vê quem são os seguidores do perfil do path(id)
	public List<Seguidores> showFollowers(@PathVariable long id){
		List<Seguidores> seguidores = seguidoresRepository.findByUserId(id);
		return seguidores;
	}
	
}
