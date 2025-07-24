import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN offbyn = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertTrue(offbyn.equalChars('a', 'f'));
        assertTrue(offbyn.equalChars('f', 'a'));
        assertFalse(offbyn.equalChars('f', 'h'));
        assertFalse(offbyn.equalChars('z', 'z'));
    }
}
