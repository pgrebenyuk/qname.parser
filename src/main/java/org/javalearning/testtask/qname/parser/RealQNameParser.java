package org.javalearning.testtask.qname.parser;

import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.javalearning.testtask.qname.entity.QName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 007 on 19.09.2018.
 */
public class RealQNameParser implements QNameParser {
    private static final String NONSPACE = "[^/:\\[\\]\\*\\'\\\"\\|\\s]";
    private static final String CHAR = NONSPACE + "| ";
    private static final String STRING = "(" + CHAR + ")+";
    private static final String XML_NAME_START_CHAR = "[A-Z_a-z\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u02FF\\u0370-"
            + "\\u037D\\u037F-\\u1FFF\\u200C-\\u200D\n\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\uFDCF\\u"
            + "FDF0-\\uFFFD]";
    private static final String XML_NAME_CHAR = "[-\\.0-9A-Z_a-z\\u00B7\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u037D"
            + "\\u037F-\\u1FFF\\u200C-\\u200D\n\\u203F\\u2040\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\u"
            + "FDCF\\uFDF0-\\uFFFD]";
    private static final String PREFIX  = XML_NAME_START_CHAR + "(" + XML_NAME_CHAR + ")*";
    private static final String ONECHARSIMPLENAME = "[^\\./:\\[\\]\\*\\'\\\"\\|\\s]";
    private static final String TWOCHARSIMPLENAME = "(\\." + ONECHARSIMPLENAME + ")|(" + ONECHARSIMPLENAME + "\\.)|("
            + ONECHARSIMPLENAME + ONECHARSIMPLENAME + ")";
    private static final String THREEORMORECHARNAME = NONSPACE + STRING + NONSPACE;
    private static final String ONECHARLOCALNAME = NONSPACE;
    private static final String TWOCHARLOCALNAME = NONSPACE + NONSPACE;
    private static final String SIMPLENAME = "(" + THREEORMORECHARNAME + ")|(" + TWOCHARSIMPLENAME + ")|("
            + ONECHARSIMPLENAME + ")";
    private static final String LOCAL_NAME = "(" + THREEORMORECHARNAME + ")|(" + TWOCHARLOCALNAME + ")|"
            + ONECHARLOCALNAME;
    private static final String PREFIXED_NAME = PREFIX + ":(" + LOCAL_NAME + ")";
    private static final String NAME = "(" + PREFIXED_NAME + ")|(" + SIMPLENAME + ")";
    private static final Pattern PATTERN = Pattern.compile(NAME);

    public QName parse(String name) throws IllegalNameException {
        QName qName;
        Matcher matcher = PATTERN.matcher(name);
        if (matcher.matches()) {
            String[] splittedName = name.split(":");
            if (splittedName.length == 2) {
                qName = new QName(splittedName[1]);
                qName.setPrefix(splittedName[0]);
            } else {
                qName = new QName(splittedName[0]);
            }
        } else {
            throw new IllegalNameException(name);
        }

        return qName;
    }

}

