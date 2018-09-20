package org.javalearning.testtask.qname.starter;

import org.javalearning.testtask.qname.entity.QName;
import org.javalearning.testtask.qname.exception.IllegalNameException;
import org.javalearning.testtask.qname.parser.QNameParser;
import org.javalearning.testtask.qname.parser.RealQNameParser;

/**
 * Created by 007 on 19.09.2018.
 */
public class Start {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                QNameParser realQNameParser = new RealQNameParser();
                QName qName = realQNameParser.parse(args[0]);
                System.out.println(qName.getAsString());
            } catch (IllegalNameException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Please, use quotes if you want to use few words in parameters. Example \"few words\"");
        }
    }
}
