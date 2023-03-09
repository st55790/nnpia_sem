package cs.upce.fei.prudkytomas.cookbook.repository;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

}
