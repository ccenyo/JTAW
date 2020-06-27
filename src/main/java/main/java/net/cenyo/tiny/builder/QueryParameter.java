package main.java.net.cenyo.tiny.builder;

import main.java.net.cenyo.tiny.utils.EncodingUtil;

public class QueryParameter {


    private final String name;


    private final String value;

    public QueryParameter(String name, String value) {
        this.name = name;
        this.value = EncodingUtil.encode(value);
    }


    public QueryParameter(String name, boolean value) {
        this(name, String.valueOf(value));
    }


    public QueryParameter(String name, long value) {
        this(name, String.valueOf(value));
    }

    public String getName() {
        return name;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s=%s", name, value);
    }

}
