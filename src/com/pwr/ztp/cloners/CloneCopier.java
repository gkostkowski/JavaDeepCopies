package com.pwr.ztp.cloners;

import com.pwr.ztp.core.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzesiek on 2017-04-17.
 */
public class CloneCopier {

    private CloneCopier() {
    }

    static public Object deepCopy(Object oldObj) throws Exception {
        List<Country> list = (List<Country>) oldObj;
        List<Country> res = new ArrayList<>();
        for (Country c : list) {
            res.add((Country)singleClone(c));
        }
        return res;
    }

    private static Object singleClone(Country c) throws CloneNotSupportedException {
        return c.clone();
    }

}
