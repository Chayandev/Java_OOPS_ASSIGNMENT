package Threading.TwoThreads;

import java.util.ArrayList;

class FactorialThread extends Thread {
    int number;
    long result;
    FactorialThread(int number){
        this.number=number;
    }
    @Override
    public void run(){
        if(number<0)
          throw new IllegalArgumentException("Factorial of negative numbers is not defined");
        result=calculateFactorial(number);
      //  System.out.println("In factoril");
    }

    private long calculateFactorial(int number){
         if(number==0 ||number==1){
            return 1;
         }
         return number*calculateFactorial(number-1);
    }

    public long getFactorial(){
        return result;
    }
}

class FactorThread extends Thread {
    int number;
   ArrayList<Integer>result;
    FactorThread(int number){
        this.number=number;
        result=new ArrayList<>();
    }
    
    @Override
    public void run() {
        if(number<0)
        throw new IllegalArgumentException("No factors for Negative Input.");
       result=findFactors(number);
      // System.out.println("In factor");
    }
    private ArrayList<Integer> findFactors(int number){
        ArrayList<Integer>factors=new ArrayList<>();
          for(int i=1;i<=number;i++){
            if(number%i==0)
               factors.add(i);
         }
         return factors;
    }
    public ArrayList<Integer> getFactors(){
        return result;
    }
}

public class MainThread {
    public static void main(String[] args) {
        int inputNumber=-1;
        FactorialThread factorialThread = new FactorialThread(inputNumber);
        FactorThread factorThread = new FactorThread(inputNumber);

        // to run this two thread we have to call .start() method whcih internallly
        // calls the .run() mehtod to run the thread
        factorialThread.start();
        factorThread.start();
        try {
            factorialThread.join();
            factorThread.join();
        } catch (Exception e) {
            System.out.println(e.toString());
            // TODO: handle exception
        }
        System.out.println("Factoial : "+factorialThread.getFactorial());
        System.out.println("Factors : "+factorThread.getFactors());
        System.out.println("Finish Mian Thread");;
    }
}