package xor_programme;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Prog1 {

	private static String cryptage_xor(String origine, String cle) throws UnsupportedEncodingException {
		final byte [] input = origine.getBytes(StandardCharsets.US_ASCII);
		System.out.println(input);
		final byte [] key = cle.getBytes();
        final byte[] output = new byte[input.length];
        if (key.length == 0) {
            throw new IllegalArgumentException("clé obligatoire !");
        }
        int kpos = 0;
        for (int pos = 0; pos < input.length; ++pos) {
            output[pos] = (byte) (input[pos] ^ key[kpos]);
            ++kpos;
            if (kpos >= key.length) {
                kpos = 0;
            }
        }
        String encryptedData = Base64.getEncoder().encodeToString(output);
        return encryptedData;
    }
	
	private static String decryptage_xor(String input,String cle){
        int kpos = 0;
        try{
        	final byte [] key = cle.getBytes();
            byte [] output = Base64.getDecoder().decode(input);
        for (int pos = 0; pos < output.length; ++pos) {
            output[pos] = (byte) (output[pos] ^ key[kpos]);
            ++kpos;
            if (kpos >= key.length) {
                kpos = 0;
            }
        }
        return new String(output, StandardCharsets.US_ASCII);
       }
        catch(Exception e){
            
        }
        return null;
    }
	
	public static void main(String[] args) {
        try{
         String origine = "GeeksforGeeks";
         String cle="P";
            System.out.println("Original String : "+origine);
            String messagecrypter = cryptage_xor(origine,cle);
            System.out.println("String after encryption :  "+messagecrypter);
            System.out.println("String after decryption :  "+decryptage_xor(messagecrypter,cle));
        }
         catch(Exception e){
            
        }
            

    }
	
}
