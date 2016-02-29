package pl.codeme.jse1.concurrent;

public class App {

    public static void main(String[] args) {
        new Thr1().start();
        new Thr2().start();
        System.out.println("Base Thread");
    }

}
