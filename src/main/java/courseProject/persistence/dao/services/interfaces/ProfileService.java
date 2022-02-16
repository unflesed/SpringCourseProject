package courseProject.persistence.dao.services.interfaces;

import courseProject.persistence.model.Profile;

public interface ProfileService {
    Profile findProfileByUserName(String userName);
}
