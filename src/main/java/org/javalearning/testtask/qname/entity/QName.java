package org.javalearning.testtask.qname.entity;

/**
 * Created by 007 on 19.09.2018.
 */
public class QName {
    private String prefix;
    private String localName;

    public QName(String localName) {
        this.localName = localName;
    }

    public String getAsString() {
        if (prefix == null) {
            return localName;
        } else {
            return prefix + ":" + localName;
        }
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
