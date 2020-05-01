package ajayonjava.springframework.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //generates setter and getter for properties inside the class
@Entity
public class UnitOfMeasure {

    //IDENTITY: it will generate a sequence of id values using underlying DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
