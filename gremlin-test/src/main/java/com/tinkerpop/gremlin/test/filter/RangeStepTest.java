package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RangeStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_rangeX0_1X(Iterator<Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            pipe.next();
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV(Iterator<Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("lop") || name.equals("ripple"));
        }
        assertEquals(counter, 1);
    }

    public void test_g_v1_outXknowsX_outXcreatedX_rangeX0_0X(Iterator<Vertex> pipe) {
        this.test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV(pipe);
    }

    public void test_g_v1_outXcreatedX_inXcreatedX_rangeX1_2X(Iterator<Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("marko") || name.equals("josh") || name.equals("peter"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_outXcreatedX_inEXcreatedX_rangeX1_2X_outV(Iterator<Vertex> pipe) {
        this.test_g_v1_outXcreatedX_inXcreatedX_rangeX1_2X(pipe);
    }

}