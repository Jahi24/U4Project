public class Poker {
    public static int highCards = 0;
    public static int onePairs = 0;
    public static int twoPairs = 0;
    public static int threeOAKs = 0;
    public static int fullHouses = 0;
    public static int fourOAKs = 0;
    public static int fiveOAKs = 0;
    public int nullCount = 0;
    public String[] hand = new String[5];
    public int[] numbHand = new int[5];

    public Poker(String string1, String string2, String string3, String string4, String string5, int bid){
        hand[0] = string1;
        hand[1] = string2;
        hand[2] = string3;
        hand[3] = string4;
        hand[4] = string5;
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
        }
        if (nullCount == 3) {//If final list/array has three null items, increment number of 3OAKs by 1
            Poker.threeOAKs++;
        }
        if (nullCount == 0) {//If final list/array has zero null items, increment number of High Cards by 1
            Poker.highCards++;
        }
        if (nullCount == 4) {//If final list/array has four null items, check if the string created in step 3 has a length of 2 or 3
            if (count.length() == 2) { //if the length is 2, increment 4OAKs by 1
                Poker.fourOAKs++;
            } else if (count.length() == 3) {//is the length is 3, increment Two Pairs by 1
                Poker.twoPairs++;
            }
        }
        if (nullCount == 5) {//If final list/array has five null items, check is the string created in step 3 has a length of 1 or 2             if (count.length() == 1) { //if the length is 1, increment 5OAKs by 1
            if (count.length() == 1) {
                Poker.fiveOAKs++;
            } else if (count.length() == 2) { //if the length is 2, increment Full Houses by 1
                Poker.fullHouses++;
            }
        }
    }

    public void printInfo() {
        System.out.println("High Cards: " + highCards + "\n" +
                "One Pairs: " + onePairs + "\n" +
                "Two Pairs: " + twoPairs + "\n" +
                "Three of a Kinds: " + threeOAKs + "\n" +
                "Full Houses: " + fullHouses + "\n" +
                "Four of a Kinds: " + fourOAKs + "\n" +
                "Five of a Kinds: " + fiveOAKs);
    }
}