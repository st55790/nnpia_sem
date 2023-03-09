package cs.upce.fei.prudkytomas.cookbook.controller;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @GetMapping
    public String getAppUsers(){
        return "Get list of movies";
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable Long id){
        return "One user";
    }

    @PostMapping
    public String createAppUser(){
        return "Create AppUser";
    }

    @PutMapping
    public String updateAppUser(){
        return "Update AppUser";
    }

    @DeleteMapping("/{id}")
    public String deleteAppUser(@PathVariable Long id){
        return "Delete Appuser";
    }
}
