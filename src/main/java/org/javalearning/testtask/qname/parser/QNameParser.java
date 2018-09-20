package org.javalearning.testtask.qname.parser;

import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.javalearning.testtask.qname.entity.QName;

/**
 * Created by 007 on 19.09.2018.
 */
public interface QNameParser {
     QName parse(String name) throws IllegalNameException;
}
