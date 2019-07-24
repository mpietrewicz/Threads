package workshop.java.threads;

/*

    Tworzenie i startowanie wątków

    I Tworzymy instancję naszego Thread (bezparametrowy konstruktor)
    II Na instancji wywołujemy metodę start

*/

public class _III_TworzenieThread {
    public static void main(String[] args) {

        /*
            TODO 2 utwórz instancje MyThread
             wystartuj wątki
         */
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();


    }
}

/*
    TODO 1 klasa rosrzerzająca Thread
 */
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("Wątek: %s, iteracja: %d %n", Thread.currentThread().getName(), i);
        }
    }
}
