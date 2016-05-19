package ee.test;

/**
 * This is some doc
 * @author aleksandr.stserbakov
 *
 */
public class Main {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args){
        String person = "World";
        
        if (args != null && args.length > 0)
            person = args[0];
        
        System.out.println("Hello, " + person + "!");
    }
    
}
