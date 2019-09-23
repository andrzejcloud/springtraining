package tacocloud.demo.data;

import tacocloud.demo.domain.Ingredient;

public interface IngredientRepo {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
