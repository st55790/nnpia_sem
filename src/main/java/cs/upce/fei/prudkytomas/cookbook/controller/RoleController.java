package cs.upce.fei.prudkytomas.cookbook.controller;

import cs.upce.fei.prudkytomas.cookbook.dto.IngredientDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.dto.RoleDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.service.IngredientService;
import cs.upce.fei.prudkytomas.cookbook.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDtoInOut>> getCategory(){
        return ResponseEntity.ok(roleService.findAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDtoInOut> findCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoleDtoInOut> createCategory(@RequestBody @Validated RoleDtoInOut dto){
        return ResponseEntity.ok(roleService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDtoInOut> updateCategory(@RequestBody @Validated RoleDtoInOut dto, @PathVariable Long id){
        return ResponseEntity.ok(roleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
