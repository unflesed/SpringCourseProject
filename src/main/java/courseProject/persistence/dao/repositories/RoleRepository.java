package courseProject.persistence.dao.repositories;

import courseProject.persistence.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {
}
