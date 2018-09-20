package org.javalearning.testtask.qname.exception;

/**
 * Created by 007 on 19.09.2018.
 */
public class IllegalNameException extends Exception {
    public IllegalNameException(String illegalName) {
        super("Not valid name: " + illegalName);
    }
}
