class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("Hello from Thread 1"));
        t1.setName("Thread 1");
        t1.start();
        t1.join();

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.setName("Thread 2");
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("Thread 3"));
        t3.setName("Thread 3");

        Thread[] threads = new Thread[3];
        threads[0] = t1;
        threads[1] = t2;
        threads[2] = t3;

        printNameOfTerminatedThread(threads);
    }

    public static void printNameOfTerminatedThread(Thread[] threads) {

        for(Thread thread : threads){
            if(thread.getState() == Thread.State.TERMINATED){
                System.out.println("TERMINATED THREAD: "+thread.getName());
            }
        }

    }
}