package datatypes;

public class Bit {
	
	private boolean state;
	
	public Bit() {
		this.state = false;
	}
	
	public Bit(boolean state) {
		this.state = state;
	}
	
	public Bit(int i) {
		this.state = i != 0;
	}
	
	public Bit clone() {
		return new Bit(this.state);
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public int getStateInt() {
		return this.state? 1 : 0;
	}
	
	public void toggle() {
		this.state = !this.state;
	}
	
	public Bit not() {
		return new Bit(!this.getState());
	}
	
	public Bit and(Bit a) {
		return new Bit(this.getState() && a.getState());
	}
	
	public Bit or(Bit a) {
		return new Bit(this.getState() || a.getState());
	}
	
	public Bit nand(Bit a) {
		return this.and(a).not();
	}
	
	public Bit nor(Bit a) {
		return this.or(a).not();
	}
	
	public Bit xor(Bit a) {
		return this.or(a).and(this.nand(a));
	}
	
	public Bit xnor(Bit a) {
		return this.xor(a).not();
	}
	
	public Bit without(Bit a) {
		return this.and(a.not());
	}
	
	public Bit unwithout(Bit a) {
		return a.without(this);
	}
	
	public Bit implies(Bit a) {
		return a.without(this).not();
	}
	
	public Bit impliedBy(Bit a) {
		return a.implies(this);
	}
	
	public Bit nope(Bit a) {
		return new Bit(false);
	}
	
	public Bit yep(Bit a) {
		return new Bit(true);
	}
	
	public Bit first(Bit a) {
		return this.clone();
	}
	
	public Bit second(Bit a) {
		return a.clone();
	}
	
	public Bit notFirst(Bit a) {
		return this.not();
	}
	
	public Bit notSecond(Bit a) {
		return a.not();
	}
	
	
	public static Bit not(Bit a) {
		return new Bit(!a.state);
	}
	
	public static Bit and(Bit a, Bit b) {
		return new Bit(a.state && b.state);
	}
	
	public static Bit or(Bit a, Bit b) {
		return new Bit(a.state || b.state);
	}
	
	public static Bit nand(Bit a, Bit b) {
		return not(and(a, b));
	}
	
	public static Bit nor(Bit a, Bit b) {
		return not(or(a, b));
	}
	
	public static Bit xor(Bit a, Bit b) {
		return and(or(a, b), nand(a, b));
	}
	
	public static Bit xnor(Bit a, Bit b) {
		return not(xor(a, b));
	}
	
	public static Bit without(Bit a, Bit b) {
		return and(a, not(b));
	}
	
	public static Bit unwithout(Bit a, Bit b) {
		return without(b, a);
	}
	
	public static Bit implies(Bit a, Bit b) {
		return not(without(a, b));
	}
	
	public static Bit impliedBy(Bit a, Bit b) {
		return implies(b, a);
	}
	
	public static Bit nope(Bit a, Bit b) {
		return new Bit(false);
	}
	
	public static Bit yep(Bit a, Bit b) {
		return new Bit(true);
	}
	
	public static Bit first(Bit a, Bit b) {
		return a.clone();
	}
	
	public static Bit second(Bit a, Bit b) {
		return b.clone();
	}
	
	public static Bit notFirst(Bit a, Bit b) {
		return a.not();
	}
	
	public static Bit notSecond(Bit a, Bit b) {
		return b.not();
	}
	
	
	public String toString() {	
		return Boolean.toString(this.state);
	}
}
