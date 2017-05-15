package com.pwr.ztp.gen;

import com.pwr.ztp.core.Country;

import java.util.List;

/**
 * Created by Grzesiek on 2017-04-10.
 */
public class CountryGenerator extends Generator<Country> {
    private ProvinceGenerator pg = null;
    private int provincesNbr;
    private int citiesNbr;

    public CountryGenerator(int provincesNbr) {
        this.provincesNbr = provincesNbr;
    }

    private ProvinceGenerator getProvinceGenerator() {
        if (pg == null)
            pg = new ProvinceGenerator(provincesNbr);
        return pg;
    }

    @Override
    public List<Country> callGenerator(int... n) {
        setCitiesNbr(n[2]);
        setProvincesNbr(n[1]);
        return generateInstances(n[0]);
    }

    @Override
    protected Country makeInstance() {
        return new Country(nextString(rand.nextInt(30) + 10),
                rand.nextBoolean(),
                rand.nextBoolean(),
                rand.nextDouble() * (double) rand.nextInt(1500) + 20,
                nextString(rand.nextInt(30) + 10),
                getProvinceGenerator().callGenerator(provincesNbr, citiesNbr));
    }

    public void setProvincesNbr(int provincesNbr) {
        this.provincesNbr = provincesNbr;
    }

    public void setCitiesNbr(int citiesNbr) {
        this.citiesNbr = citiesNbr;
    }
}
