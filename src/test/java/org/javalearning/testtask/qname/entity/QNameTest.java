package org.javalearning.testtask.qname.entity;

import org.javalearning.testtask.qname.entity.QName;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 007 on 20.09.2018.
 */
public class QNameTest {
    @Test
    public void testGetAsString1() {
        QName qName = new QName(null);
        Assert.assertEquals("", qName.getAsString());
    }

    @Test
    public void testGetAsString2() {
        QName qName = new QName("local");
        Assert.assertEquals("local", qName.getAsString());
    }

    @Test
    public void testSetPrefix() {
        QName qName = new QName("local");
        qName.setPrefix("prefix");
        Assert.assertEquals("prefix:local", qName.getAsString());
    }

    @Test
    public void testHashCode() {
        QName qName = new QName("local");
        QName qName2 = new QName("local");
        Assert.assertEquals(qName.hashCode(), qName2.hashCode());
    }

    @Test
    public void testEquals() {
        QName qName = new QName("local");
        QName qName2 = new QName("local");
        Assert.assertEquals(qName, qName2);
    }

    @Test
    public void testEquals1() {
        QName qName = new QName("local");
        QName qName2 = new QName("localOther");
        Assert.assertNotEquals(qName, qName2);
    }

    @Test
    public void testEquals2() {
        QName qName = new QName("local");
        String qName2 = "local";
        Assert.assertNotEquals(qName, qName2);
    }

    @Test
    public void testEquals3() {
        QName qName = new QName("local");
        QName qName2 = null;
        Assert.assertNotEquals(qName, qName2);
    }
}
