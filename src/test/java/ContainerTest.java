import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContainerTest {
	
	private Container<String> containerS;
	private Container<Integer> containerI;
	
	@Before
    public void setUp() {
        containerS = new Container<>();
        containerI = new Container<>();
    }
	
	@Test
    public void TestAddAndGet() {
        containerS.Add("text");
        assertEquals("text", containerS.GetItem(0));
        assertNotEquals("", containerS.GetItem(0));
        assertEquals(1, containerS.GetSize());
        
        containerI.Add(5);
        assertEquals(5, (int) containerI.GetItem(0));
        assertNotEquals(0, (int) containerI.GetItem(0));
        assertEquals(1, containerI.GetSize());
    }
	
	@Test
    public void TestRemove() {
        containerS.Add("ABC");
        containerS.Add("DEF");
        containerS.Remove(1);
        assertEquals("ABC", containerS.GetItem(0));
        assertEquals(1, containerS.GetSize());
        containerS.Remove(0);
        assertEquals(0, containerS.GetSize());
        
        containerI.Add(123);
        containerI.Add(456);
        containerI.Remove(0);
        assertEquals(456, (int) containerI.GetItem(0));
        assertEquals(1, containerI.GetSize());
        containerI.Remove(0);
        assertEquals(0, containerI.GetSize());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestGetFromEmpty() {
	    containerS.GetItem(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestRemoveFromEmpty() {
	    containerS.Remove(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestGetOutOfRange() {
	    containerS.Add("abc");
	    containerS.GetItem(5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestRemoveOutOfRange() {
	    containerS.Add("def");
	    containerS.Remove(3);
	}
}
