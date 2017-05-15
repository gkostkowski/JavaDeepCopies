package com.pwr.ztp.cloners;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationCopier
{
    private SerializationCopier(){}

    static public Object deepCopy(Object obj) throws Exception
    {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try
        {
            ByteArrayOutputStream bos =
                    new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            ByteArrayInputStream bin =
                    new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            return ois.readObject();
        }
        catch(Exception e)
        {
            System.out.println("An error ocurred when copying an object.");
            e.printStackTrace();
        }
        finally
        {
            oos.close();
            ois.close();
        }
        return null;
    }

}
