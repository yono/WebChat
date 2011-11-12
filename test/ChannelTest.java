import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class ChannelTest extends UnitTest {
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		Fixtures.deleteAll();
	}

    @Test
    public void createChannel() {
        Channel channel = new Channel("hoge");
        assertEquals(channel.getName(), "hoge");
    }
    
    @Test
    public void updateChannel() {
    	Channel channel = new Channel("hoge");
    	channel.setName("fuga");
    	assertTrue(channel.createdAt.compareTo(channel.updatedAt) >= 0);
    }

}
