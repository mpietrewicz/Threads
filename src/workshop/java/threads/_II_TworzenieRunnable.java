package workshop.java.threads;

public class _II_TworzenieRunnable {
    public static void main(String[] args) {
/*

Tworzenie i startowanie wątków

I Definiujemy implementora Runnable

II Tworzymy instancję Thread, przekazując jej do konstruktora nasz runnable

III Na instancji wywołujemy metodę start - w ten sposób nasz wątek
uruchomi metodę run w sposób asynchroniczny.

TODO 1 zaimmplementuj Runnable (pętla 1-100 drukująca do konsoli licznik)
*/
        System.out.println("Start!");
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("iteracja: %d", i);
            }
        };


/*
TODO 2 utwórz i WYSTARTUJ 3 wątki (przekaż swój runnable do konstruktora)
Uruchom program i zaobserwuj działanie.
*/
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();
/*
TODO 3 Zmodyfikuj komunikat w pętli - poszukaj w API,
jak wypisać nazwę bieżącego wątku i wypisz do konsoli, np:
bieżący wątek: X, iteracja 10
Uruchom i zaobserwuj działanie programu

TODO 4 Zastanów się, jak zachowa się program, jesli zamiast start wywołasz run?
Uruchom program i przetestuj.

*/

    }
}
