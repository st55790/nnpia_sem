package cs.upce.fei.prudkytomas.cookbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @GetMapping
    public String getRecipes(){
        return "Get all recipes";
    }

    @GetMapping("/{id}")
    public String findRecipeById(@PathVariable Long id){
        return "One recipe";
    }

    @PostMapping
    public String createRecipe(){
        return "Create recipe";
    }

    @PutMapping
    public String updateRecipe(){
        return "Update recipe";
    }

    @DeleteMapping("/{id}")
    public String deleteRecipe(){
        return "Delete recipe";
    }
}
