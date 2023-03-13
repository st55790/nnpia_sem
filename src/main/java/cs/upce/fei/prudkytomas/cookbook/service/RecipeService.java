package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.Recipe;
import cs.upce.fei.prudkytomas.cookbook.dto.RecipeDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.errors.ResourceNotFoundException;
import cs.upce.fei.prudkytomas.cookbook.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    public RecipeDtoInOut create(RecipeDtoInOut recipeDtoInOut) {
        Recipe recipe = recipeRepository.save(CoversionService.toEntity(recipeDtoInOut));
        return CoversionService.toDto(recipe);
    }
}
