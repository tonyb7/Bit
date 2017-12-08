package datatypes;

import java.util.*;
//import BitOperations.*;

public class Bits {
	
	private List<Bit> bits = new ArrayList<Bit>();
	public boolean isBigEndian = false; //TODO Implement proper endianness
	
	public Bits() {
		bits = new ArrayList<Bit>();
	}
	
	public Bits(int length) {
		bits = new ArrayList<Bit>(length);
		while(bits.size() < length) {
			bits.add(new Bit());
		}
	}
	
	public Bits(Bit[] bitArray) {
		bits = Arrays.asList(bitArray);
	}
	
	public Bits(List<Bit> bitList) {
		bits = new ArrayList<Bit>(bitList);
	}
	
	public Bits(Bits bitsToCopy) {
		bits = new ArrayList<Bit>(bitsToCopy.bits);
	}
	
	public Bits(boolean[] bitArray) {
		//TODO
	}
	
	
	public Bits clone() {
		return new Bits(this);
	}
	
	public Bit getBit(int index) {
		return bits.get(index);
	}
	
	public void setBit(int index, Bit newBit) {
		bits.set(index, newBit);
	}
	
	public void setBit(int index) {
		bits.set(index, new Bit());
	}
	
	public int length() {
		return bits.size();
	}
	
	/*
	public Bits padded(int a) {
		//TODO: Die
		return null; //later
	}*/
	
	public Bits binaryBitwise(Bits a, BitOperations.BinaryOperation operation) {
		Bits longer = this.length() > a.length()? this : a; //I know I could just clone and call it out, but this seems cleaner.
		Bits shorter = this.length() < a.length()? this : a;
		Bits out = longer.clone(); //See above
		
		for (int i = 0; i < shorter.length(); i++) {
			out.setBit(i, BitOperations.operate(out.getBit(i), shorter.getBit(i), operation));
		}
		
		return out;
	}
	
	public Bits unaryBitwise(BitOperations.UnaryOperation operation) {
		Bits out = this.clone();
		
		for (int i = 0; i < out.length(); i++) {
			out.setBit(i, BitOperations.operate(out.getBit(i), operation));
		}
		
		return out;
	}
	
	public void fillBits() {
		for (int i = 0; i < bits.size(); i++) {
			bits.set(i, new Bit());
		}
	}
	
	public void fillBits(Bit a) {
		for (int i = 0; i < bits.size(); i++) {
			bits.set(i, a.clone());
		}
	}
	
	public String toString() {
		String out = "";
		
		for(int i = 0; i < this.length() - 1; i++) {
			out += this.getBit(i).toString() + ", ";
		}
		
		out += this.getBit(this.length() - 1).toString();
		return out;
	}
	
	public int toInt() {
		int out = 0;
		
		for(int i = 0; i < this.length(); i++) {
			out += Math.pow(this.getBit(i).getState()? 2 : 0, this.length() - i);
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		Bits sevenBitByte = new Bits(7);
		sevenBitByte.setBit(2, new Bit(true));
		System.out.println(sevenBitByte.length());
		System.out.println(sevenBitByte.toString());
		System.out.println(sevenBitByte.toInt());
	}
}