package courseProject.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import courseProject.persistence.dao.repositories.JournalRepository;
import courseProject.persistence.dao.services.interfaces.JournalService;
import courseProject.persistence.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {
    private JournalRepository journalRepository;

    @Override
    public List<Journal> findAll() throws InterruptedException {
        return Lists.newArrayList(journalRepository.findAll());
    }

    @Override
    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public void removeById(long id) {
        journalRepository.deleteById(id);
    }

    @Override
    public void updateJournal(long id, String journalName, String genre, String periodicity, int cost) {
        journalRepository.updateJournal(id, journalName, genre, periodicity, cost);
    }

    @Override
    public List<Journal> findJournalByGenre(String genre) {
        return journalRepository.findJournalByGenre(genre);
    }


    @Autowired
    public void setJournalRepository(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
}
