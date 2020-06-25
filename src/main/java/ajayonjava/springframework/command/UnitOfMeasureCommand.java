package ajayonjava.springframework.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generate setter and getter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;
    private String description;
}
