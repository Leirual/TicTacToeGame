package pl.codeme.jse1.concurrent;

public class Thr1 extends Thread {

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thr1");
    }

}
