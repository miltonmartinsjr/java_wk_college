package testThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Test12Deadlock {
	
public static void main(String[] args) throws InterruptedException {
		
	    Semaphore w1 = new Semaphore(1, true); // 1 = only one thread at a time 
                                               // true = the acquire requests will be served FIFO.
	    Semaphore w2 = new Semaphore(1, true); // 1 = only one thread at a time 
                                               // true = the acquire requests will be served FIFO.
	    
		Thread T1= new Thread(new Runnable(){
			public void run() {
				try {
					w1.acquire();
					System.out.println("Thread T1 - w1 acquired");
					for (int i = 0; i < 10000; ++i) {
					}
					w2.acquire();
					System.out.println("Thread T1 - w1 and w2 acquired");
					w1.release();
					w2.release();
					System.out.println("Thread T1 - fin");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread T2= new Thread(new Runnable(){
			public void run(){
				try {
					w2.acquire();
					System.out.println("Thread T2 - w2 acquired");
					for (int i = 0; i < 10000; ++i) {
					}
					w1.acquire();
					System.out.println("Thread T2 - w2 and w1 acquired");
					w1.release();
					w2.release();
					System.out.println("Thread T2 - fin");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		T1.start();
	    T2.start();
	    T1.join();
	    T2.join();

	}

}
