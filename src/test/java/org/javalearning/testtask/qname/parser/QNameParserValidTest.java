package org.javalearning.testtask.qname.parser;

import org.javalearning.testtask.qname.entity.QName;
import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.javalearning.testtask.qname.parser.QNameParser;
import org.javalearning.testtask.qname.parser.RealQNameParser;
import org.junit.*;

/**
 * Created by 007 on 20.09.2018.
 */
public class QNameParserValidTest {
    private QNameParser parser = new RealQNameParser();

    @Test
    public void testValidName() throws IllegalNameException {
        QName qName = parser.parse("prefix:name");
        Assert.assertEquals("prefix:name", qName.getAsString());
    }

    @Test
    public void testValidName2() throws IllegalNameException {
        QName qName = parser.parse("prefix:na me");
        Assert.assertEquals("prefix:na me", qName.getAsString());
    }

}
