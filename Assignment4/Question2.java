
public class Question2 {
	
	public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
} 
}

class Tool{
   protected int strength;
   protected char type;
   
   public void setStrength(int str) {
	   this.strength = str;
   } 
}

class Rock extends Tool{
	
	Rock(int strength) {
		this.strength = strength;
		this.type = 'r';
	}
	
	public boolean fight (Tool x) {
		if (x.type == 's') {
			return this.strength * 2 > x.strength; 
		}
		else if(x.type == 'p') {
			return this.strength > 2 * x.strength;
		}
		else {
			return this.strength > x.strength;
		}
	}
}

class Scissors extends Tool{
	
	Scissors(int strength) {
		this.strength = strength;
		this.type = 's';
	}
	
	public boolean fight (Tool x) {
		if (x.type == 'p') {
			return this.strength * 2 > x.strength; 
		}
		else if(x.type == 'r') {
			return this.strength > 2 * x.strength;
		}
		else {
			return this.strength > x.strength;
		}
	}
}

class Paper extends Tool{
	
	Paper(int strength) {
		this.strength = strength;
		this.type = 'p';
	}
	
	public boolean fight (Tool x) {
		if (x.type == 'r') {
			return this.strength * 2 > x.strength; 
		}
		else if(x.type == 's') {
			return this.strength > 2 * x.strength;
		}
		else {
			return this.strength > x.strength;
		}
	}
}
