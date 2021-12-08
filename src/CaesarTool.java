import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CaesarTool {



    public static void main(String[] args) throws FileNotFoundException {


        // the user will be asked to enter his choice between Encryption - Decryption
        System.out.print("1. Encryption\n2. Decryption\nEnter your choice:");
        try (Scanner in = new Scanner(System.in)) {
            int choice = in.nextInt();
            if (choice == 1) {
                try (Scanner userKey = new Scanner(System.in)) {
                    System.out.print("Enter your Key:");
                    String key = userKey.nextLine();
        
                    Scanner input = new Scanner(new File("InputCode.txt"));
                        PrintStream output = new PrintStream(new File("Output_Encrypted.txt")); 
                    while (input.hasNextLine()) {
                        output.println(Encrypt(input.nextLine(), Integer.parseInt(key)));
                    }
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }else if (choice == 2){
                try (Scanner userKey = new Scanner(System.in)) {
                    System.out.print("Enter your Key:");
                    String key = userKey.nextLine();
        
                    Scanner input = new Scanner(new File("Output_Encrypted.txt"));
                        PrintStream output = new PrintStream(new File("Output_Decrypted.txt")); 
                    while (input.hasNextLine()) {
                        output.println(Decrypt(input.nextLine(), Integer.parseInt(key)));
                    }
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 

            } else {
                System.out.println("Wrong Choice");

            }



        
        
    }
}
    


public static String Encrypt(String text, int shift)
	{
		String encryptedText="";
		int length = text.length();
		
		if(shift > 26)
			shift = shift % 26;
		
		else if(shift < 0)
			shift = (shift % 26) + 26;
		
		for (int i = 0; i < length; i++)
		{
			char charr = text.charAt(i);
			if (Character.isLetter(charr))
			{
				if(Character.isUpperCase(charr)) 
				{
					char ch = (char)(charr + shift);
					if(ch > 'Z')
						encryptedText += (char)(charr - (26 - shift));
					
					else
						encryptedText += ch;
				}
				
				else if (Character.isLowerCase(charr))
				{
					char ch = (char)(charr + shift);
					if(ch > 'z')
						encryptedText += (char)(charr - (26 - shift));
					
					else
						encryptedText += ch;
				}
				
			}
			
			else 
				encryptedText += charr;
			
		}
		
		return encryptedText;
	}

    public static String Decrypt(String text, int shift)
	{
		String decryptedText="";
		int length = text.length();
		
		if(shift > 26)
			shift = shift % 26;
		
		else if(shift < 0)
			shift = (shift % 26) + 26;
		
		for (int i = 0; i < length; i++)
		{
			char charr = text.charAt(i);
			if (Character.isLetter(charr))
			{
				if(Character.isUpperCase(charr)) 
				{
					char ch = (char)(charr - shift);
					if(ch < 'A')
						decryptedText += (char)(charr + (26 - shift));
					
					else
						decryptedText += ch;
				}
				
				else if (Character.isLowerCase(charr))
				{
					char ch = (char)(charr - shift);
					if(ch > 'a')
						decryptedText += (char)(charr + (26 - shift));
					
					else
						decryptedText += ch;
				}
				
			}
			
			else 
				decryptedText += charr;
			
		}
		
		return decryptedText;
	}


}