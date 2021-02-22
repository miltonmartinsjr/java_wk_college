package testThread;

public class Test03aThread {

	public static void main(String[] args) throws InterruptedException {
		
		Thread T= new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<100000;++i){}   // temps assez long
				System.out.println("Hello 1");
				
			}
		});
		T.setDaemon(true);  // T aura un arrêt bruptal à la fin de la thread principale
		T.start();
		System.out.println("Hello 2");
	}	
}
