package ajayonjava.springframework.services;

import ajayonjava.springframework.command.RecipeCommand;
import ajayonjava.springframework.converters.RecipeCommandToRecipe;
import ajayonjava.springframework.converters.RecipeToRecipeCommand;
import ajayonjava.springframework.domain.Recipe;
import ajayonjava.springframework.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeServiceIT {
    private final String DESCRIPTION = "Test Description";

    @Autowired
    RecipeServiceImpl recipeService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Transactional
    @Test
    void testSaveOfDescription(){
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(DESCRIPTION);
        RecipeCommand saveRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        assertEquals(DESCRIPTION,saveRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(),saveRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(),saveRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(),saveRecipeCommand.getIngredients().size());
    }
}
