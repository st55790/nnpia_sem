package cs.upce.fei.prudkytomas.cookbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping
    public String getCategory(){
        return "Get list of categories";
    }

    @GetMapping("/{id}")
    public String findCategoryById(@PathVariable Long id){
        return "One category";
    }

    @PostMapping
    public String createCategory(){
        return "Create category";
    }

    @PutMapping
    public String updateCategory(){
        return "Update category";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return "Delete category";
    }
}
