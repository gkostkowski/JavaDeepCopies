package com.pwr.ztp.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Grzesiek on 2017-04-10.
 */
public abstract class Generator<T> {

    protected Random rand = new Random();

    public abstract List<T> callGenerator(int... n);

    public List<T> generateInstances(int n){
        List<T> res = new ArrayList<>();

        for (int i=0; i< n; i++) {
            res.add(makeInstance());
        }
        return res;
    }

    protected abstract T makeInstance();

    protected String nextString(int n) {
        StringBuilder res = new StringBuilder();
        for (int i =0; i < n; i++) {
            res.append((char) (rand.nextInt(25) + 97));
        }
        return res.toString();
    }
}
