import java.util.function.Supplier;

class Lazy<T>{
    private final Supplier<T> supplier;
    private T instance;
    Lazy(Supplier<T> supplier){
        this.supplier=supplier;
    }
    public T get(){
        if(instance == null){
            instance=  supplier.get();
        }
        return  instance;
    }
}

public class Main {
    public  static int compute(int number){
        System.out.println("compute called....");
        return number * 100;
    }
    public static void main(String[] args) {

        int value=4;
        Lazy<Integer> temp=new Lazy<>(()->compute(value));
        if(value >4 && temp.get()>100){
            System.out.println("correct path");
        }else {
            System.out.println("path is not correct ");
        }
    }
}