public class Main {
    public static void main(String[] args) {
        Poker hand1 = new Poker("3","2","10","3","King",765);
        Poker hand2 = new Poker("10","5","5","Jack","5",684);
        Poker hand3 = new Poker("King","King","6","7","7",28);
        Poker hand4 = new Poker("King","10","Jack","Jack","10",220);
        Poker hand5 = new Poker("Queen","Queen","Queen","Jack","Ace",483);
        hand1.makeHand();
        hand1.createRank();
        hand2.makeHand();
        hand2.createRank();
        hand3.makeHand();
        hand3.createRank();
        hand4.makeHand();
        hand4.createRank();
        hand5.makeHand();
        hand5.createRank();

        int[] ranks = new int[5];
        ranks[0] = hand1.rank;
        ranks[1] = hand2.rank;
        ranks[2] = hand3.rank;
        ranks[3] = hand4.rank;
        ranks[4] = hand5.rank;
        for (int i = 0; i < ranks.length; i++) {
        }


        Poker.printInfo();
    }
}