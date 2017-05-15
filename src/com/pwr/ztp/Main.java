package com.pwr.ztp;

import com.pwr.ztp.cloners.CloneCopier;
import com.pwr.ztp.cloners.ExternalCopier;
import com.pwr.ztp.cloners.SerializationCopier;
import com.pwr.ztp.core.Country;
import com.pwr.ztp.gen.CountryGenerator;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
/*
        CountryGenerator cg = new CountryGenerator(3);
        System.out.println(Arrays.deepToString(cg.callGenerator(2, 3, 5).toArray()));
*/

        CountryGenerator cg2 = new CountryGenerator(3);
        long tstart = System.currentTimeMillis();
        List<Country> res = cg2.callGenerator(1, 20, 5);
        System.out.println("Czas generowania (1x20x5): " + (System.currentTimeMillis() - tstart));

        //SerializationCopier
        List<Country> copy = runSerializationCloner(res);
        System.out.println("[runSerializationCloner] runChecks(res, copy) -> " + runChecks(res, copy));

        copy = runCloner(res);
        System.out.println("[runCloner] runChecks(res, copy) -> " + runChecks(res, copy));

        //ExternalCopier
        copy = runExternalCopier(res);
        System.out.println("[runExternalCopier] runChecks(res, copy) -> " + runChecks(res, copy));

        //test metody sprawdzającej roznorodnosc obiektow
        System.out.println("[test] runChecks(res, res) -> "+runChecks(res, res));
        copy.get(0).getProvinces().set(6, res.get(0).getProvinces().get(6));
        System.out.println("runChecks(res, copy) po zmianie: -> "+runChecks(res, copy));

    }

    private static List<Country> runCloner(List<Country> res) throws Exception {
        long tstart = System.currentTimeMillis();
        List<Country> copy = (List<Country>) CloneCopier.deepCopy(res);
        System.out.println("[runCloner] Czas kopiowania (1x20x5): " + (System.currentTimeMillis() - tstart));
        System.out.println("---> test");
        System.out.println(res.get(0).getPresident() == copy.get(0).getPresident());

        return copy;
    }

    private static List<Country> runSerializationCloner(List<Country> res) throws Exception {
        long tstart = System.currentTimeMillis();
        List<Country> copy = (List<Country>) SerializationCopier.deepCopy(res);
        System.out.println("[runSerializationCloner] Czas kopiowania (1x20x5): " + (System.currentTimeMillis() - tstart));
        return copy;
    }

    private static boolean runChecks(List<Country> original, List<Country> copy) {
        boolean res = true;
        for (int i = 0; i < original.size(); i++) {
            res = res && Validator.areDiverse(original.get(i), copy.get(i));
        }
        return res;
    }

    private static List<Country> runExternalCopier(List<Country> source) throws Exception {
        long tstart = System.currentTimeMillis();
        List<Country> copy = (List<Country>) ExternalCopier.deepCopy(source);
        System.out.println("[runExternalCopier] Czas kopiowania (1x20x5): " + (System.currentTimeMillis() - tstart));
        return copy;
    }
}
