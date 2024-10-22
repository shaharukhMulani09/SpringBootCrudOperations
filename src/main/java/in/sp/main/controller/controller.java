package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Entitie;
import in.sp.main.service.service;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/products")
public class controller {
	
	@Autowired
	private service services;

	@GetMapping
	public List<Entitie> allproducts(){
		
		return services.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entitie> getingByid(@PathVariable int id){
		
		Entitie entitie = services.findId(id);
		
		return entitie != null ? ResponseEntity.ok(entitie) : ResponseEntity.notFound().build();
			
	}
	
	@PostMapping
	public Entitie create(@RequestBody Entitie entitie) {
		
		return services.saveid(entitie);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Entitie> update(@PathVariable int id, @RequestBody Entitie entitie){
	
		entitie.setId(id);
		
		return ResponseEntity.ok(services.saveid(entitie)); 
}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		
		services.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
}
