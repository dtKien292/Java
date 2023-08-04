package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ducmanh
 */

public class IOFile {
    public static <T> List<T> doc(String fname){
        List<T> list = new ArrayList<>();
        
        try{
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(fname));
            list = (List<T>) o.readObject();
        }
        catch(FileNotFoundException e){
                System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return list;
    }
    public static <T> void ghi(String fname, List<T> arr){
        try{
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fname));
            o.writeObject(arr);
            o.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}