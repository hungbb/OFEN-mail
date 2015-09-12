/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ThanhHung
 */
public class ioObject {
    
    private ioObject()
    {}
    
    public static Object readObject(String file) throws FileNotFoundException, IOException, ClassNotFoundException 
    {
        File f = new File("src/dat/"+file);
        Object obj = null;
        FileInputStream fi = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fi);
        obj = ois.readObject();
        ois.close();
        fi.close();
        return obj;
    }
    
    public static void writeObject(String file, Object obj) throws FileNotFoundException, IOException{
        File f = new File("src/dat/"+file);
        File dir = new File("src/dat");
        if (!dir.exists())
            dir.mkdirs();
        FileOutputStream fo = new FileOutputStream(f);
        ObjectOutputStream oos  = new ObjectOutputStream(fo);
        oos.writeObject(obj);
        oos.flush();
        fo.close();
    }
}
