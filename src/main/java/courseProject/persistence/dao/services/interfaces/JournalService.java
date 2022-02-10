package courseProject.persistence.dao.services.interfaces;

import courseProject.persistence.model.Journal;

import java.util.List;

public interface JournalService {

    List<Journal> findAll() throws InterruptedException;

    Journal addJournal(Journal journal);

    void removeById(long id);

    void updateJournal(long id, String journalName, String genre, String periodicity, int cost);

    List<Journal> findJournalByGenre(String genre);

}
