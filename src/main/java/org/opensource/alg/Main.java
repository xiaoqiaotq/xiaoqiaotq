package org.opensource.alg;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.err.println(main.isSquare(4));
        System.err.println(main.isSquare(3));

    }

    public boolean isSquare(int num){
        double a=0;
        a = Math.sqrt(num);
        int b =(int)a;
        return a - b == 0;
    }
}
