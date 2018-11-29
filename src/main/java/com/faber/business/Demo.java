package com.faber.business;

import java.util.Random;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@Service
public class Demo {

    @Cacheable("cacheDemo")
    public String cacheDemo(String strInput) {
        System.out.println("init cache");
        return strInput;
    }

    @CachePut("cacheDemo")
    public String updateCacheDemo(String strInput) {
        Random rand = new Random();
        return strInput + " " + rand.nextInt();
    }

    @CacheEvict(value = "cacheDemo", allEntries = true)
    public void deleteCacheDemo() {
    }
}
