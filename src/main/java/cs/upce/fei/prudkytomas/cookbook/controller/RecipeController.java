package cs.upce.fei.prudkytomas.cookbook.controller;

import cs.upce.fei.prudkytomas.cookbook.domain.Recipe;
import cs.upce.fei.prudkytomas.cookbook.dto.RecipeDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.errors.ResourceNotFoundException;
import cs.upce.fei.prudkytomas.cookbook.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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

    @GetMapping("/owner/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<RecipeDtoInOut>> findUserRecipes(@PathVariable Long id) throws  ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.findRecipesByOwner(id));
    }

    @GetMapping("/favorite/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<RecipeDtoInOut>> findUserFavorites(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.findFavoriteRecipes(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RecipeDtoInOut> createRecipe(@RequestBody RecipeDtoInOut recipeDtoInOut) throws ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.create(recipeDtoInOut));
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RecipeDtoInOut> updateRecipe(@RequestBody @Validated RecipeDtoInOut recipe, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(recipeService.update(id, recipe));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) throws ResourceNotFoundException {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{recipeId}/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteFavorite(@PathVariable Long recipeId, @PathVariable Long userId) throws ResourceNotFoundException {
        recipeService.deleteFavorite(recipeId, userId);
        return ResponseEntity.ok().build();
    }

}
