package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import cs.upce.fei.prudkytomas.cookbook.dto.AppUserDtoIn;
import cs.upce.fei.prudkytomas.cookbook.dto.AppUserDtoOut;

public class CoversionService {

    public static AppUserDtoOut toDto(AppUser appUser){
        return new AppUserDtoOut(appUser.getUsername(), appUser.getEmail());
    }

    public static AppUser toEntity(AppUserDtoIn dto){
        return new AppUser(dto.getUsername(), dto.getPassword(), dto.getEmail());
    }
}
