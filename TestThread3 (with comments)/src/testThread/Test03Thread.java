package testThread;

public class Test03Thread {

	public static void main(String[] args) throws InterruptedException {
		
		Thread T= new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<100000;++i){}  // a longer time
				System.out.println("Hello 1");
				
			}
		});
		T.start();
		T.join();      // wait here for the thread T to finish.
		System.out.println("Hello 2");
	}
}