package pizza5;


public class PizzaMenu {
	
	public static class TypedPizza{
		private Pizza  pizza;
		private TypePizza type;
		
		public TypedPizza(Pizza p, TypePizza tp) {
			this.pizza =p;
			this.type=tp;
		}
		
		public Pizza getPizza() {
			return this.pizza;
		}
		public TypePizza getType() {
			return this.type;
		}
	}
	
	
	public static TypedPizza getMenuPizza(TypePizza tp, PizzaSize s) {
		
		Pizza p=null; 
		int size = s.getSize();
		
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
		return new TypedPizza(p,tp);
		
	}
	
	public static TypedPizza[] getPizzaPromo(PizzaPromotion pro) {
		 TypedPizza[] p=new TypedPizza[2];
		 switch (pro) {
			case PromoPepperoni: {
				p[0]= getMenuPizza(TypePizza.Pepperoni,PizzaSize.large);
				p[1]= getMenuPizza(TypePizza.Maison,PizzaSize.moyenne);
				break;
			}
			case PromoFromage: {
				p[0]=getMenuPizza(TypePizza.Fromage,PizzaSize.large);
				p[1]=getMenuPizza(TypePizza.Maison,PizzaSize.moyenne);
				break;
			}
			}
		 return p;
		
	}
	
}
