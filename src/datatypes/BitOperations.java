package datatypes;

public class BitOperations {
	
	public interface BinaryOperation {
		public Bit binaryOperation (Bit a, Bit b);
	}
	
	public interface UnaryOperation {
		public Bit unaryOperation (Bit a);
	}
	
	public static final BinaryOperation and = (a, b) -> Bit.and(a,  b);
	public static final BinaryOperation or = (a, b) -> Bit.or(a,  b);
	public static final BinaryOperation nand = (a, b) -> Bit.nand(a, b);
	public static final BinaryOperation nor = (a, b) -> Bit.nor(a, b);
	public static final BinaryOperation xor = (a, b) -> Bit.xor(a, b);
	public static final BinaryOperation xnor = (a, b) -> Bit.xnor(a, b);
	
	public static final BinaryOperation implies = (a, b) -> Bit.implies(a, b);
	public static final BinaryOperation impliedBy = (a, b) -> Bit.impliedBy(a, b);
	public static final BinaryOperation without = (a, b) -> Bit.without(a, b);
	public static final BinaryOperation unwithout = (a, b) -> Bit.unwithout(a, b);
	
	public static final BinaryOperation yep = (a, b) -> Bit.yep(a, b);
	public static final BinaryOperation nope = (a, b) -> Bit.nope(a, b);
	
	public static final BinaryOperation first = (a, b) -> Bit.first(a, b);
	public static final BinaryOperation second = (a, b) -> Bit.second(a, b);
	public static final BinaryOperation notFirst = (a, b) -> Bit.notFirst(a, b);
	public static final BinaryOperation notSecond = (a, b) -> Bit.notSecond(a, b);
	
	public static final UnaryOperation not = (a) -> Bit.not(a);
	
	public static Bit operate(Bit a, Bit b, BinaryOperation op) {
		return op.binaryOperation(a,  b);
	}
	
	public static Bit operate(Bit a, UnaryOperation op) {
		return op.unaryOperation(a);
	}
	
	public static void main(String[] args) {
		Bit a = new Bit(false);
		Bit b = new Bit(true);
		System.out.print(operate(a, b, and));
	}
}
