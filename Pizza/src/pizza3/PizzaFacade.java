package pizza3;

public class PizzaFacade {
	
	private Pizza p; 
	
	public PizzaFacade(TypePizza tp, PizzaSize s) {
		int size = 10;
		
		switch (s) {
		case petite: size= 8; break;
		case moyenne: size= 10; break;
		case grande: size= 12; break;
		case large: size= 15; break;
		}
		
		if(tp == TypePizza.Pepperoni) {
			p=new Pizza.Builder()
					  .size(size)
			          .pepperoni(true) 
			          .build();
		}
		else if (tp==TypePizza.Fromage) {
			p=new Pizza.Builder()
					  .size(size)
			          .extra_cheese(true) 
			          .build();
		}
		else if (tp==TypePizza.Maison) {
			p =new Pizza.Builder()	
					  .size(size)
			          .olives(true)
			          .extra_cheese(true)
			          .boiled_egg(true)
			          .anchovi(true)
			          .build();
		}
}
	
	public Pizza getPizza() {
		return p;
	}
	

}
