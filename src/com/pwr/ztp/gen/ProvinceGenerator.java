package com.pwr.ztp.gen;

import com.pwr.ztp.core.Province;

import java.util.List;

/**
 * Created by Grzesiek on 2017-04-10.
 */
public class ProvinceGenerator extends Generator<Province> {
    private CityGenerator cg = null;
    private int citiesNbr;

    public ProvinceGenerator(int citiesNbr) {
        this.citiesNbr = citiesNbr;
    }

    private CityGenerator getCityGenerator() {
        if (cg == null)
            cg = new CityGenerator();
        return cg;
    }

    @Override
    public List<Province> callGenerator(int... n) {
        setCitiesNbr(n[1]);
        return generateInstances(n[0]);
    }

    @Override
    protected Province makeInstance() {
        return new Province(nextString(rand.nextInt(30) + 10),
                rand.nextDouble() * (double) rand.nextInt(1500) + 20,
                nextString(rand.nextInt(30) + 10),
                getCityGenerator().callGenerator(citiesNbr), null);
    }

    public void setCitiesNbr(int citiesNbr) {
        this.citiesNbr = citiesNbr;
    }
}
