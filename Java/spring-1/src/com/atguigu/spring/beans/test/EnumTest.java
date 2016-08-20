package com.atguigu.spring.beans.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by joshua on 16/6/6.
 */
public class EnumTest{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<String >> futures = new ArrayList<Future<String>>(4);
        for(int i = 0;i<10;i++){
            futures.add(pool.submit(new StringTask()));
        }

        for(Future<String> future: futures){
            String result = future.get();
            System.out.println(result.toString());
        }
        pool.shutdown();

    }
}

class StringTask implements Callable<String>{
    public String call(){
        //Long operations
        return "Run";
    }
}
