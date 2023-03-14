package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.Recipe;
import cs.upce.fei.prudkytomas.cookbook.dto.RecipeDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.errors.ResourceNotFoundException;
import cs.upce.fei.prudkytomas.cookbook.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

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
    public RecipeDtoInOut create(RecipeDtoInOut recipeDtoInOut) {
        Recipe recipe = CoversionService.toEntity(recipeDtoInOut);
        recipeRepository.save(recipe);
        System.out.println(recipeDtoInOut.toString());
        //return null;
        return CoversionService.toDto(recipe);
    }

    public RecipeDtoInOut update(Long id, RecipeDtoInOut dto) throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Recipe %s not found", id)));

        recipe.setName(dto.getName());
        recipe.setDescription(dto.getDescription());
        recipe.setProcedure(dto.getProcedure());
        recipe.setNumberOfPortions(dto.getNumberOfPortions());
        recipe.setRating(dto.getRating());
        recipe.setOwner(dto.getOwner());
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
