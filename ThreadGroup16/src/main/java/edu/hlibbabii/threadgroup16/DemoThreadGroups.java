/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hlibbabii.threadgroup16;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for demostration. Creates random threads, thread groups  
 * with random priorities and duration
 * 
 * @author Gleb
 */
public class DemoThreadGroups {

    /**
     * Creates threads and thread groups, then creates 
     * ThreadGroup16 threadScanner which shows all running threads
     * 
     * @see ThreadGroup16
     */
    public void startDemo() {
        final int NUM = 20; // number of threads + thread groups
        ThreadGroup root = new ThreadGroup(new Integer(0).toString()); // root thread group
        ThreadGroup currentParentThreadGroup = root;
        int groupNumber = 0;
        for (int i = 0; i < NUM; i++) {
            Random random = new Random();
            int tPriority = random.nextInt(10) + 3;
            /* 
             * If tPriority > 10 - create group
             * else create thread
             */
            if (tPriority > 10) {
                currentParentThreadGroup =
                        new ThreadGroup(currentParentThreadGroup,
                        new Integer(groupNumber++).toString());
            } else {
                int iter; // number of iterations in thread
                iter = random.nextInt(950) + 50;
                (MyThread.newInstance(iter, tPriority, currentParentThreadGroup)).start();
            }
        }

        ThreadGroup16 threadScanner = new ThreadGroup16();
//        for (int i = 0; i < 10; i++) {
//            try {
//                root.wait();
//            } catch (InterruptedException ex) {
//                System.out.println("InterruptedException");
//                System.exit(1);
//            }
            for (int i = 0; i < 10; i++) {
                threadScanner.showThreadsInfo(root);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DemoThreadGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        //}
    }
}
