package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import cs.upce.fei.prudkytomas.cookbook.domain.Category;
import cs.upce.fei.prudkytomas.cookbook.domain.Ingredient;
import cs.upce.fei.prudkytomas.cookbook.domain.Role;
import cs.upce.fei.prudkytomas.cookbook.dto.*;

public class CoversionService {

    public static AppUserDtoOut toDto(AppUser appUser){
        return new AppUserDtoOut(appUser.getUsername(), appUser.getEmail());
    }

    public static AppUser toEntity(AppUserDtoIn dto){
        return new AppUser(dto.getUsername(), dto.getPassword(), dto.getEmail());
    }

    public static CategoryDtoInOut toDto(Category category) {
        return new CategoryDtoInOut(category.getName());
    }

    public static Category toEntity(CategoryDtoInOut dto){
        return new Category(dto.getName());
    }

    public static IngredientDtoInOut toDto(Ingredient ingredient) {
        return new IngredientDtoInOut(ingredient.getName());
    }

    public static Ingredient toEntity(IngredientDtoInOut dto){
        return new Ingredient(dto.getName());
    }

    public static RoleDtoInOut toDto(Role role) {
        return new RoleDtoInOut(role.getName());
    }

    public static Role toEntity(RoleDtoInOut dto){
        return new Role(dto.getName());
    }
}
