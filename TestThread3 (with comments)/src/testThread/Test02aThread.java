package testThread;

class A {
	public void write(){
		System.out.println("I am the method write() of class A");
		System.out.println("Hello 1 (from class A)");
	}
}

class A1 extends A implements Runnable{
	public void write1(){
		System.out.print("I am class A1. I extends class A, ");
		System.out.println("and I can be executed in a separate thread.");
	}
	public void run(){
		for(int i=0;i<10000;++i){};
		write1();
		write();
	}
}

public class Test02aThread {
		
	public static void main(String[] args) {
		new Thread(new A1()).start();;
		System.out.println("Hello 2");

	}

}
