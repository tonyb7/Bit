package utilites;

public class ByteUtils {
	
	public static String byteToString (byte inputByte) {
	    StringBuilder sb = new StringBuilder(/*bytes.length * */ Byte.SIZE);
	    
	    for (int i = 0; i < Byte.SIZE /* * bytes.length*/; i++ )
	        sb.append((/*bytes[i / Byte.SIZE]*/inputByte << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
	    
	    return sb.toString();
	}
}
