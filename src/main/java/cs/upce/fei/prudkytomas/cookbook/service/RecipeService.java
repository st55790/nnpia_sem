package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import cs.upce.fei.prudkytomas.cookbook.domain.Category;
import cs.upce.fei.prudkytomas.cookbook.domain.Ingredient;
import cs.upce.fei.prudkytomas.cookbook.domain.Recipe;
import cs.upce.fei.prudkytomas.cookbook.dto.RecipeDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.errors.ResourceNotFoundException;
import cs.upce.fei.prudkytomas.cookbook.repository.AppUserRepository;
import cs.upce.fei.prudkytomas.cookbook.repository.CategoryRepository;
import cs.upce.fei.prudkytomas.cookbook.repository.IngredientRepository;
import cs.upce.fei.prudkytomas.cookbook.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final AppUserRepository appUserRepository;
    private final IngredientRepository ingredientRepository;

    private final CategoryRepository categoryRepository;

    public List<RecipeDtoInOut> findAllRecipes() {
        List<Recipe> list = (List<Recipe>) recipeRepository.findAll();
        List<RecipeDtoInOut> dtoList = new ArrayList<>();

        for(Recipe recipe : list){
            dtoList.add(CoversionService.toDto(recipe));
        }

        return dtoList;
    }

    public RecipeDtoInOut findById(Long id) throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Recipe %s not found!", id)));
        return CoversionService.toDto(recipe);
    }

    @Transactional
    public RecipeDtoInOut create(RecipeDtoInOut recipeDtoInOut) throws ResourceNotFoundException {
        AppUser user = appUserRepository.findById(recipeDtoInOut.getOwner()).orElseThrow(()-> new ResourceNotFoundException(String.format("User %s not found", 1L)));

        List<Category> categories = recipeDtoInOut.getCategories();
        List<Ingredient> ingredients = recipeDtoInOut.getIngredients();
        List<String> links = recipeDtoInOut.getLinksToImages();

        Recipe recipe = new Recipe(null,
                recipeDtoInOut.getName(),
                recipeDtoInOut.getDescription(),
                recipeDtoInOut.getProcedure(),
                recipeDtoInOut.getPrepareTime(),
                recipeDtoInOut.getNumberOfPortions(),
                recipeDtoInOut.getRating(),
                links, ingredients, categories, null, user);

        Recipe saveRecipe = recipeRepository.save(recipe);
        System.out.println(categories);

        addRecipeIngredients(saveRecipe, recipe.getIngredients());
        addRecipeCategories(saveRecipe, recipe.getCategories());

        return CoversionService.toDto(saveRecipe);
    }

    private void addRecipeCategories(Recipe recipe, List<Category> categories) throws ResourceNotFoundException {
        for (Category item : categories){
            Category category = categoryRepository.findByName(item.getName());
            category.getRecipes().add(recipe);
            categoryRepository.save(category);
        }
    }

    private void addRecipeIngredients(Recipe recipe, List<Ingredient> ingredients) throws ResourceNotFoundException {
        for (Ingredient item : ingredients) {
            Ingredient ingredient = ingredientRepository.findByName(item.getName());
            ingredient.getRecipes().add(recipe);
            ingredientRepository.save(ingredient);
        }
    }

    public RecipeDtoInOut update(Long id, RecipeDtoInOut dto) throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Recipe %s not found", id)));
        AppUser user = appUserRepository.findById(dto.getOwner()).orElseThrow(()-> new ResourceNotFoundException(String.format("User %s not found", 1L)));

        recipe.setName(dto.getName());
        recipe.setDescription(dto.getDescription());
        recipe.setProcedure(dto.getProcedure());
        recipe.setNumberOfPortions(dto.getNumberOfPortions());
        recipe.setRating(dto.getRating());
        recipe.setOwner(user);
        recipe.setLinksToImages(dto.getLinksToImages());
        recipe.setIngredients(dto.getIngredients());
        recipe.setCategories(dto.getCategories());
        recipeRepository.save(recipe);

        return CoversionService.toDto(recipe);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Recipe %s not found", id)));
        recipeRepository.delete(recipe);
    }

    public void create(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
