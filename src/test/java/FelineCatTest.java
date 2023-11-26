import com.example.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FelineCatTest {

    @Test
    public void testFeline() throws Exception {
        Animal animalMock = mock(Animal.class);
        Feline feline = new Feline(animalMock);

        when(animalMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        assertEquals("Кошачьи", feline.getFamily());
        assertEquals(1, feline.getKittens());
        assertEquals(3, feline.getKittens(3));

        assertThrows(Exception.class, () -> {
            // Поместили вызов, который ожидаем вызвать исключение, в лямбда-выражение
            feline.eatMeat();
        });
    }

    @Test
    public void testCat() throws Exception {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);

        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Корм для кошки"));

        assertEquals("Мяу", cat.getSound());
        assertEquals(Arrays.asList("Корм для кошки"), cat.getFood());
    }
}
