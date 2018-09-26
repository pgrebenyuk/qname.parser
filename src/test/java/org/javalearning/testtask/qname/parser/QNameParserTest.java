package org.javalearning.testtask.qname.parser;

import org.javalearning.testtask.qname.entity.QName;
import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.junit.*;
import org.junit.rules.ExpectedException;

/**
 * Created by 007 on 20.09.2018.
 */
public class QNameParserTest {
    private QNameParser parser = new RealQNameParser();
    public String name;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testValidName01() throws IllegalNameException {
        QName qName = parser.parse("prefix:name");
        Assert.assertEquals("prefix:name", qName.getAsString());
    }
    @Test
    public void testValidName02() throws IllegalNameException {
        QName qName = parser.parse("prefix:na me");
        Assert.assertEquals("prefix:na me", qName.getAsString());
    }
    @Test
    public void testValidName03() throws IllegalNameException {
        QName qName = parser.parse("name");
        Assert.assertEquals("name", qName.getAsString());
    }
    @Test
    public void testInvalidNames01() throws IllegalNameException {
        name = "";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames02() throws IllegalNameException {
        name = ":name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames03() throws IllegalNameException {
        name = ".";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames04() throws IllegalNameException {
        name = "..";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames05() throws IllegalNameException {
        name = "prefix:";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames06() throws IllegalNameException {
        name = " name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames07() throws IllegalNameException {
        name = " prefix:name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames08() throws IllegalNameException {
        name = "prefix: name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames09() throws IllegalNameException {
        name = "prefix:name ";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames10() throws IllegalNameException {
        name = "pre fix:name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames11() throws IllegalNameException {
        name = "name/name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames12() throws IllegalNameException {
        name = "name[name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
    @Test
    public void testInvalidNames13() throws IllegalNameException {
        name = "prefix:name:name";
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }
}
