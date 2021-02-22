package testThread;

import java.util.concurrent.locks.ReentrantLock;

public class Test09Thread {
	
	/* 
	 * C'est l'exemple 05 fait avec un verrou (au lieu d'un semaphore). 
	 * */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final String[] s= new String[1];
		s[0]="main";
		ReentrantLock w = new ReentrantLock(true); // true = the lock requests will be served FIFO.
		Thread T1= new Thread(new Runnable(){
			public void run() {
				while (s[0].length()<24){						
					w.lock();				// .lock() ne jette pas d'exception. Pas besoin de try / catch	
					for(int i=0;i<10000;++i){}
					s[0]=s[0]+"1";	
					w.unlock();
				}
			}
		});
		Thread T2= new Thread(new Runnable(){
			public void run(){
				while (s[0].length()<24){	
					w.lock();
					s[0]=s[0]+"2";
					w.unlock();
				}
			}
		});
		T1.start();
	    T2.start();
	    T1.join();
	    T2.join();
		System.out.println(s[0]);
		System.out.println(s[0].length());
	}
}
