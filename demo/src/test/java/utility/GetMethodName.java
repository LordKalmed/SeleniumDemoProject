package utility;

public class GetMethodName {


    public String getMethodName(){
      return name = new Object(){}.getClass().getEnclosingMethod().getName();
    }

    String name = new Object(){}.getClass().getEnclosingMethod().getName();
    
}
