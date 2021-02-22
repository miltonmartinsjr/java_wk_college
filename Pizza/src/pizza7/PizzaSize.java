package pizza7;

public enum PizzaSize {
	
	petite,
	moyenne,
	grande,
	large;
	
	public int getSize() {
		
		int size=-1;		
		switch (this) {
		case petite: size= 8; break;
		case moyenne: size= 10; break;
		case grande: size= 12; break;
		case large: size= 15; break;
		}
		return size;
		
	}

}
