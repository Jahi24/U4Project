import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean part1 = true;
        boolean part2 = false;
        boolean part3 = false;
        while (part1){
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
            part1 = false;
            Poker.resetInfo();
            part2 = true;
        }

        while (part2){
            int totalBidValue = 0;
            StringBuilder fileData = new StringBuilder();
            try {
                File f = new File("src/data2");
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
                allHands[i].createRank();
            }
            for (Poker allHand : allHands) {
                allHand.rank = numberOfLines;
                for (Poker hand : allHands) {
                    allHand.compareHands(hand);
                }
            }
            System.out.println();
            for (Poker hand: allHands){
                hand.printRank();
                totalBidValue += hand.getBidValue();
            }
            System.out.println();
            Poker.printInfo();
            System.out.println("Total Bid Value: " + totalBidValue);
            part2 = false;
            Poker.resetInfo();
            part3 = true;
        }

        while (part3){
            System.out.println("***Part 3***");
            part3 = false;
        }
    }
}