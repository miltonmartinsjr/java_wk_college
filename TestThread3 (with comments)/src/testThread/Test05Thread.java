package testThread;

import java.util.concurrent.Semaphore;

public class Test05Thread {   // using Semaphores

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final String[] s= new String[1];
		s[0]="main";
		Semaphore w = new Semaphore(1, true); // 1 = only one thread at a time 
		                                      // true = the acquire requests will be served FIFO.
		Thread T1= new Thread(new Runnable(){
			public void run() {
				while (s[0].length()<24){	
					try {
						w.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int i=0;i<10000;++i){}
					s[0]=s[0]+"1";	
					w.release();
				}
			}
		});
		Thread T2= new Thread(new Runnable(){
			public void run(){
				while (s[0].length()<24){	
					try {
						w.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					s[0]=s[0]+"2";
					w.release();
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
