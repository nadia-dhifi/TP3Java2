package TP3;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadExample extends Thread {
   
    private volatile boolean shouldFinish = true;
    protected static  AtomicInteger Count = new AtomicInteger(0) ;  
   
    public void run() {
        while (shouldFinish) {
            
            System.out.println("Travail en cours...");

            try {
              
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public void finish() {
        shouldFinish = false;
        System.out.println("fin");
    }
    public static void main(String[] args) {
    	ThreadExample threadExample = new ThreadExample();

        threadExample.start();
        try {
            
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadExample.finish();

        try {
           
            threadExample.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Le thread a terminé.");
    }
    }