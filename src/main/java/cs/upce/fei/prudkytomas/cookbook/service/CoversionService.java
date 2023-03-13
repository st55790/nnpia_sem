package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.*;
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

    public static RecipeDtoInOut toDto(Recipe recipe) {
        return new RecipeDtoInOut(
                recipe.getName(),
                recipe.getDescription(),
                recipe.getProcedure(),
                recipe.getPrepareTime(),
                recipe.getNumberOfPortions(),
                recipe.getRating(),
                recipe.getOwner(),
                recipe.getLinksToImages(),
                recipe.getIngredients(),
                recipe.getCategories());
    }

    public static Recipe toEntity(RecipeDtoInOut dto) {
        return new Recipe(
                dto.getName(),
                dto.getDescription(),
                dto.getProcedure(),
                dto.getPrepareTime(),
                dto.getNumberOfPortions(),
                dto.getLinksToImages(),
                dto.getIngredients(),
                dto.getCategories(),
                dto.getOwner());
    }
}
