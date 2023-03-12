package cs.upce.fei.prudkytomas.cookbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping
    public String getRole() {
        return "Get list of roles";
    }

    @GetMapping("/{id}")
    public String findRoleById(@PathVariable Long id) {
        return "One role";
    }

    @PostMapping
    public String createRole() {
        return "Create role";
    }

    @PutMapping
    public String updateRole() {
        return "Update role";
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        return "Delete role";
    }
}
