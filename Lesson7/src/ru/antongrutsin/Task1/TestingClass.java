package ru.antongrutsin.Task1;

public class TestingClass{

    @BeforeSuite
    public String beforeSuit(){
        System.out.println("BeforeSuite method");
        return "BeforeSuit method";
    }

//    @BeforeSuite
//    public String beforeSuit2(){
//        System.out.println("BeforeSuite2 method");
//        return "BeforeSuit2 method";
//    }
//
//    @AfterSuite
//    public String afterSuite(){
//        System.out.println("AfterSuite method");
//        return "AfterSuit method";
//    }

    @Test(priority = 0)
    public String test1(){
        System.out.println("TestMethod with ZERO priority");
        return "TestMethod";
    }

    @Test(priority = 9)
    public String test2(){
        System.out.println("TestMethod with NINE priority");
        return "TestMethod";
    }

    @Test(priority = 5)
    public String test3(){
        System.out.println("TestMethod with FIVE priority");
        return "TestMethod";
    }

}
