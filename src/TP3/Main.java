package TP3;
public class Main {
    // Variable statique partagée entre les threads
    public static int count = 0;

    public static void main(String[] args) {
        // Créer une instance de la classe Concurrencyl (Runnable)
        Concurrencyl concurrencylInstance = new Concurrencyl();

        // Créer deux threads utilisant la même instance de Concurrencyl
        Thread thread1 = new Thread(concurrencylInstance);
        Thread thread2 = new Thread(concurrencylInstance);

        // Démarrer les threads
        thread1.start();
        thread2.start();

        try {
            // Attendre que les threads se terminent avant de continuer
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Afficher la valeur finale de count
        System.out.println("Valeur finale de count : " + count);
    }
}

// Classe implémentant l'interface Runnable
class Concurrencyl implements Runnable {
    // Méthode run qui incrémente la variable count dans une boucle
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            incrementCount();
        }
    }

    // Méthode synchronisée pour incrémenter la variable count de manière sûre
    private synchronized void incrementCount() {
        Main.count++;
    }
}
