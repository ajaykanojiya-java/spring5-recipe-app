package ajayonjava.springframework.services;

import ajayonjava.springframework.converters.RecipeCommandToRecipe;
import ajayonjava.springframework.converters.RecipeToRecipeCommand;
import ajayonjava.springframework.domain.Recipe;
import ajayonjava.springframework.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class RecipeServiceImplT {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    void setUp() {
        //initialization for mock. if not provided then 'recipeRepository.findAll()' will throw NPE
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository,recipeToRecipeCommand,recipeCommandToRecipe);
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipeData = new HashSet<>();
        Recipe recipe = new Recipe();
        recipeData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeData);
        Set<Recipe> recipes =  recipeService.getRecipes();
        assertEquals(1,recipes.size());
        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    void getRecipeByIdTest(){
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe returnedRecipe = recipeService.findRecipeById(1L);
        assertNotNull(returnedRecipe);
        verify(recipeRepository,times(1)).findById(anyLong());
    }
}