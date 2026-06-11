class Runner implements Runnable {
    String name;
    Runner(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(name + " is running " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class RunnerRace {
    public static void main(String[] args) {

        Runner runner1 = new Runner("Runner 1");
        Runner runner2 = new Runner("Runner 2");

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}