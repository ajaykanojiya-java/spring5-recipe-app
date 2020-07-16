package ajayonjava.springframework.converters;

import ajayonjava.springframework.command.CategoryCommand;
import ajayonjava.springframework.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String description = "description";
    CategoryCommandToCategory converter;

    @BeforeEach
    public void setup(){
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void testConvert(){
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(description);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE,category.getId());
        assertEquals(description,category.getDescription());
    }
}
