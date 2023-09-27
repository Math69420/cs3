import java.lang.reflect.Method;
import java.util.*;

public class StackTester
{
   public static void main(String[] args)
   {
      Stack stack = new Stack();
      
      
      
      Class stackClass = stack.getClass();
      Method[] methods = aClass.getDeclaredMethods();
      for (Method method : methods) {
         System.out.println(method.getName());
      }
   }
}