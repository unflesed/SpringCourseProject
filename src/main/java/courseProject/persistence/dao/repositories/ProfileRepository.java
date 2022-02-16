package courseProject.persistence.dao.repositories;

import courseProject.persistence.model.Journal;
import courseProject.persistence.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query(value = "SELECT * from profile p join users u on p.id = u.profile_id where u.username = ?1",
            nativeQuery = true)
    Profile findProfileByUserName(String userName);
}
