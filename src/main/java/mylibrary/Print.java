package mylibrary;

public class Print {
    public static void print(Object o){
        System.out.println(o);
    }
    public static void print(){
        System.out.println();
    }
    public static void printnl(Object o){
        System.out.print(o);
    }
    public static void printf(String format, Object... args){
        System.out.printf(format, args);
    }
}
