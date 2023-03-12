package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import cs.upce.fei.prudkytomas.cookbook.dto.AppUserDtoIn;
import cs.upce.fei.prudkytomas.cookbook.dto.AppUserDtoOut;
import cs.upce.fei.prudkytomas.cookbook.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Transactional
    public AppUserDtoOut create(AppUserDtoIn dto){
        AppUser appUser =  appUserRepository.save(CoversionService.toEntity(dto));
        return CoversionService.toDto(appUser);
    }

    public List<AppUserDtoOut> getAllAppUsers() {
        List<AppUser> list = (List<AppUser>) appUserRepository.findAll();
        List<AppUserDtoOut> dtoList = new ArrayList<>();

        for (AppUser appUser:list) {
            dtoList.add(CoversionService.toDto(appUser));
        }

        return dtoList;
    }

    public AppUserDtoOut findById(Long id) {
        return CoversionService.toDto(appUserRepository.findById(id).orElse(null));
    }

    public AppUserDtoOut update(Long id, AppUserDtoIn appUserDtoIn) {
        AppUser appUser = appUserRepository.findById(id).orElse(null);
        appUser.setUsername(appUserDtoIn.getUsername());
        appUser.setPassword(appUserDtoIn.getPassword());
        appUser.setEmail(appUserDtoIn.getEmail());
        return CoversionService.toDto(appUserRepository.save(appUser));
    }
}
