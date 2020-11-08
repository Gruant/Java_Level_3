package ru.antongrutsin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

// для ускорения можно было было реализовать через SequenceInputStream, но задача была сделать самим?
public class TaskTwo {
    private static final String FILEPATH1 = "";
    private static final String FILEPATH2 = "";
    private static final String FILEPATH3 = "";
    private static final String FILEPATH4 = "";
    private static final String FILEPATH5 = "";

    public static void main(String[] args) throws IOException {
        InputStream in = null;

        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream(FILEPATH1));
        al.add(new FileInputStream(FILEPATH2));
        al.add(new FileInputStream(FILEPATH3));
        al.add(new FileInputStream(FILEPATH4));
        al.add(new FileInputStream(FILEPATH5));
        Enumeration<InputStream> e = Collections.enumeration(al);

        try (FileOutputStream out = new FileOutputStream("tasktwo.txt", true)) {
            int x;
            while (e.hasMoreElements()) {
                in = e.nextElement();
                while ((x = in.read()) != -1)
                    out.write(x);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(in!=null) {
                in.close();
            }
        }
    }
}
