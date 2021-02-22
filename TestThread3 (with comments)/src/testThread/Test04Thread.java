package testThread;

public class Test04Thread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final String[] s= new String[1];
		s[0]="main";
		Thread T1= new Thread(new Runnable(){
			public void run(){
				while (s[0].length()<24){				
					for(int i=0;i<10000;++i){}
					s[0]=s[0]+"1";	
				}
			}
		});
		Thread T2= new Thread(new Runnable(){
			public void run(){
				while (s[0].length()<24){	
					s[0]=s[0]+"2";
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
