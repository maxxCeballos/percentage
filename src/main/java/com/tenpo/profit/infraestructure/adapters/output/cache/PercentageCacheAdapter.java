package com.tenpo.profit.infraestructure.adapters.output.cache;

import com.tenpo.profit.application.ports.output.PercentageCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class PercentageCacheAdapter  implements PercentageCache {

    @Autowired
    private RedisTemplate<String, String> template;

    public PercentageCacheAdapter(){};

    @Override
    public String get(String key) {
        var percentageValueCatch = template.opsForValue().get(key);

        return percentageValueCatch;
    }

    @Override
    public boolean save(String key, String value) {
        template.opsForValue().set(key, value);
        return true;
    }
}
