package pizza2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Pizza p = new Pizza(15, true , )
		Pizza p =new Pizza.Builder()
				          .size(12)
				          .olives(true)
				          .extra_cheese(true)
				          .boiled_egg(true)
				          .anchovi(true)
				          .build();
		
		System.out.println(" Size? "+p.getSize());
		System.out.println(" Extra cheese? "+p.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p.hasPepperoni());

	}

}
