package workshop.java.threads;

import java.util.concurrent.*;

/*
     Runnable nie zwraca wartości, co jeśli chcielibyśmy
     po wykonaniu zadania otrzymać jakąś wartość?

     użyjemy Callable - bardzo podobny do Runnable, tyle że zwraca wynik.

     sumbit() executora nie czeka na wynik, ale zwraca obiekt typu Future,
     z którego możemy wyciągnąć nasz wynik.

 */
public class _VIII_Callable {
    public static void main(String[] args) {




     /*           TODO 1 zaimplementuj callable:
                  - drukuje do konsoli nazwę wątki
                  - usypia watek na sekundę
                  - zwraca randomowego Double*
     */
        Callable<Double> task = ()-> {
            System.out.printf("W callable - Thread: %s%n", Thread.currentThread().getName());
            Thread.sleep(1000);
            return Math.random();
        };
/*
                   TODO 2 Utwórz ExecutorService,
                   użyj fabryki newFixedThreadPool(1)
 */
        ExecutorService executor = Executors.newFixedThreadPool(1);

/*
                   TODO 3 Wywołaj twa razy metodę submit(), przypisz ją do dwóch referencji typu Future
*/
        Future<Double> future = executor.submit(task);
        Future<Double> future2 = executor.submit(task);


/*
                   TODO 4 Pobierz z future rezultat i wydrukuj do konsoli
*/
        Double result1 = null;
        Double result2 = null;
        try {
            result1 = future.get();
            result2 = future2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.printf("result1: %f, result2: %f", result1, result2);
/*
                   TODO 5 Uruchom program, zaobserwuj wynik

                   TODO 6 Zmień w kodzie newFixedThreadPool na newFixedThreadPool(2)
                   Uruchom i zaobserwuj różnicę.
*/
    }
}
