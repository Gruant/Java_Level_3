package ru.antongrutsin.Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.function.ToIntFunction;
import java.util.logging.Filter;
import java.util.logging.Handler;

public class Testing {


    public static void start(Class testClass){
        ArrayList<Method> testMethods = new ArrayList<>();
        int count = 0;
        Object classInstance;
        Method[] methods = testClass.getDeclaredMethods();
        if(!notInOneEx(testClass)) {
            throw new RuntimeException("Отсутсвуют Before или After Suite в единственном экземпляре");
        }

        for (Method method : methods) {
            if(method.getAnnotation(Test.class) != null){
                testMethods.add(method);
                method.setAccessible(true);
            }
        }

        testMethods.sort(Comparator.comparingInt(new ToIntFunction<Method>() {
            @Override
            public int applyAsInt(Method value) {
                return value.getAnnotation(Test.class).priority();
            }
        }));

        for (Method method : methods) {
            if(method.getAnnotation(BeforeSuite.class) != null){
                testMethods.add(0, method);
            }
            if(method.getAnnotation(AfterSuite.class) != null){
                testMethods.add(method);
            }
        }

        try {
            classInstance = testClass.newInstance();
            for (Method method : testMethods) {
                try {
                    method.invoke(classInstance);
                    count++;
                } finally {
                    System.out.println("Результат");
                }
            }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Выполнено тестов: " + count);
        }
    }

    public static void start(Object obj) {
        ArrayList<Method> testMethods = new ArrayList<>();
        int count = 0;
        Object classInstance;

        Class testClass = obj.getClass();

        Method[] methods = testClass.getDeclaredMethods();
        if(!notInOneEx(testClass)) {
            throw new RuntimeException("Отсутствуют Before или After Suite в единственном экземпляре");
        }

        for (Method method : methods) {
            if(method.getAnnotation(Test.class) != null){
                testMethods.add(method);
                method.setAccessible(true);
            }
        }

        testMethods.sort(Comparator.comparingInt(new ToIntFunction<Method>() {
            @Override
            public int applyAsInt(Method value) {
                return value.getAnnotation(Test.class).priority();
            }
        }));

        for (Method method : methods) {
            if(method.getAnnotation(BeforeSuite.class) != null){
                testMethods.add(0, method);
            }
            if(method.getAnnotation(AfterSuite.class) != null){
                testMethods.add(method);
            }
        }

        try {
            classInstance = testClass.newInstance();
            for (Method method : testMethods) {
                try {
                    method.invoke(classInstance);
                    count++;
                } finally {
                    System.out.println("Результат");
                }
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Выполнено тестов: " + count);
        }
    }

    public static boolean notInOneEx(Class testClass) {
        int beforeCount = 0;
        int afterCount = 0;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method o : methods) {
            if (o.getAnnotation(BeforeSuite.class) != null) {
                beforeCount++;
//                beforeSuite = o;
            }
            if (o.getAnnotation(AfterSuite.class) != null){
                afterCount++;
//                afterSuite = o;
            }
        }
        return (beforeCount < 2 && afterCount < 2);
    }



}
