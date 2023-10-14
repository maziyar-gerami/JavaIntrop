package jsrc;

public class Sample {

    public String pubField = "Hello from public field";

    private String privateField = "Hello from private field";

    public static String pubStaticField = "Hello from public field";

    public static void functionWithoutParam (){
        System.out.println("Public Function Whithout Parameter");
    } 

    public void functionWithPram (String par){
        System.out.println(par + ", Public Function Whith Parameter");
    } 
}