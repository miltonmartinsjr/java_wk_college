package pizza4;

public class PizzaMenu {
	
	private Pizza p; 
	private TypePizza type;
	
	public PizzaMenu(TypePizza tp, PizzaSize s) {
		
		int size = s.getSize();
		this.type=tp;
		
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
	public TypePizza getType() {
		return type;
	}

}
