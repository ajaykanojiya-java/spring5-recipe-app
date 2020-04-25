package ajayonjava.springframework.services;

import ajayonjava.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
