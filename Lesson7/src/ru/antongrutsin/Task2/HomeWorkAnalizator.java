package ru.antongrutsin.Task2;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeWorkAnalizator {
    private static String className;
    private static String pathString;
    private static String PATH = "/Users/antongrutsin/Desktop/Java_Level_1-lesson-2";

    public static void main(String[] args) throws Exception {
        findClasses();
        loadClass();
    }

    public static void findClasses() {
        List<Path> classPaths = null;
        try (Stream<Path> paths = Files.walk(Paths.get(PATH))) {
            classPaths = paths.filter(Files::isRegularFile).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Objects.requireNonNull(classPaths).size(); i++) {
             isClass(classPaths.get(i).toString());
        }
    }


    public static void isClass(String path) {
        if (path.endsWith("class")) {
            className = path.substring(path.lastIndexOf("/")+1, path.lastIndexOf('.'));
            System.out.println(className);

        }
    }

    public static void loadClass() throws Exception {
        Class testClass = URLClassLoader.newInstance(new URL[]{new File(PATH).toURL()}).loadClass(className);
        Constructor constructor = testClass.getConstructor();
        Object newClass = constructor.newInstance();




    }

    public static void classWorker(Class classDZ){

    }

}
