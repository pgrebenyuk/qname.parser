package org.javalearning.testtask.qname.parser;

import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 007 on 20.09.2018.
 */

@RunWith(Parameterized.class)
public class QNameParserInvalidTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    public QNameParser parser;
    public String name;

    public QNameParserInvalidTest(String name) {
        this.name=name;
    }

    @Parameterized.Parameters(name = "{index}: \"{0}\"")
    public static List<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                {""}, {":name"}, {"."}, {".."}, {"prefix:"}, {" name"}, {" prefix:name"}, {"prefix: name"},
                {"prefix:name "}, {"pre fix:name"}, {"name/name"}, {"name[name"}, {"prefix:name:name"}
        });
    }

    @Before
    public void init() {
        parser = new RealQNameParser();
    }

    @Test
    public void parseInvalidNames() throws IllegalNameException {
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }

}