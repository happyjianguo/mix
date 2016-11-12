package com.fanteathy;

/**
 * Created by joshua on 16/11/12.
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.Map;

public class RedisPipeline {

    public static void main(String[] args) throws Exception {
        Jedis redis = new Jedis("127.0.0.1", 6379, 400000);
        Map<String, String> data = new HashMap<String, String>();
        redis.select(8);
        redis.flushDB();

        //直接hmset
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            data.clear();
            data.put("k_" + i, "v_" + i);
            redis.hmset("key_" + i, data);
        }
        long end = System.currentTimeMillis();
        System.out.println("dbsize: [" + redis.dbSize() + "] ..");
        System.out.println("hmset without pipeline used [" + (end - start) + "] millseconds");
        redis.select(8);
        redis.flushDB();

        //使用pipeline hmset
        Pipeline p = redis.pipelined();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            data.clear();
            data.put("k_" + i, "v_" + i);
            p.hmset("key_" + i, data);
        }
        p.sync();
        end = System.currentTimeMillis();
        System.out.println("dbsize: [" + redis.dbSize() + "] ..");
        System.out.println("hmset with pipeline used [" + (end - start) + "] millseconds...");
        redis.disconnect();
    }

}
