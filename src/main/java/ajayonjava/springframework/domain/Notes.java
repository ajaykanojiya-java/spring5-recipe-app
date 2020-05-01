package ajayonjava.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data //generates setter and getter for properties inside the class
@Entity
@EqualsAndHashCode(exclude = {"recipe"})
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //here no need to put cascade because if Notes is deleted then we dont want Recipe to be deleted. Bi-directional
    private Recipe recipe; //recipe id will be added in Notes table as a foreign key.

    @Lob //String will make 255 char space in DB but if we want more than that then LOB(Large Objects).
    private String recipeNotes;
}
