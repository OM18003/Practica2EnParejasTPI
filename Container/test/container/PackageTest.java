package container;

import org.junit.Test;
import junit.framework.TestCase;

public class PackageTest extends TestCase {

    public PackageTest(String testName) {
        super(testName);
    }

    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Package instance = new Package(1.0);
        double expResult = 1.0;
        double result = instance.getVolume();
        assertEquals(expResult, result);
    }

}
