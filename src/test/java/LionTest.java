import com.example.Feline;
import com.example.FelineMock;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void testLionMale() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionFemale() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionInvalidSex() {
        Feline felineMock = Mockito.mock(Feline.class);

        try {
            new Lion("InvalidSex", felineMock);
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void testLionGetFood() throws Exception {
        Predator felineMock = new FelineMock();
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(List.of("Корм для Хищника"), lion.getFood());
    }

    @Test
    public void testLionInvalidSexThrowsException() {
        Feline felineMock = Mockito.mock(Feline.class);

        try {
            new Lion("InvalidSex", felineMock);
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
