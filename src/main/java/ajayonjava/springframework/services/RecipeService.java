package ajayonjava.springframework.services;

import ajayonjava.springframework.command.RecipeCommand;
import ajayonjava.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findRecipeById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
