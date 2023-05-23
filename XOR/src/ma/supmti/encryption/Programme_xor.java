package ma.supmti.encryption;

public class Programme_xor {
	
	// Java program to implement XOR - Encryption
	    // The same function is used to encrypt and
	    // decrypt
	    static String encryptDecrypt(String inputString)
	    {
	        // Define XOR key
	        // Any character value will work
	        String xorKey = "key" ;
	 
	        // Define String to store encrypted/decrypted String
	        String outputString = "";
	 
	        // calculate length of input string
	        int len = inputString.length();
	 
	        // perform XOR operation of key
	        // with every character in string
	        int cpos = 0;
	        for (int i = 0; i < len; i++)
	        {
	            outputString = outputString +
	            Character.toString((char) (inputString.charAt(i) ^ xorKey.charAt(cpos)));
	            cpos++;
	            if (cpos >= xorKey.length()) {
	                cpos = 0;
	            }
	        }
	 
	        System.out.println(outputString);
	        return outputString;
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	        String sampleString = "valider le semester";
	 
	        // Encrypt the string
	        System.out.println("Encrypted String");
	        String encryptedString = encryptDecrypt(sampleString);
	 
	        // Decrypt the string
	        System.out.println("Decrypted String");
	        encryptDecrypt(encryptedString);
	    }
	

}
