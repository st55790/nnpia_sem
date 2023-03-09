package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import cs.upce.fei.prudkytomas.cookbook.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Transactional
    public AppUser create(){
        AppUser appUser1 = new AppUser();
        appUser1.setEmail("test@sdsd.com");
        appUser1.setPassword("d4ds54s5d4s5dsd");
        appUser1.setUsername("daddasdadasd");
        return appUserRepository.save(appUser1);
    }
}
