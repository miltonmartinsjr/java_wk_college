package testThread;

public class Test07aThread {    // synchronized - l'ordre n'est pas garanti. 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		final int[] s= new int[1];
		s[0]=5;
		Thread T1= new Thread(new Runnable(){
			public void run(){
					synchronized(s)
				    {                     // object s must be locked to this thread in order to 
						                  // execute this piece of code, between { and }.
						                  // however, locks may not be granted in the same order 
                                          // as requested.			
						int j = s[0];
						for(int i=0;i<10000;++i){}
						s[0]=j+10;	
					}
				}			
		});
		Thread T2= new Thread(new Runnable(){
			public void run(){	
					synchronized(s)
					{ 
						s[0]=s[0]+20;
					}
				}
		});
		T1.start();
	    T2.start();
	    T1.join();
	    T2.join();
		System.out.println(s[0]);
	}

}

