package com.revature.test;

class testeri {
    //below variable is static variable means it is class level variable
    static int i;
    public static void main(String[] args) {
      // As i is an static variable it can be accessed directly without using any object
      System.out.println("Value before calling method1: " + i);
      testeri t1 = new testeri();
      t1.method1();
      System.out.println("Value after calling method1: " + i);
      t1.method2();
      System.out.println("Value after calling method2: " + i);
    }
    void method1() {
      i++;
    }
    void method2() {
      i++;
    }
  }
