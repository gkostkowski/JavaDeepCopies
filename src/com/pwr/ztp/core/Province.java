package com.pwr.ztp.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzesiek on 2017-04-10.
 */
public class Province implements Cloneable, Serializable {
    String name;
    double income;
    String provinceHead;

    List<City> cities;
    List<Province> neighbours;


    public Province() {
    }

    public Province(String name, double income, String provinceHead, List<City> cities, List<Province> neighbours) {
        this.name = new String(name);
        this.income = income;
        this.provinceHead = new String(provinceHead);
        this.cities = cities;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getProvinceHead() {
        return provinceHead;
    }

    public void setProvinceHead(String provinceHead) {
        this.provinceHead = provinceHead;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Province> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Province> neighbours) {
        this.neighbours = neighbours;
    }

    boolean isNeighbour(Province province) {
        return cities.contains(province);
    }

    boolean hasCity(City city) {
        return cities.contains(city);
    }

    long getTotalPopulation() {
        long res = 0;
        for (City c : cities)
            res += c.getPopulation();
        return res;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     *
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     *
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     *
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     *
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        List<City> newCities = new ArrayList<>();
        for (City c : cities)
            newCities.add((City) c.clone());
        List<Province> newNeighbours = new ArrayList<>();
        if (neighbours != null)
            for (Province p : neighbours)
                newNeighbours.add((Province) p.clone());
        return new Province(name, income, provinceHead, newCities, newNeighbours);
    }


    @Override
    public String toString() {
        return "\n\tProvince{" +
                "name='" + name + '\'' +
                ", income=" + income +
                ", provinceHead='" + provinceHead + '\'' +
                ", cities=" + cities +
                ", neighbours=" + neighbours +
                '}' + "\n";
    }
}
