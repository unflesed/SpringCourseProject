package courseProject.persistence.dao.services.implementations;

import courseProject.persistence.dao.repositories.ProfileRepository;
import courseProject.persistence.dao.services.interfaces.ProfileService;
import courseProject.persistence.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    ProfileRepository profileRepository;
    @Override
    public Profile findProfileByUserName(String userName) {
        return profileRepository.findProfileByUserName(userName);
    }

    @Override
    public void updateProfile(String userName, String firstName, String lastName, String phone, String email) {
        profileRepository.updateProfile(userName, firstName, lastName, phone, email);
    }

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
}
