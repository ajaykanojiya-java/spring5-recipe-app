package ajayonjava.springframework.controller;

import ajayonjava.springframework.domain.Recipe;
import ajayonjava.springframework.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Mock
    RecipeServiceImpl recipeService;
    @Mock
    Model model;
    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        //to verify any argument is being captured then ArgumentCaptor is used.

        //given
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        Recipe recipe = new Recipe(); recipe.setId(1L);
        recipeSet.add(recipe);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String result = indexController.getIndexPage(model);

        //then
        assertEquals("index", result);
        verify(recipeService,times(1)).getRecipes();
        //verify(model,times(1)).addAttribute(eq("recipeSet"),anySet());
        //if we use any matcher method like anySet then it is necessary to use eq("")i.e. for which string we are using
        // the matcher method.
        verify(model,times(1)).addAttribute(eq("recipeSet"),argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        //assertEquals(2,setInController.size());
    }
}