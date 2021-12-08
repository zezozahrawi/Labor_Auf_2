import java.io.FileReader;
import java.io.IOException;

public class Aufgabe_2 {
    public static void main(String[] args) throws IOException {
    int[] counter = new int[26];
    for(int i=0; i<26; i++) {
        counter[i]=0;
    }

    FileReader read = new FileReader("Output_Encrypted.txt");
    

    char[] buff = new char[1024];

    int n;

    while ((n = read.read(buff)) > 0) {
        for (int i = 0; i < n; ++i) {
            if (buff[i] >= 'a' && buff[i] <= 'z') {
                ++counter[buff[i] - 'a'];
            }
            else if (buff[i] >= 'A' && buff[i] <= 'Z') {
                ++counter[buff[i] - 'A'];
            }
    }
    
    }
    read.close();

    int N = 0;
    for (int i = 0; i < 26; ++i) {
         N += counter[i]; 
        }
        for (int i = 0; i < 26; ++i) {
            System.out.printf("%c: %d (%3.2f%%)", (char) (i + 'A'), counter[i], (counter[i] * 100.0) / N);
            System.out.println();
        }
}
}
