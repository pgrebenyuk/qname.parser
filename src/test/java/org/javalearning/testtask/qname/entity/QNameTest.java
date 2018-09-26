package org.javalearning.testtask.qname.entity;

import org.javalearning.testtask.qname.entity.QName;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 007 on 20.09.2018.
 */
public class QNameTest {
    @Test
    public void testGetAsString() {
        QName qName = new QName("local");
        Assert.assertEquals("local", qName.getAsString());
    }
    @Test
    public void testsetPrefix() {
        QName qName = new QName("local");
        qName.setPrefix("prefix");
        Assert.assertEquals("prefix:local", qName.getAsString());
    }
}
