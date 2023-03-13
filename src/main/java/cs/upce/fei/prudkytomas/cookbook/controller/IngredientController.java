package cs.upce.fei.prudkytomas.cookbook.controller;

import cs.upce.fei.prudkytomas.cookbook.dto.CategoryDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.dto.IngredientDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.service.CategoryService;
import cs.upce.fei.prudkytomas.cookbook.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientDtoInOut>> getIngredients(){
        return ResponseEntity.ok(ingredientService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDtoInOut> findIngredientById(@PathVariable Long id){
        return ResponseEntity.ok(ingredientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<IngredientDtoInOut> createIngredient(@RequestBody @Validated IngredientDtoInOut ingredient){
        return ResponseEntity.ok(ingredientService.create(ingredient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientDtoInOut> updateIngredient(@RequestBody @Validated IngredientDtoInOut ingredient, @PathVariable Long id){
        return ResponseEntity.ok(ingredientService.update(id, ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable Long id){
        ingredientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
