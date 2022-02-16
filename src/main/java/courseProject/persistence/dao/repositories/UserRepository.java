package courseProject.persistence.dao.repositories;

import courseProject.persistence.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, String> {
    User getUserByLogin(String userName);

    @Modifying
    @Query(value = "update users u set u.profile_id = ?2 where username = ?1",
            nativeQuery = true)
    void updateUser(String userName, Long profileId);
}
