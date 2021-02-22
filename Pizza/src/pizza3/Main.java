package pizza3;

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
		
		System.out.println("p");
		System.out.println(" Size? "+p.getSize());
		System.out.println(" Extra cheese? "+p.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p.hasPepperoni());
		
		
		Pizza p1 = new PizzaFacade(TypePizza.Maison, PizzaSize.large).getPizza();
		System.out.println("p1");
		System.out.println(" Size? "+p1.getSize());
		System.out.println(" Extra cheese? "+p1.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p1.hasPepperoni());

	}

}
