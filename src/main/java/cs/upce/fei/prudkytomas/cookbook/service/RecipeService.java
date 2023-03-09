package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
}
