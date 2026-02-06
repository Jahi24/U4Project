import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder fileData = new StringBuilder();
        try {
            File f = new File("src/data1");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData.append(line).append("\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] lines = fileData.toString().split("\n");
        int numberOfLines = lines.length;
        Poker[] allHands = new Poker[numberOfLines];
        for (int i = 0; i < lines.length; i++) {         // for each line in the file, make a Poker object with all the proper info: allHands[i] = new Poker( ... )
            String  currentHand = lines[i];
            String[] cardsPart = currentHand.split("\\|");
            String[] cards = cardsPart[0].split(",");
            int bid = Integer.parseInt(cardsPart[1]);
            String str1 = cards[0];
            String str2 = cards[1];
            String str3 = cards[2];
            String str4 = cards[3];
            String str5 = cards[4];
            allHands[i] = new Poker(str1, str2, str3, str4, str5, bid);
            allHands[i].registerHand();
        }
        Poker.printInfo();
    }
}