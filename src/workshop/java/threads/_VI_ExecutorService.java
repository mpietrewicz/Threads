package workshop.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
           Sposób w jaki startowaliśmy wątki, nie jest zbyt wygdny,
           wraz z rozwojem API Javy (1.5, 1.8) pojawiły się nowe,
           przyjemniejsze dla programisty sposoby.

           ExecutorService

           Zamiast pracować bezpośrednioz wątkami, dostajemy wyższy level abstrakcji.

           Za pomocą egzekutorów (dziwnie brzmi po polsku...) możemy uruchamiać asynchroniczne
           zadania i zarządzać pulą wątków.

           Podsumowując - możemy zarządzać wielowątkowością w naszej aplikacji
           przy pomocy jednego serwisu.

 */
public class _VI_ExecutorService {
    public static void main(String[] args) {


/*
        1. Utwórz ExecutorService (użyj fabryki z Executors - newSingleThreadExecutor())
*/
        ExecutorService executor = Executors.newSingleThreadExecutor();

/*
         2. Do metody serwisu submit, przekaż runnable.
*/
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("Wątek: %s, iteracja: %d %n", Thread.currentThread().getName(), i);
            }
        });

/*     3. Uruchom program - zauważ, że po przeprocesowaniu run, cały czas działa
            TODO jak zatrzymać executor?
*/
    }
}


