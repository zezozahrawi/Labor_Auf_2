import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ScytaleTool {

    // Encode Method
    public static String scytaleEncode(String plainText, int numOfRows) {
        String encodedText = "";
        if (numOfRows >= plainText.length() || numOfRows <= 0) {
            return plainText;

        } else {
            while (plainText.length() % numOfRows != 0) {
                plainText += " ";
            }
            int numOfCols = plainText.length() / numOfRows;
            for (int i = 0; i < numOfCols; i++) {
                for (int y = i; y < plainText.length(); y += numOfCols) {
                    encodedText += plainText.charAt(y);
                }
            }
        }
        return encodedText;

    }

    // Decode Method
    public static String scytaleDecode(String encodeString, int numOfRows) {
        String decodedString = "";
        int numOfCols = encodeString.length() / numOfRows;
        decodedString = scytaleEncode(encodeString, numOfCols);
        return decodedString;
    }

    public static void main(String[] args) throws FileNotFoundException {

        // the user will be asked to enter his choice between Encryption - Decryption
        System.out.print("1. Encryption\n2. Decryption\nEnter your choice:");
        try (Scanner in = new Scanner(System.in)) {
            int choice = in.nextInt();


            //encryption choice
            if (choice == 1) {

                // Take user Key and convert it to String *********** 
                try (Scanner userKey = new Scanner(System.in)) {
                    System.out.print("Enter your Key:");
                    String key = userKey.nextLine();

                    Scanner input = new Scanner(new File("InputCode.txt"));
                    PrintStream output = new PrintStream(new File("Output_Encrypted.txt"));
                    while (input.hasNextLine()) {
                        output.println(scytaleEncode(input.nextLine(), Integer.parseInt(key)));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("something went wrong");
                    e.printStackTrace();
                }


                
            } 
            //Decryption Choice
            else if (choice == 2) {

                // Take user Key and convert it to String
                try (Scanner userKey = new Scanner(System.in)) {
                    System.out.print("Enter your Key:");
                    String key = userKey.nextLine();

                    Scanner input = new Scanner(new File("Output_Encrypted.txt"));
                    PrintStream output = new PrintStream(new File("Output_Decrypted.txt"));
                    while (input.hasNextLine()) {
                        output.println(scytaleDecode(input.nextLine(), Integer.parseInt(key)));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("something went wrong");
                    e.printStackTrace();
                }

                
            } 
            // Wrong choice
            else {
                System.out.println("Wrong Choice");

            }

        }

    }
}
