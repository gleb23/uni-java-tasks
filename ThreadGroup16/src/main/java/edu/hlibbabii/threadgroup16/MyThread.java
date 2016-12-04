/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hlibbabii.threadgroup16;

/**
 * Represents a thread that prints its name while running 
 * 
 * @author Gleb
 */
public class MyThread extends Thread {
    
    public int nIterations =0;
    
    /** The number of the thread that has already been created */
    static public int threadNumber = 0;

    /**
     * Creates thread with new number
     * 
     * @param parentGroup - parent thread group
     */
    protected MyThread(int nIterations, ThreadGroup parentGroup) {
        super(parentGroup, new Integer (++threadNumber).toString());
        this.nIterations = nIterations;
    }

    /**
     * 
     * @param priority priority [0..10] that thread will have, 
     * if another argument is passed, thread will have normal priority
     * @param parentGroup parent thread group
     * @return thread with passed priority and parentGroup
     */
    static public MyThread newInstance(int nIterations, int priority, ThreadGroup parentGroup) {
        MyThread t = new MyThread(nIterations, parentGroup);

        try {
            t.setPriority(priority);
        } catch (IllegalArgumentException e) {
            t.setPriority(NORM_PRIORITY);
        }

        return t;
    }

    /**
     * Thread prints its name
     */
    @Override
    public void run() {
        for (int i = 0; i < nIterations; i++) {
            try {
                sleep(30);
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException");
                System.exit(1);
            }

            //System.out.print(this.getName() + " ");
//            try {
//                wait();
    //            synchronized(this) {
    //                try {
    //                    wait();
    //                } catch (InterruptedException ex) {
    //                    System.out.println("InterruptedException");
    //                    System.exit(1);
    //            }
    //            }
//            } catch (InterruptedException ex) {
//                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
