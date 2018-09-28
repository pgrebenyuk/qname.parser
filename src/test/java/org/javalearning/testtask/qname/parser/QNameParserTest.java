package org.javalearning.testtask.qname.parser;

import org.javalearning.testtask.qname.entity.QName;
import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.junit.*;

/**
 * Created by 007 on 20.09.2018.
 */
public class QNameParserTest {
    private QNameParser parser = new RealQNameParser();

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
    public void testValidName04() throws IllegalNameException {
        QName qName = parser.parse("≥name");
        Assert.assertEquals("≥name", qName.getAsString());
    }

    @Test
    public void testValidName05() throws IllegalNameException {
        QName qName = parser.parse("na»me");
        Assert.assertEquals("na»me", qName.getAsString());
    }

    @Test
    public void testValidName06() throws IllegalNameException {
        QName qName = parser.parse("name®");
        Assert.assertEquals("name®", qName.getAsString());
    }

    @Test
    public void testValidName07() throws IllegalNameException {
        QName qName = parser.parse("prefixXML:name");
        Assert.assertEquals("prefixXML:name", qName.getAsString());
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames01() throws IllegalNameException {
        parser.parse("");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames02() throws IllegalNameException {
        parser.parse(":name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames03() throws IllegalNameException {
        parser.parse(".");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames04() throws IllegalNameException {
        parser.parse("..");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames05() throws IllegalNameException {
        parser.parse("prefix:");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames06() throws IllegalNameException {
        parser.parse(" name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames07() throws IllegalNameException {
        parser.parse(" prefix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames08() throws IllegalNameException {
        parser.parse("prefix: name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames09() throws IllegalNameException {
        parser.parse("prefix:name ");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames10() throws IllegalNameException {
        parser.parse("pre fix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames11() throws IllegalNameException {
        parser.parse("name/name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames12() throws IllegalNameException {
        parser.parse("name[name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames13() throws IllegalNameException {
        parser.parse("prefix:name:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames14() throws IllegalNameException {
        parser.parse("?prefix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames15() throws IllegalNameException {
        parser.parse("pre«fix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames16() throws IllegalNameException {
        parser.parse("prefix>:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNames17() throws IllegalNameException {
        parser.parse("1prefix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testInvalidNamesXML() throws IllegalNameException {
        parser.parse("Xml:name");
    }

 }
