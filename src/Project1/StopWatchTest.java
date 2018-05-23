package Project1;

import org.junit.Test;

import static org.junit.Assert.*;

/************************************************************************
 * CIS 163 Project 1- StopWatch
 * @author Nate Tubergen, Gabe Guilbee
 * Due: 5/23/18
 ************************************************************************/

public class StopWatchTest {

    /**
     *
     * The following are simple random JUnit test cases... After talking with your
     * instructor, create many, many more that shows that your code
     * is functioning correctly.
     *
     */

    // default constructor test
    @Test
    public void testDefaultConstructor() {
        StopWatch s = new StopWatch();
        assertTrue(s.getMinutes() == 0);
        assertTrue(s.getSeconds() == 0);
        assertTrue(s.getMilliseconds() == 0);
    }

    @Test
    public void testConstructor3Parameters()
    {
        StopWatch s = new StopWatch(2,3,4);
        assertTrue(s.getMinutes() == 2);
        assertTrue(s.getSeconds() == 3);
        assertTrue(s.getMilliseconds() == 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegal1() {
        StopWatch s = new StopWatch(12,67,14);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegal2() {
        StopWatch s = new StopWatch(12,7,1001);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegal3() {
        StopWatch s = new StopWatch(12,67,1001);
    }


    @Test
    public void testConstructor() {
        StopWatch s = new StopWatch (5,10,300);
        assertEquals(s.toString(),"5:10:300");

        s = new StopWatch("20:10:8");
        assertEquals(s.toString(),"20:10:008");

        s = new StopWatch("20:8");
        assertEquals(s.toString(),"0:20:008");

        s = new StopWatch("8");
        assertEquals(s.toString(),"0:00:008");

    }



    @Test (expected = IllegalArgumentException.class)
    public void testNegInput() {
        new StopWatch("2:-2");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput1() {
        new StopWatch("-2:2");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput2() {
        new StopWatch("2:2:-100");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput3() {
        new StopWatch("2:-2:-200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput4() {
        new StopWatch("-2:-2:200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput5() {
        new StopWatch("-2:2:-200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput6() {
        new StopWatch("-2:-2:-100");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput7() {
        new StopWatch("-200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput8() {
        new StopWatch("-2,2,-200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput9() {
        new StopWatch("-2,-2,-100");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput10() {
        new StopWatch("-200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput11() {
        new StopWatch("2,-2");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput12() {
        new StopWatch("-2,2");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput13() {
        new StopWatch("2,2,-100");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput14() {
        new StopWatch("2,-2,-200");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegInput15() {
        new StopWatch("-2,-2,200");

    }




    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput() {
        new StopWatch("a");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput1() {
        new StopWatch("a:00:00");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput2() {
        new StopWatch("00:a:00");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput3() {
        new StopWatch("00:00:a00");

    }@Test (expected = IllegalArgumentException.class)
    public void testAlphaInput4() {
        new StopWatch("00:00:a");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput5() {
        new StopWatch("a,a,a");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput6() {
        new StopWatch("a,a,0");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput7() {
        new StopWatch("0,a,a");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput8() {
        new StopWatch("a,0,a");

    }@Test (expected = IllegalArgumentException.class)
    public void testAlphaInput9() {
        new StopWatch("a,a");

    }@Test (expected = IllegalArgumentException.class)
    public void testAlphaInput10() {
        new StopWatch("a,0");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput11() {
        new StopWatch("0,a");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput12() {
        new StopWatch("a:00:a");

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput13() {
        new StopWatch("a:A:a");

    }@Test (expected = IllegalArgumentException.class)
    public void testAlphaInput14() {
        new StopWatch("a:a:00");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAlphaInput15() {
        new StopWatch("0:a:a");
    }



    @Test (expected = IllegalArgumentException.class)
    public void IllegalSub() {
        StopWatch s1 = new StopWatch("00:00:10");
        s1.sub(-10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void IllegalSub1() {
        StopWatch s1 = new StopWatch("00:00:9");
        s1.sub(10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void IllegalAdd1() {
        StopWatch s1 = new StopWatch("00:00:9");
        s1.add(-10);
    }



    @Test
    public void testAddMethod () {
        StopWatch s1 = new StopWatch (5,59,300);
        s1.add(2000);
        assertEquals (s1.toString(),"6:01:300");

        s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (2,2,300);
        s1.add(s2);
        assertEquals (s1.toString(),"8:01:600");

        for (int i = 0; i < 15000; i++)
            s1.inc();
        assertEquals (s1.toString(),"8:16:600");
    }
    @Test
    public void testSubMethod () {
        StopWatch s1 = new StopWatch (5,1,0);
        s1.sub(2000);
        assertEquals (s1.toString(),"4:59:000");

        s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (1,1,300);
        s1.sub(s2);
        assertEquals (s1.toString(),"4:58:000");

        System.out.println("YES");
        for (int i = 0; i < 15000; i++) {
            s1.dec();
        }

        assertEquals (s1.toString(),"4:43:000");
    }


    @Test
    public void testEqual () {
        StopWatch s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (6,01,200);
        StopWatch s3 = new StopWatch (5,50,200);
        StopWatch s4 = new StopWatch (5,59,300);

        assertFalse(s1.equals(s2));
        assertTrue (s1.equals(s4));

        assertTrue (s2.compareTo(s1) > 0);
        assertTrue (s3.compareTo(s1) < 0);
        assertTrue (s1.compareTo(s4) == 0);

        assertTrue(StopWatch.equals(s1, s4));
    }
    @Test
    public void testCompareTo () {
        StopWatch s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (6,01,200);
        StopWatch s3 = new StopWatch (5,50,200);
        StopWatch s4 = new StopWatch (5,59,300);

        assertFalse(s1.equals(s2));
        assertTrue (s1.equals(s4));

        assertTrue (s2.compareTo(s1) > 0);
        assertTrue (s3.compareTo(s1) < 0);
        assertTrue (s1.compareTo(s4) == 0);

    }

    @Test
    public void testAddSubstract() {

        StopWatch s2 = new StopWatch (6,01,200);
        StopWatch s3 = new StopWatch (5,50,200);

        s2.sub(s3);
        System.out.println(s2.toString());;
        assertTrue(s2.toString().equals("0:11:000"));

        s2.add(s3);
        assertTrue(s2.toString().equals("6:01:200"));

        s2.sub(200);
        System.out.println(s2.toString());;
        assertTrue(s2.toString().equals("6:01:000"));

        s2.add(200);
        assertTrue(s2.toString().equals("6:01:200"));
    }

    @Test
    public void testLoadSave () {
        StopWatch s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (5,59,300);

        s1.save("file1");
        s1 = new StopWatch ();  // resets to zero

        s1.load("file1");
        assertTrue (s1.equals(s2));
    }

    @Test
    public void equalsTest() {
        StopWatch s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (5,59,300);

        assertEquals(s1, s2);
    }

    @Test
    public void testMutate () {
        StopWatch s1 = new StopWatch (5,59,300);
        StopWatch s2 = new StopWatch (5,59,300);

        StopWatch.setSuspend(true);
        s1.add(1000);
        assertTrue (s1.equals(s2));
        StopWatch.setSuspend(false);
    }


    public void testSuspend3() {
        StopWatch s1 = new StopWatch (5,59,300);
        StopWatch s2= new StopWatch (1,0,0);

        s2.save("save.txt");

        StopWatch.setSuspend(true);

        s1.load("save.txt");
        assertTrue(s1.getMilliseconds() == 300);

        assertTrue(s1.getSeconds()==59);

        assertTrue(s1.getMinutes()==5);
    }


    @Test
    public void testInc() {
        StopWatch s1 = new StopWatch (5,59,300);

        s1.inc();

        assertTrue(s1.getMilliseconds() == 301);

    }

    @Test
    public void testToString() {
        StopWatch s1 = new StopWatch (1,1,300);
        System.out.println(s1.toString());

        assertTrue(s1.toString().equals("1:01:300"));
        s1.sub(300);


        assertTrue(s1.toString().equals("1:01:000"));
        s1.sub(1000);

        assertTrue(s1.toString().equals("1:00:000"));

        s1.sub(60000);

        assertTrue(s1.toString().equals("0:00:000"));

    }

    @Test
    public void testDec() {
        StopWatch s1 = new StopWatch (5,59,300);

        s1.dec();

        assertTrue(s1.getMilliseconds() == 299);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testContuctor() {
        @SuppressWarnings("unused")
        StopWatch d1 = new StopWatch("2,-3,-3");
    }

    @Test
    public void testEqual3() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s4));

        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertTrue(s1.compareTo(s4) == 0);

    }

    @Test
    public void testEqual2() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        assertFalse(StopWatch.equals(s1, s2));
        assertFalse(StopWatch.equals(s1, s3));
        assertTrue(StopWatch.equals(s1, s4));
        assertFalse(StopWatch.equals(s2, s3));
        assertFalse(StopWatch.equals(s2, s4));
        assertFalse(StopWatch.equals(s3, s4));

    }







    @Test
    public void testConstructorMin() {
        StopWatch s = new StopWatch(0, 0, 0);
        assertEquals(s.toString(), "0:00:000");

        s = new StopWatch(1, 0, 0);
        assertEquals(s.toString(), "1:00:000");

        s = new StopWatch(1, 1, 0);
        assertEquals(s.toString(), "1:01:000");

        s = new StopWatch(1, 1, 1);
        assertEquals(s.toString(), "1:01:001");

        s = new StopWatch(23, 59, 999);
        assertEquals(s.toString(), "23:59:999");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin1() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(0, 0, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin2() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(0, -1, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin3() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(-1, 0, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin4() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(-1, -1, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin5() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(99, 1, 1000);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin6() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(99, 1, 1001);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin7() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(99, 60, 999);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMin8() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(99, 61, 999);
    }

    @Test
    public void testConstructorSec() {
        StopWatch s = new StopWatch(0, 0);
        assertEquals(s.toString(), "0:00:000");

        s = new StopWatch(1, 0);
        assertEquals(s.toString(), "0:01:000");

        s = new StopWatch(1, 1);
        assertEquals(s.toString(), "0:01:001");

        s = new StopWatch(59, 999);
        assertEquals(s.toString(), "0:59:999");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorSec1() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(0, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorSec2() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(-1, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorSec3() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(1, 1000);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorSec4() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(1, 1001);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorSec5() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(60, 999);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorSec6() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(61, 999);
    }

    @Test
    public void testConstructorMilli() {
        StopWatch s = new StopWatch(0);
        assertEquals(s.toString(), "0:00:000");

        s = new StopWatch(1);
        assertEquals(s.toString(), "0:00:001");

        s = new StopWatch(999);
        assertEquals(s.toString(), "0:00:999");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMilli1() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMilli2() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(1000);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorMilli3() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch(1001);
    }

    @Test
    public void testConstructorString() {
        StopWatch s = new StopWatch("0:0:0");
        assertEquals(s.toString(), "0:00:000");

        s = new StopWatch("1:1:1");
        assertEquals(s.toString(), "1:01:001");

        s = new StopWatch("9999:59:999");
        assertEquals(s.toString(), "9999:59:999");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString1() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("0:0:-1");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString2() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("0:-1:0");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString3() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("-1:0:0");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString4() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("-1:-1:-1");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString5() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("0:0:1000");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString6() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("0:0:1001");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString7() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("0:60:0");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString8() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("0:61:0");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErrorString9() {
        @SuppressWarnings("unused")
        StopWatch s = new StopWatch("654:654:654");
    }

}