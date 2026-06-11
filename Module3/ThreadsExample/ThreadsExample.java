public class ThreadsExample {
    public static void main(String[] args) {

        
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    Thread t3 = new Thread(()-> {
        for(int i = 0; i < 10; i++){
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    t3.start();
    }
}
class MyThread extends Thread {
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}