package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);
	
}
