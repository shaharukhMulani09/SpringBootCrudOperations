package in.sp.main.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import in.sp.main.entity.Entitie;

@Component
public interface userrepository extends JpaRepository<Entitie, Integer>{

	
	
}
