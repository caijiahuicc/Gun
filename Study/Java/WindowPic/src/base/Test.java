package base;


import java.util.Arrays;

/**
 * @author cc
 * @create 2023/12/02
 * @description  银行转账问题
 */
public class Test {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
    public static void main(String[] args) {
        Blank blank = new Blank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->{
                try {
                    while (true){
                        int toAccount = (int) (blank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        blank.transfer(fromAccount,toAccount,amount);
//                        Thread.sleep((int)(DELAY * Math.random()));
                        Thread.sleep(0);
                    }
                }
                catch (InterruptedException e){

                }
            };
            r.run();
            Thread thread = new Thread();
            thread.start();
        }
    }
}

class Blank{
    private double[] accounts;
    public Blank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void transfer(int from, int to, double amount){
        if(accounts[from] < amount){
            return;
        }
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to] += amount;
        System.out.printf("Total Balance: %10.2f%n",getTotalBalance());
    }

    public double getTotalBalance(){
        double sum = 0;
        for(double a:accounts){
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
