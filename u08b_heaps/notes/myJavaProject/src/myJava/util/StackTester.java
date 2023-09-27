package myJava.util;

import java.lang.reflect.Method;

public class StackTester
{
   public static void main(String[] args)
   {
      Stack<Integer> stack = new Stack<Integer>();
      Class stackClass = stack.getClass();
      Method[] methods = stackClass.getDeclaredMethods();
      for (Method method : methods) {
         System.out.println(method.getName());
      }
   }
}
