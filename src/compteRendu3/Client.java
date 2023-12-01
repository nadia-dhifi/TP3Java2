package compteRendu3;

class Client extends Thread {
    private int numéro;
    private GarconDeCafe garcon;

    public Client(int numéro, GarconDeCafe garcon) {
        this.numéro = numéro;
        this.garcon = garcon;
    }

    public int getNuméro() {
        return numéro;
    }

    @Override
    public void run() {
        garcon.remplirTasse(this);
    }
}

