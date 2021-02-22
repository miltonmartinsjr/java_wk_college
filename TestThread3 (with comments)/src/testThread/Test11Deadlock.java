package testThread;

import java.util.concurrent.locks.ReentrantLock;

public class Test11Deadlock {
	public static void main(String[] args) throws InterruptedException {
		
		ReentrantLock w1 = new ReentrantLock(true); // true = the lock requests will be served FIFO.
		ReentrantLock w2 = new ReentrantLock(true); // true = the lock requests will be served FIFO.
		
		Thread T1= new Thread(new Runnable(){
			public void run() {
				w1.lock();	           // .lock() ne jette pas d'exception. Pas besoin de try / catch	
				System.out.println("Thread T1 - w1 locked");
				for(int i=0;i<10000;++i){}		
				w2.lock();
				System.out.println("Thread T1 - w1 and w2 locked");
				w1.unlock();
				w2.unlock();
				System.out.println("Thread T1 - fin");
			}
		});
		Thread T2= new Thread(new Runnable(){
			public void run(){
				w2.lock();	           // .lock() ne jette pas d'exception. Pas besoin de try / catch	
				System.out.println("Thread T2 - w2 locked");
				for(int i=0;i<10000;++i){}			
				w1.lock();
				System.out.println("Thread T2 - w2 and w1 locked");
				w1.unlock();
				w2.unlock();
				System.out.println("Thread T2 - fin");
			}
		});
		T1.start();
	    T2.start();
	    T1.join();
	    T2.join();

	}
}


