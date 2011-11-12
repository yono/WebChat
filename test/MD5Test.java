import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class MD5Test extends UnitTest {

    @Test
    public void cryptByMD5() {
        assertEquals(MD5.crypt("hoge"), "ea703e7aa1efda0064eaa507d9e8ab7e");
    }

}
