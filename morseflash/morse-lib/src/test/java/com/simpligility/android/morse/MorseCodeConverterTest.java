package com.simpligility.android.morse;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * MorseCodeConverterTest is the unit test suite for {@link com.simpligility.android.morse.MorseCodeConverter}.
 * @author Manfred Moser
 */
public class MorseCodeConverterTest extends TestCase {

    /**
     * Test the timing parameters for signals.
     */
    public void testSetup()
    {
        Assert.assertEquals(MorseCodeConverter.GAP, 100);
        Assert.assertEquals(MorseCodeConverter.DASH, 300);
        Assert.assertEquals(MorseCodeConverter.DOT, 100);
    }

    /**
     * Test the string "SOS".
     */
    public void testSOS()
    {
        long[] sosArrayExpected = new long[] {0,100,100,100,100,100,300,300,100,300,100,300,300,100,100,100,100,100,0};
        long[] actual = MorseCodeConverter.pattern("SOS");
        Assert.assertArrayEquals(sosArrayExpected, actual);
    }

    public void testCaseSensitivity()
    {
        Assert.assertArrayEquals(MorseCodeConverter.pattern("sos"), MorseCodeConverter.pattern("SOS"));
        Assert.assertArrayEquals(MorseCodeConverter.pattern("sOs"), MorseCodeConverter.pattern("SOS"));
    }

    public void testSomeNumbers()
    {
        long[] expected = new long[]{0,100,100,300,100,300,100,300,100,300,300,100,100,100,100,300,100,300,100,300,300,
                100,100,100,100,100,100,300,100,300,0};
        long[] actual = MorseCodeConverter.pattern("123");
        Assert.assertArrayEquals(expected, actual);
    }

    public void testWhitespaceTreatment()
    {
        long[] expected = MorseCodeConverter.pattern("Hello World");
        long[] actual = MorseCodeConverter.pattern("123");
        Assert.assertEquals(expected, actual);
    }

}
