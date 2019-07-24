package workshop.java.threads;

import java.util.concurrent.TimeUnit;
/*
      TimeUnit.SECONDS.sleep(1);

      Thread.sleep(1000);

 */
public class _V_Sleep {
    public static void main(String[] args) {
    /*


    Wątki możemy usypiać poniższe 2 przykłady pokazują,
    jak uśpić wykonywanie wątku na 1 sekundę.

*/

      /*
        TODO 1 Zaimplementuj wątek, w runnable wypisz:

        - "Akcja przed wywołaniem sleep, wątek: X"
        - wywołaj sleep na 2 sekundy
        - "Akcja po wywołaniu sleep, wątek: X"
        */

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.printf("Akcja przed wywołaniem sleep, wątek: %s%n",Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                System.out.printf("Akcja po wywołaniu sleep, wątek: %s%n",Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /*
            TODO 2 uruchom kilka razy program i zaobserwuj działanie
         */
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}




