package ajayonjava.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data// project lombok. annotation generates the setter and getter method for properties in the class
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne //using to make it bi-directional mapping
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER) //unidirectional mapping
    private UnitOfMeasure unitOfMeasure;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        //this.recipe = recipe; //to add a recipe id as a foreign key in Ingredient table.
        //will be handled in addIngredient() method of Recipe class.
    }
}
