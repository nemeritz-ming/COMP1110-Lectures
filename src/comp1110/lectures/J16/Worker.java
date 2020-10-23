package comp1110.lectures.J16;

public class Worker implements Runnable {
    int workitem = 0;

    static final int WORK_ITEMS = 1000;
    static final int WORKERS = 4;

    private void pretendToDoWork() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized
    private int incWorkItem() {
        return workitem++;
    }

    @Override
    public void run() {
        int mytasks = 0;

        int myworkitem;
        while ((myworkitem = incWorkItem()) < WORK_ITEMS) {
            pretendToDoWork();
            mytasks++;
        }
        System.out.println("Thread "+Thread.currentThread().getName()+ " did "+mytasks+" tasks.");
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread[] threads = new Thread[WORKERS];

        for (int i = 0; i < WORKERS; i++) {
            threads[i] = new Thread(worker,"Worker "+i);
        }

        for (int i = 0; i < WORKERS; i++)
            threads[i].start();

        try {
            for (int i = 0; i < WORKERS; i++)
                threads[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All done!");
    }
}
