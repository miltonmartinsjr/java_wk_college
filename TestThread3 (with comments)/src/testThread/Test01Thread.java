package testThread;

public class Test01Thread {

	public static void main(String[] args) {
		// An anonymous object of an anonymous class extending Thread is defined 
		// overriding the run() method and then this object is started (.start()).
		new Thread(){
			@Override
			public void run(){
				for(int i=0;i<10000;++i){}
				System.out.println("Hello 1");			
			}
		}.start();
		System.out.println("Hello 2");
		// the main thread (that prints "Hello 2" and the thread the prints "Hello 1" are 
		// NOT synchronized 
	}
}
