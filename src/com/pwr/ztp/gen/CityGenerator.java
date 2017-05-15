package com.pwr.ztp.gen;

import com.pwr.ztp.core.City;

import java.util.List;

/**
 * Created by Grzesiek on 2017-04-10.
 */
public class CityGenerator extends Generator<City>{

    private final int MAX_POP = 18000000;
    private final int MIN_POP = 20000;

    @Override
    public List<City> callGenerator(int... n) {
        return generateInstances(n[0]);
    }

    @Override
    protected City makeInstance() {
        return new City(nextString(rand.nextInt(30)+10),
                rand.nextInt(MAX_POP-MIN_POP)+MIN_POP,
                nextString(rand.nextInt(30)+10),
                rand.nextDouble()*(double) rand.nextInt(1500)+20);
    }
}
