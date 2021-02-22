package pizza4;

public class Pizza {
	
	private int size; 
	private boolean extra_cheese;
	private boolean pepperoni;
	private boolean bacon;
	private boolean olives;
	private boolean chicken;
	private boolean sauce;
	private boolean boiled_egg;
	private boolean anchovy;
	
	public Pizza(int size, boolean extra_cheese, boolean pepperoni, boolean bacon,
			boolean olives, boolean chicken, boolean sauce,
			boolean boiled_egg, boolean anchovy){
		this.size= size; 
		this.extra_cheese= extra_cheese;
		this.pepperoni=pepperoni;
		this.bacon=bacon;
		this.olives=olives;
		this.chicken=chicken;
		this.sauce=sauce;
		this.boiled_egg= boiled_egg;
		this.anchovy= anchovy;		
	}
	
	public int getSize() { return this.size;}
    public boolean hasExtra_Cheese(){ return this.extra_cheese;}
    public boolean hasPepperoni(){ return this.pepperoni;}
    public boolean hasBacon(){ return this.bacon;}
    public boolean hasOlives(){ return this.olives;}
    public boolean hasChicken(){ return this.chicken;}
    public boolean hasSauce(){ return this.sauce;}
    public boolean hasBoiled_egg(){ return this.boiled_egg;}
    public boolean hasAnchovy(){ return this.anchovy;}
    
    
    public static class Builder{ 
    	private int size = 10;    // default 
    	private boolean extra_cheese=false;
    	private boolean pepperoni=false;
    	private boolean bacon=false;
    	private boolean olives=false;
    	private boolean chicken=false;
    	private boolean sauce=false;
    	private boolean boiled_egg=false;
    	private boolean anchovy=false;
    	
    	public Builder(){    		
    	}
    	
    	public Builder size(int size){
    		this.size=size;
    		return this;
    	}    	
    	public Builder extra_cheese(boolean v){
    		this.extra_cheese=v;
    		return this;
    	}
    	public Builder pepperoni(boolean v){
    		this.pepperoni=v;
    		return this;
    	}
    	public Builder bacon(boolean v){
    		this.bacon=v;
    		return this;
    	}
    	public Builder olives(boolean v){
    		this.olives=v;
    		return this;
    	}
    	public Builder chicken(boolean v){
    		this.chicken=v;
    		return this;
    	}
    	public Builder sauce(boolean v){
    		this.sauce=v;
    		return this;
    	}
    	public Builder boiled_egg(boolean v){
    		this.boiled_egg=v;
    		return this;
    	}
    	public Builder anchovi(boolean v){
    		this.anchovy=v;
    		return this;
    	}
    	public Pizza build(){
    		return new Pizza(this);
    	}
    	
    	public int getSize() { return this.size;}
        public boolean hasExtra_Cheese(){ return this.extra_cheese;}
    	public boolean hasPepperoni(){ return this.pepperoni;}
    	public boolean hasBacon(){ return this.bacon;}
    	public boolean hasOlives(){ return this.olives;}
    	public boolean hasChicken(){ return this.chicken;}
    	public boolean hasSauce(){ return this.sauce;}
    	public boolean hasBoiled_egg(){ return this.boiled_egg;}
    	public boolean hasAnchovy(){ return this.anchovy;}
    }
    
    private Pizza (Builder b){
    	this.size= b.getSize();
    	this.extra_cheese=b.hasExtra_Cheese();
    	this.pepperoni=b.hasPepperoni();
    	this.bacon=b.hasBacon();
    	this.olives=b.hasOlives();
    	this.chicken=b.hasChicken();
    	this.sauce=b.hasSauce();
    	this.boiled_egg=b.hasBoiled_egg();
    	this.anchovy=b.hasAnchovy();
    	
    }
    
    
    
    
    
}
