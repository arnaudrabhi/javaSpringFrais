package fr.limayrac.declarationFrais.declarationFrais.repository;

import fr.limayrac.declarationFrais.declarationFrais.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}
