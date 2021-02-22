package pizza4;

public class PizzaPromo {
	private PizzaMenu[] p; 
	
	public PizzaPromo(PizzaPromotion pro) {
		p=new PizzaMenu[2];
		switch (pro) {
		case PromoPepperoni: {
			p[0]=new PizzaMenu(TypePizza.Pepperoni,PizzaSize.large);
			p[1]=new PizzaMenu(TypePizza.Maison,PizzaSize.moyenne);
			break;
		}
		case PromoFromage: {
			p[0]=new PizzaMenu(TypePizza.Fromage,PizzaSize.large);
			p[1]=new PizzaMenu(TypePizza.Maison,PizzaSize.moyenne);
			break;
		}
		}
	}
	public PizzaMenu[] getPromo() {
		return this.p;
	}
}
