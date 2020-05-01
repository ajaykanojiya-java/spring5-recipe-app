package ajayonjava.springframework.controller;

import ajayonjava.springframework.domain.Recipe;
import ajayonjava.springframework.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


@Slf4j
@Controller
public class IndexController {

    private RecipeServiceImpl recipeService;

    public IndexController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(Model model){
        log.debug("index controller called..");
       Set<Recipe> recipeSet = recipeService.getRecipes();
       model.addAttribute("recipeSet",recipeSet);
        return "index";
    }
}
