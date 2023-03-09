package cs.upce.fei.prudkytomas.cookbook.service;

import cs.upce.fei.prudkytomas.cookbook.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
}
