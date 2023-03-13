package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.domain.Role;
import cs.upce.fei.prudkytomas.cookbook.dto.IngredientDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.dto.RoleDtoInOut;
import cs.upce.fei.prudkytomas.cookbook.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<RoleDtoInOut> findAllRoles() {
        List<Role> list = (List<Role>) roleRepository.findAll();
        List<RoleDtoInOut> dtoList = new ArrayList<>();

        for(Role role:list){
            dtoList.add(CoversionService.toDto(role));
        }

        return dtoList;
    }

    public void delete(Long id) {
        roleRepository.delete(roleRepository.findById(id).orElse(null));
    }

    public RoleDtoInOut findById(Long id) {
        return CoversionService.toDto(roleRepository.findById(id).orElse(null));
    }

    public RoleDtoInOut create(RoleDtoInOut role) {
        return CoversionService.toDto(roleRepository.save(CoversionService.toEntity(role)));
    }

    public RoleDtoInOut update(Long id, RoleDtoInOut dto) {
        Role role = roleRepository.findById(id).orElse(null);
        role.setName(dto.getName());
        return CoversionService.toDto(roleRepository.save(role));
    }
}
