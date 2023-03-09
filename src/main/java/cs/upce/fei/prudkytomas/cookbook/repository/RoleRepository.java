package cs.upce.fei.prudkytomas.cookbook.repository;

import cs.upce.fei.prudkytomas.cookbook.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
