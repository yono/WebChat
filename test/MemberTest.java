import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class MemberTest extends UnitTest {
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		Fixtures.deleteAll();
	}

    @Test
    public void createMember() {
    	User user = new User("user", "secret", "User");
        Channel channel = new Channel("hoge");
        Member member = new Member(user, channel, false);
        assertEquals(member.user.name, "user");
        assertEquals(member.user.fullname, "User");
        assertEquals(member.channel.getName(), "hoge");
    }

}
