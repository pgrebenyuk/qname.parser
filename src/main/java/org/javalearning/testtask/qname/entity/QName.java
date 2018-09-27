package org.javalearning.testtask.qname.entity;

/**
 * Created by 007 on 19.09.2018.
 */
public class QName {
    private String prefix;
    private String localName;

    public QName(String localName) {
        this.localName = localName != null ? localName : "";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QName qName = (QName) o;

        if (prefix != null ? !prefix.equals(qName.prefix) : qName.prefix != null) return false;
        return localName != null ? localName.equals(qName.localName) : qName.localName == null;

    }

    @Override
    public int hashCode() {
        int result = prefix != null ? prefix.hashCode() : 0;
        result = 31 * result + (localName != null ? localName.hashCode() : 0);
        return result;
    }
}
