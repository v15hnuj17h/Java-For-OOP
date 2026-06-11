// Simulating a Student System with background auto-save

class AutoSaveTask implements Runnable {

    private String dataToSave;
    private int    intervalMs;
    private boolean running;

    AutoSaveTask(String data, int intervalMs) {
        this.dataToSave = data;
        this.intervalMs = intervalMs;
        this.running    = true;
    }

    void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("🔄 AutoSave started...");
        while (running) {
            try {
                Thread.sleep(intervalMs);
                if (running) {
                    System.out.println("💾 AutoSave: data saved at "
                        + java.time.LocalTime.now()
                                            .toString()
                                            .substring(0, 8));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("🔴 AutoSave stopped.");
    }
}

class StudentWorkTask implements Runnable {

    private String studentName;

    StudentWorkTask(String name) {
        this.studentName = name;
    }

    @Override
    public void run() {
        String[] tasks = {
            "Loading student records",
            "Calculating averages",
            "Generating report",
            "Preparing display"
        };

        for (String task : tasks) {
            System.out.println("📋 " + studentName
                                + " system: " + task + "...");
            try {
                Thread.sleep(800); // simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("✅ " + studentName
                            + " system: All tasks complete!");
    }
}

// Shared counter — thread-safe
class SharedCounter {
    private int count = 0;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

public class MultithreadingDemo {
    public static void main(String[] args)
           throws InterruptedException {

        System.out.println("🚀 System Starting...\n");

        // ── Demo 1: Background AutoSave ──────────
        AutoSaveTask    saveTask   = new AutoSaveTask("StudentData", 2000);
        StudentWorkTask workTask   = new StudentWorkTask("Grade");

        Thread saveThread = new Thread(saveTask);
        Thread workThread = new Thread(workTask);

        saveThread.setName("AutoSave-Thread");
        workThread.setName("Work-Thread");

        saveThread.start(); // background saving
        workThread.start(); // main work

        workThread.join();  // wait for work to finish
        saveTask.stop();    // stop auto-save
        saveThread.join();  // wait for save to stop

        // ── Demo 2: Synchronized Counter ─────────
        System.out.println("\n── Synchronized Counter Demo ──");
        SharedCounter counter = new SharedCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected count : 2000");
        System.out.println("Actual count   : "
                            + counter.getCount());
        System.out.println(counter.getCount() == 2000
                            ? "✅ Synchronized correctly!"
                            : "❌ Race condition!");

        System.out.println("\n🏁 System Shutdown Complete.");
    }
}