package datatypes;

import java.util.*;
//import BitOperations.*;

public class Bits {
	
	private List<Bit> bits = new ArrayList<Bit>();
	
	public Bits () {
		bits = new ArrayList<Bit>();
	}
	
	public Bits (int length) {
		bits = new ArrayList<Bit>();
		this.fillBits();
	}
	
	public Bits (Bit[] bitArray) {
		bits = Arrays.asList(bitArray);
	}
	
	public Bits (List<Bit> bitList) {
		bits = new ArrayList<Bit>(bitList);
	}
	
	public Bits (Bits bitsToCopy) {
		bits = new ArrayList<Bit>(bitsToCopy.bits);
	}
	
	public Bits clone() {
		return new Bits(this);
	}
	
	public Bit getBit (int index) {
		return bits.get(index);
	}
	
	public void setBit (int index, Bit newBit) {
		bits.set(index, newBit);
	}
	
	public void setBit (int index) {
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
	
	public Bits binaryBitwise (Bits a, BitOperations.BinaryOperation operation) {
		Bits out = (this.length() > a.length()? this : a).clone();
		
		int smallLength = Math.min(this.length(), a.length());
				
		for (int i = 0; i < smallLength; i++) {
			
		}
		
		return null;
	}
	
	public Bits unaryBitwise (BitOperations.UnaryOperation operation) {
		return null;
	}
	
	public void fillBits () {
		for (int i = 0; i < bits.size(); i++) {
			bits.set(i, new Bit());
		}
	}
	
	public void fillBits (Bit a) {
		for (int i = 0; i < bits.size(); i++) {
			bits.set(i, a.clone());
		}
	}
}