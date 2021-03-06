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

    @Override
    public List<Journal> findAllByUserName(String userName) {
        return journalRepository.findAllByUserName(userName);
    }

    @Override
    public void subscribeJournal(String userName, Long idJournal) {
        journalRepository.subscribeJournal(userName, idJournal);
    }

    @Override
    public boolean checkSubscription(String userName, Long idJournal) {
        List<Journal> journalsByUserName = journalRepository.findAllByUserName(userName);
        Journal journal = journalRepository.getJournalById(idJournal);
        for (Journal j: journalsByUserName) {
            if (j.equals(journal)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSubscribeJournal(String userName, Long idJournal) {
        journalRepository.unSubscribeJournal(userName, idJournal);
    }

    @Override
    public void unSubscribeAllUsers(Long idJournal) {
        journalRepository.unSubscribeAllUsers(idJournal);
    }

    @Autowired
    public void setJournalRepository(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
}
