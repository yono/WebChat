import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends UnitTest {
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		Fixtures.deleteAll();
		Fixtures.load("data.yml");
	}

    @Test
    public void createUser() {
    	User user = new User("username", "pass", "Fullname");
    	user.save();
        assertEquals("username", user.name);
        assertEquals("Fullname", user.fullname);
    }
    
    @Test
    public void connectToUser() {
    	assertTrue(User.connect("bob", "secret"));
    }

}
