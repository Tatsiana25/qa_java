import com.example.Feline;
import com.example.Lion;
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

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        new Lion("InvalidSex", felineMock);
    }

    @Test
    public void testLionGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(0, lion.getKittens());
    }

    @Test
    public void testLionGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Корм для льва"));

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(List.of("Корм для льва"), lion.getFood());
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
