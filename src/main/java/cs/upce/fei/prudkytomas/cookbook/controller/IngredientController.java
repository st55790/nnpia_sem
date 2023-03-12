package cs.upce.fei.prudkytomas.cookbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @GetMapping
    public String getIngredient(){
        return "Get list of ingredient";
    }

    @GetMapping("/{id}")
    public String findIngredientById(@PathVariable Long id){
        return "One ingredient";
    }

    @PostMapping
    public String createIngredient(){
        return "Create ingredient";
    }

    @PutMapping
    public String updateIngredient(){
        return "Update ingredient";
    }

    @DeleteMapping("/{id}")
    public String deleteIngredient(@PathVariable Long id){
        return "Delete ingredient";
    }

}
