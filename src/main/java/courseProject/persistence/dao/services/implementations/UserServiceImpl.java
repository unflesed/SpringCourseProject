package courseProject.persistence.dao.services.implementations;

import courseProject.persistence.dao.repositories.UserRepository;
import courseProject.persistence.dao.services.interfaces.UserDetailsService;
import courseProject.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByLogin(String userName) {
        return userRepository.getUserByLogin(userName);
    }

    @Override
    public void updateUser(String userName, Long profileId) {
        userRepository.updateUser(userName, profileId);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
