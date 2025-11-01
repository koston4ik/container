import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContainerTest {
	
	private Container<String> container;
	
	@Before
    public void setUp() {
        container = new Container<>();
    }
	
	@Test
    public void testAddAndGet() {
        container.Add("Hello");
        assertEquals("Hello", container.GetItem(0));
        assertEquals(1, container.GetSize());
    }
}
