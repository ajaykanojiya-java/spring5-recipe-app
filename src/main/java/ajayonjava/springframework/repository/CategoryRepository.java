package ajayonjava.springframework.repository;

import ajayonjava.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    //just need to declare method with property name in the class. description is the property in Category class
    //therefore method name findBy<property_name>().
    //Here spring boot provides the implementation for this interface and generates dynamic sql to get the desired data.
    Optional<Category> findByDescription(String description);
}
