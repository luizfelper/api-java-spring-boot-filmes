package com.felper.tst.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felper.tst.model.Filme;
import com.felper.tst.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeRepository filmeRepository;

	@GetMapping
	public List<Filme> listFilme() {
		return filmeRepository.findAll();
	};
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Filme addFilme(@RequestBody Filme filme) {
		return filmeRepository.save(filme);
	}
	
	@PutMapping(value = "/{id}")
	public Filme updateFilme(@PathVariable Long id, @RequestBody Filme filme) {
		Filme filmeAtual = filmeRepository.findById(id).get();
		BeanUtils.copyProperties(filme, filmeAtual, "id");
		return filmeRepository.save(filmeAtual);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Boolean> removeFilme(@PathVariable Long id) {
		filmeRepository.deleteById(id);
		return ResponseEntity.ok(true);
	}
	
}
