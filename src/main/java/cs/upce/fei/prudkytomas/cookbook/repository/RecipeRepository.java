package cs.upce.fei.prudkytomas.cookbook.repository;

import cs.upce.fei.prudkytomas.cookbook.domain.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {
}
