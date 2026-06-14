package studentapp.utils;

import studentapp.manager.StudentManager;

public class AutoSaveTask implements Runnable {

    private StudentManager manager;
    private int intervalMs;
    private volatile boolean running;

    public AutoSaveTask(StudentManager manager, int intervalMs) {
        this.manager = manager;
        this.intervalMs = intervalMs;
        this.running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {

                // Thread.sleep(intervalMs);    
                
                long start = System.currentTimeMillis();
                while (running && (System.currentTimeMillis()-start < intervalMs)){
                    Thread.sleep(500);
                }

                if (running) {
                    System.out.println("\n [AutoSave] " + StudentManager.getTotalStudents() + " student record(s) backed up.\n");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                break;
            }
        }
    }
}