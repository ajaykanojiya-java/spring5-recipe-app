package ajayonjava.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //generates setter and getter for properties inside the class
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer cookTime;
    private Integer preparationTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob //tell to hibernate make space available more than 255 char on DB
    private String direction;

    @Lob //for large object. It will make BLOB on DB side.
    private Byte[] image;

    //we are going to make Recipe is owner entity therefore if Recipe is deleted then Notes must be deleted.
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    public Set<Ingredient> ingredients = new HashSet<>();

    // EnumType.ORDINAL: default value means number will be saved DB corresponding to enum values
    // EnumType.STRING: original string will be saved to DB
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();


    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    /*public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }*/
}
