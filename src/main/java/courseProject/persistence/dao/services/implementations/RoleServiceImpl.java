package courseProject.persistence.dao.services.implementations;

import courseProject.persistence.dao.repositories.RoleRepository;
import courseProject.persistence.dao.services.interfaces.RoleService;
import courseProject.persistence.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
