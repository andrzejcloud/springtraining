package tacocloud.demo.data;

import org.springframework.data.repository.CrudRepository;
import tacocloud.demo.domain.Ingredient;

public interface IngredientRepo extends CrudRepository<Ingredient, String> {

}
