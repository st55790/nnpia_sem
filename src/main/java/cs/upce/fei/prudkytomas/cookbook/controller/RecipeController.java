package cs.upce.fei.prudkytomas.cookbook.controller;

import cs.upce.fei.prudkytomas.cookbook.domain.Recipe;
import cs.upce.fei.prudkytomas.cookbook.dto.RecipeDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.errors.ResourceNotFoundException;
import cs.upce.fei.prudkytomas.cookbook.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeDtoInOut>> getRecipes(){
        return ResponseEntity.ok(recipeService.findAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDtoInOut> findRecipeById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RecipeDtoInOut> createRecipe(@RequestBody @Validated RecipeDtoInOut recipeDtoInOut) throws ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.create(recipeDtoInOut));
    }

    @PutMapping
    public ResponseEntity<RecipeDtoInOut> updateRecipe(@RequestBody @Validated RecipeDtoInOut recipe, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.update(id, recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) throws ResourceNotFoundException {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
