package workshop.java.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;


/*
      java.concurrent.atomic zawiera klasy dla operacji...atomowych :)

      Dzięki nim możemy się bezpiecznie dobrać do danych, bez potrzeby
      używanie synchronized / lock.

      Atomowe operacje używają CAS:
      https://pl.wikipedia.org/wiki/Compare-and-swap

      Zazwyczaj korzystanie z CAS jest znacznie szybsze np. synchronized.
      Jeśli Twoim wielowątkowym problemem jest dostęp wielu wątków do zmiennej,
      zachęcam do używania AtiomicX...

   */
public class _XI_Atomowe {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(5);


        IntStream.range(0, 300)
                .forEach(i -> executor.submit(() -> {
                    System.out.printf("Iteracja: %d, wątek: %s %n", i, Thread.currentThread().getName());
                    atomicInt.incrementAndGet();
                }));

        try {
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println(e.getStackTrace());
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Ubijam nieskończone zadania!");
            }
            executor.shutdownNow();


        }
        System.out.printf("Wartość atomicInt po przeprocesowaniu: %d", atomicInt.get());

    }
}

/*
           AtomicInteger

           TODO zaimplementuj inkrementację licznika przez 5 wątków 0 - 300

           - nie używaj synchronized / lock
           - użyj newFixedThreadPool
           - użyj IntStream
           - do konsoli wypisz iterację i wątek, który ją wykonał,
                                                       np. Iteracja: 132, wątek: pool-1-thread-4
           - do inkrementacji użyj API AtomicInteger
        */
