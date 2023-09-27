// ArrayException.java

public class ArrayException extends Exception
{  
   private String msg;

   public ArrayException()
   {
      super("Array Exception");
   }

   public ArrayException(String msg)
   {
      super(msg);
      this.msg = msg;
   }

   public String getMsg()
   {
      return msg;
   }

}
