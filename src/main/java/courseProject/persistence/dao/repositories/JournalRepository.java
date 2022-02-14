package courseProject.persistence.dao.repositories;

import courseProject.persistence.model.Journal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface JournalRepository extends CrudRepository<Journal, Long> {

    List<Journal> findJournalByGenre(String genre);

    @Modifying
    @Query(value = "update journal j set j.journal_name = ?2, j.genre = ?3, j.periodicity = ?4, j.cost = ?5" +
            "  where j.id = ?1",
            nativeQuery = true)
    void updateJournal(long id, String journalName, String genre, String periodicity, int cost);

    @Query(value = "SELECT * from journal j join users_journal uj on j.id = uj.journal_id where uj.username = ?1",
            nativeQuery = true)
    List<Journal> findAllByUserName(String userName);
}
