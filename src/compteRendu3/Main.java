package compteRendu3;

public class Main {
    public static void main(String[] args) {
        GarconDeCafe garcon = new GarconDeCafe();
        int nombreDeClients = 50;

        // Création et démarrage des clients
        Client[] clients = new Client[nombreDeClients];
        for (int i = 0; i < nombreDeClients; i++) {
            clients[i] = new Client(i + 1, garcon);
            clients[i].start();
        }

        // Attente que tous les clients aient été servis
        for (Client client : clients) {
            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Message indiquant que tous les clients ont été servis et que le café est fermé
        System.out.println("Tous les clients ont été servis. Le café est fermé.");
    }
}
