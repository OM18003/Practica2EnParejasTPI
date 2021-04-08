/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author Chris Oliva
 */
public class ContainerTest extends TestCase {

    private Container container = null;
    private int num_Packages_To_Test = 5;
    private Package[] b = null;
    private double package_Unit_Volume = 10.0;

    public ContainerTest(String testName) {
        super(testName);
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    @Override
    protected void setUp() throws Exception {
        assertTrue("Test case error, you must test at least 1 Package",
                num_Packages_To_Test > 0);
        // We create the Packages that we need.
        b = new Package[num_Packages_To_Test];
        for (int i = 0; i < num_Packages_To_Test; i++) {
            b[i] = new Package((i + 1) * package_Unit_Volume);
        }
        // Now, we create the Container 
        container = new Container();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of add method, of class Container.
     */
    public void testAdd() {
        container.clear();
        for (int i = 0; i < num_Packages_To_Test; i++) {
            assertTrue("container.add(Package) failed to add a new Package", container.add(b[i]));
            assertFalse("container.add(Package) seems to allow the same Package to be added twice", container.add(b[i]));
            assertTrue("container does not contain a Package after it is supposed to have been added", container.contains(b[i]));
        }
    }
}

/**
 * Test of remove method, of class Container.
 */
    public void testRemove() {
        container.clear();
            assertFalse("container.remove(Package) should fail because Container is empty, but it didn't", container.remove(b[0]));
 for (int i=0; i<num_Packages_To_Test; i++) {
 container.clear();
 for (int j=0; j<i; j++) {
 container.add(b[j]);
 }
 for (int j=0; j<i; j++) {
 assertTrue("container.remove(Package) failed to remove a Package that is supposed to be inside", container.remove(b[j]));
 assertFalse("container still contains a Package after it is supposed to have been removed!", container.contains(b[j]));
 }
 for (int j=i; j<num_Packages_To_Test; j++) {
 assertFalse("container.remove(Package) did not fail for a Package that is not inside", container.remove(b[j]));
 }
 }
 } 

    /**
     * Test of getVolume method, of class Container.
     */
    @Test
        public void testGetVolume() {
        System.out.println("getVolume");
        Container instance = new Container();
        double expResult = 0.0;
        double result = instance.getVolume();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Container.
     */
    @Test
        public void testSize() {
        System.out.println("size");
        Container instance = new Container();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Container.
     */
    @Test
        public void testClear() {
        System.out.println("clear");
        Container instance = new Container();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Container.
     */
    @Test
        public void testContains() {
        System.out.println("contains");
        Package b = null;
        Container instance = new Container();
        boolean expResult = false;
        boolean result = instance.contains(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}