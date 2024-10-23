package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Entitie;
import in.sp.main.userrepo.userrepository;

@Service
public class service {
	
	
	
	
	@Autowired
	private userrepository repo;
	
	

	public List<Entitie> findAll(){
		return repo.findAll();	
	}
	
	
	public Entitie findId(int id){
		
		return repo.findById(id).orElse(null);
	}
	
	public Entitie saveid(Entitie entitie) {
		
		return repo.save(entitie);
	}
	
	
	public void delete(int id) {
		
		 repo.deleteById(id);
	}
	
	

}
