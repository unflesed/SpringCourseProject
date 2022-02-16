package courseProject.persistence.dao.services.interfaces;

import courseProject.persistence.model.User;

public interface UserDetailsService {
    User addUser(User user);

    User getUserByLogin(String userName);

    void updateUser(String userName, Long profileId);
}
