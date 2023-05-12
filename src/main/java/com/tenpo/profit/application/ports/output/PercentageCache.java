package com.tenpo.profit.application.ports.output;

public interface PercentageCache {

    String get(String key);

    boolean save(String key, String value);
}
