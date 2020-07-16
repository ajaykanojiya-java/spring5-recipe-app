package ajayonjava.springframework.converters;

import ajayonjava.springframework.command.CategoryCommand;
import ajayonjava.springframework.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String description = "description";
    CategoryToCategoryCommand converter;

    @BeforeEach
    public void setup(){
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void testConvert(){
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(description);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertEquals(ID_VALUE,categoryCommand.getId());
        assertEquals(description,categoryCommand.getDescription());
    }
}
