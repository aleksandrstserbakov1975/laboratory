package ee.test;

public class Main {

    public static void main(String[] args){
        String person = "World";
        
        if (args != null && args.length > 0)
            person = args[0];
        
        System.out.println("Hello, " + person + "!");
    }
    
}
