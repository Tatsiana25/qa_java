import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final Animal animal;
    private final String animalKind;
    private final List<String> expectedFood;

    public AnimalParameterizedTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.animal = mock(Animal.class);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFood() throws Exception {
        when(animal.getFood(animalKind)).thenReturn(expectedFood);
        assertEquals(expectedFood, animal.getFood(animalKind));
    }
}