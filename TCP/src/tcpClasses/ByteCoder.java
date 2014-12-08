package tcpClasses;
//import javax.xml.bind.ParseConversionEvent;

//import config.Configurations;


public class ByteCoder {
	// XOR dekryptering ift. key byte ff
	public String decrypt(byte[] b)
	{

		byte ff = (byte) 3.1470;
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
		String encrypted = new String(b).trim();
		return encrypted;
	}
	// XOR kryptering ift. key byte ff
	public byte[] encrypt(String s){
		System.out.println("Encoding string: '" + s + "'...");
		byte[] input = s.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		System.out.println("Encoded value: " + encrypted.toString());
		return encrypted;
	}
}
