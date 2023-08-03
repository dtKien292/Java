package controller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    // doc tu file va luu vao list
    public static <T> List<T> read(String fname){
        List<T> list = new ArrayList<>();
        try{
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(fname));
            list = (List<T>)o.readObject();
            o.close();
        }catch (IOException e){
            System.err.println(e);
        }catch (ClassNotFoundException e){
            System.err.println(e);
        }
        return list;
    }

    // tu list luu vao file
    public static <T> void write(String fname, List<T> arr){
        try{
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fname));
            o.writeObject(arr);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
