import java.util.Objects;
public class Poker {
    private static int highCards = 0;
    private static int onePairs = 0;
    private static int twoPairs = 0;
    private static int threeOAKs = 0;
    private static int fullHouses = 0;
    private static int fourOAKs = 0;
    private static int fiveOAKs = 0;
    private int nullCount = 0;
    private final String[] hand = new String[5];
    private String handType = "";
    private int[] numbHand = new int[5];
    private int bid;

    public Poker(String string1, String string2, String string3, String string4, String string5, int bid){
        hand[0] = string1;
        hand[1] = string2;
        hand[2] = string3;
        hand[3] = string4;
        hand[4] = string5;
        numbHand[0] = Poker.iconToNumber(string1);
        numbHand[1] = Poker.iconToNumber(string2);
        numbHand[2] = Poker.iconToNumber(string3);
        numbHand[3] = Poker.iconToNumber(string4);
        numbHand[4] = Poker.iconToNumber(string5);
        this.bid = bid;
    }

    public static int iconToNumber(String input) {
        if (Objects.equals(input, "2")){
            return 2;
        }
        if (Objects.equals(input, "3")){
            return 3;
        }
        if (Objects.equals(input, "4")){
            return 4;
        }
        if (Objects.equals(input, "5")){
            return 5;
        }
        if (Objects.equals(input, "6")){
            return 6;
        }
        if (Objects.equals(input, "7")){
            return 7;
        }
        if (Objects.equals(input, "8")){
            return 8;
        }
        if (Objects.equals(input, "9")){
            return 9;
        }
        if (Objects.equals(input, "10")){
            return 10;
        }
        if (Objects.equals(input, "Jack")){
            return 11;
        }
        if (Objects.equals(input, "Queen")){
            return 12;
        }
        if (Objects.equals(input, "King")){
            return 13;
        }
        return 14;
    }

    public static int handToNumber(String input) {
        if (Objects.equals(input, "High Card")){
            return 1;
        }
        if (Objects.equals(input, "One Pair")){
            return 2;
        }
        if (Objects.equals(input, "Two Pair")){
            return 3;
        }
        if (Objects.equals(input, "Three of a Kind")){
            return 4;
        }
        if (Objects.equals(input, "Full House")){
            return 5;
        }
        if (Objects.equals(input, "Four of a Kind")){
            return 6;
        }
        return 7;
    }

    public void makeHand() {
        StringBuilder count = new StringBuilder();//Record the number of items found that match the chosen item (if none found, keep at 1), add this number to an empty string.
        for (int i = 0; i < hand.length; i++) { //Pick first element in the Array
            // If any item in the list has been counted as a match, replace as a null string.
            //Repeat steps for the other items in the list
            if (hand[i] == null) {
                continue; // already removed
            }
            String current = hand[i];
            int matches = 1; // Counting the card in question
            for (int j = i + 1; j < hand.length; j++) { //Traverse the Array to see if any other element is the same
                if (hand[j] != null && hand[j].equals(current)) {
                    matches++;
                    hand[j] = null; //mark duplicate as null
                    nullCount++;
                }
            }
            count.append(matches); //mark the original card as null too
            if (matches > 1){
                hand[i] = null;
                nullCount++;
            }
        }

        if (nullCount == 2) {//If final list/array has two null items, increment number of One Pairs by 1
            Poker.onePairs++;
            handType = "One Pair";
        }
        if (nullCount == 3) {//If final list/array has three null items, increment number of 3OAKs by 1
            Poker.threeOAKs++;
            handType = "Three of a Kind";
        }
        if (nullCount == 0) {//If final list/array has zero null items, increment number of High Cards by 1
            Poker.highCards++;
            handType = "High Card";
        }
        if (nullCount == 4) {//If final list/array has four null items, check if the string created in step 3 has a length of 2 or 3
            if (count.length() == 2) { //if the length is 2, increment 4OAKs by 1
                Poker.fourOAKs++;
                handType = "Four of a Kind";
            } else if (count.length() == 3) {//is the length is 3, increment Two Pairs by 1
                Poker.twoPairs++;
                handType = "Two Pair";
            }
        }
        if (nullCount == 5) {//If final list/array has five null items, check is the string created in step 3 has a length of 1 or 2             if (count.length() == 1) { //if the length is 1, increment 5OAKs by 1
            if (count.length() == 1) {
                Poker.fiveOAKs++;
                handType = "Five of a Kind";
            } else if (count.length() == 2) { //if the length is 2, increment Full Houses by 1
                Poker.fullHouses++;
                handType = "Full House";
            }
        }
    }

    public void createRank(){

    }

    public void getHandType(){
        System.out.println(handType);
    }

    public static void printInfo() {
        System.out.println("High Cards: " + highCards + "\n" +
                "One Pairs: " + onePairs + "\n" +
                "Two Pairs: " + twoPairs + "\n" +
                "Three of a Kinds: " + threeOAKs + "\n" +
                "Full Houses: " + fullHouses + "\n" +
                "Four of a Kinds: " + fourOAKs + "\n" +
                "Five of a Kinds: " + fiveOAKs);
    }
}