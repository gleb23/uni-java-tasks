/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hlibbabii.threadgroup16;

/**
 * Thread scanner which shows all threads running
 *
 * @version 1.0
 * @author Gleb
 */
public class ThreadGroup16 implements Runnable {

    /**
     * Thread group to scan
     */
    ThreadGroup threadGroup = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long lower = 678;
        long max = 0xFFFFFFFF;
        long tmp = lower;
        while (tmp != 0) {
            max /= 2;
            tmp /= 2;
        }
        long notlower = ~lower + max;
        System.out.println(notlower);
        System.out.println(lower&notlower);
        System.out.println(lower|notlower);
        (new DemoThreadGroups()).startDemo();
    }

    /**
     * Method that launches scanning
     *
     * @param threadGroup threadGroup to scan
     */
    public void showThreadsInfo(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;

        /*
         * Scanning is made in a new thread
         */
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    /**
     * Called by ShowThreadsInfo
     *
     * @param threadGroup - thread group to scan
     */
    private void showInfo(ThreadGroup threadGroup) {
        /*
         * Find thread-sons
         */
        Thread[] list = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(list, false);
        for (Thread th : list) {
            if (th != null) {
                System.out.println("It's thread   " + th.getName() + " State: " + th.getState()
                        + " Priority: " + th.getPriority() + " nIterations: " + ((MyThread) th).nIterations);
            }
        }

        /*
         * Find threadGroup-sons
         */
        ThreadGroup[] threadList = new ThreadGroup[threadGroup.activeGroupCount()];
        threadGroup.enumerate(threadList, false);
        for (ThreadGroup thGroup : threadList) {
            if (thGroup != null) {
                System.out.println("It's threadGroup  " + thGroup.getName());
                this.showInfo(thGroup);
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
        }
        showInfo(threadGroup);
        synchronized (this) {
            this.notifyAll();
        }
    }
}
