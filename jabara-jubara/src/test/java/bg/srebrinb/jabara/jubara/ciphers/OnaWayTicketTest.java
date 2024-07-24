package bg.srebrinb.jabara.jubara.ciphers;

import  bg.srebrinb.jabara.jubara.ciphers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srebrin
 */
public class OnaWayTicketTest {
    
    public OnaWayTicketTest() {
    }

    @Test
    public void testGetTicket() throws Exception {
        OnaWayTicket.getTicket();
    }

    @Test
    public void testFlyAway() throws Exception {
        String fly=OnaWayTicket.flyAway("message");
    }
    
}
