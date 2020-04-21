package ajayonjava.springframework.controller;

import ajayonjava.springframework.domain.Category;
import ajayonjava.springframework.domain.UnitOfMeasure;
import ajayonjava.springframework.repository.CategoryRepository;
import ajayonjava.springframework.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(){
        System.out.println("controller called...");
        Optional<Category> optionalCategory = categoryRepository.findByDescription("");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("");

        System.out.println("Category ID: "+optionalCategory.get().getId());
        System.out.println("Unit Of Measure ID: "+optionalUnitOfMeasure.get().getId());
        return "index";
    }
}
