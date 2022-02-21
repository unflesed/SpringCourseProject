package courseProject.persistence.dao.services.interfaces;

import courseProject.persistence.model.Profile;

public interface ProfileService {
    Profile findProfileByUserName(String userName);
    void updateProfile(Long idProfile, String firstName, String lastName, String phone, String email);
    Profile saveProfile(String firstName, String lastName, String phone, String email);
}
