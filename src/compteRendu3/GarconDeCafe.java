package compteRendu3;
class GarconDeCafe {
    public synchronized void remplirTasse(Client client) {
        System.out.println("Le garçon de café remplit la tasse du client " + client.getNuméro());
        try {
            Thread.sleep(2000);  // Simule le remplissage de la tasse en attendant pendant 2 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Le garçon de café a servi le client " + client.getNuméro());
    }
}

