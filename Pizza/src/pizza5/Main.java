package pizza5;



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
		
		
		Pizza p1 = PizzaMenu.getMenuPizza(TypePizza.Maison, PizzaSize.large).getPizza();
		System.out.println("p1");
		System.out.println(" Size? "+p1.getSize());
		System.out.println(" Extra cheese? "+p1.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p1.hasPepperoni());
		
		Pizza p3 = PizzaMenu.getMenuPizza(TypePizza.Pepperoni, PizzaSize.large).getPizza();
		System.out.println("p3");
		System.out.println(" Size? "+p3.getSize());
		System.out.println(" Extra cheese? "+p3.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p3.hasPepperoni());
		
		PizzaMenu.TypedPizza[]p2=PizzaMenu.getPizzaPromo(PizzaPromotion.PromoPepperoni);
		System.out.println("p2[0]");
		System.out.println(" Size? "+p2[0].getPizza().getSize());
		System.out.println(" Type = "+p2[0].getType());
		System.out.println(" Extra cheese? "+p2[0].getPizza().hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p2[0].getPizza().hasPepperoni());
		System.out.println("p2[1]");
		System.out.println(" Size? "+p2[1].getPizza().getSize());
		System.out.println(" Type = "+p2[1].getType());
		System.out.println(" Extra cheese? "+p2[1].getPizza().hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p2[1].getPizza().hasPepperoni());
		

	}

}
