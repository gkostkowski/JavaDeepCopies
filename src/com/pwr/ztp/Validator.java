package com.pwr.ztp;

import com.pwr.ztp.core.City;
import com.pwr.ztp.core.Country;
import com.pwr.ztp.core.Province;

import java.util.Iterator;

/**
 * Sprawdza poprawnosc wykonania glebokiej kopii, tzn. czy na zadnym z obiektow nie zostala wykonana plytka kopia.
 */
public class Validator {

    private Validator(){

    }

    /**
     * Zakladamy ze oryginal jest rozny od kopii wtedy i tylko wtedy gdy kazdy obiekt i podobiekt w hierarchii jest rozny
     * od swojego odpowiednika
     * @param original
     * @param copy
     * @return
     */
    static public boolean areDiverse(Country original, Country copy) {
        boolean res = false;
        if (original != copy) {
            Iterator<Province> it1 = original.getProvinces().iterator(), it2 = copy.getProvinces().iterator();
            while (it1.hasNext() && it2.hasNext()) {
                Province p1 = it1.next(), p2 = it2.next();
                if (p1 == p2 || !areDiverse(p1, p2))
                    return false;
            }
            res = true;
        }
        return res;
    }

    static public boolean areDiverse(Province original, Province copy) {
        boolean res = false;
        if (original != copy) {
            Iterator<City> it1 = original.getCities().iterator(), it2 = copy.getCities().iterator();
            while (it1.hasNext() && it2.hasNext()) {
                City c1 = it1.next(), c2 = it2.next();
                if (c1 == c2 || !areDiverse(c1, c2))
                    return false;
            }
            if (original.getNeighbours() != null && copy.getNeighbours() != null) {
                Iterator<Province> it3 = original.getNeighbours().iterator(), it4 = copy.getNeighbours().iterator();
                while (it3.hasNext() && it4.hasNext()) {
                    Province p1 = it3.next(), p2 = it4.next();
                    if (p1 == p2 || !areDiverse(p1, p2))
                        return false;
                }
            }
            res = true;
        }
        return res;
    }

    private static boolean areDiverse(City original, City copy) {
        return original != copy;
    }
}
