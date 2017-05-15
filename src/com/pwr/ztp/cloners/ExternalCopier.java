package com.pwr.ztp.cloners;

import com.rits.cloning.Cloner;

/**
 * Created by Grzesiek on 2017-04-16.
 */
public class ExternalCopier {

    private ExternalCopier() {
    }

    static public Object deepCopy(Object oldObj) throws Exception {
        Cloner cloner=new Cloner();
        //cloner.setDumpClonedClasses(true);
        return cloner.deepClone(oldObj);
    }
}
