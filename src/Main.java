public class Main {
    public static void main(String[] args) {
        Poker hand1 = new Poker("3","2","10","3","King",765);
        Poker hand2 = new Poker("10","5","5","Jack","5",684);
        Poker hand3 = new Poker("King","King","6","7","7",28);
        Poker hand4 = new Poker("King","10","Jack","Jack","10",220);
        Poker hand5 = new Poker("Queen","Queen","Queen","Jack","Ace",483);
        hand1.makeHand();
        hand1.getHandType();
        hand2.makeHand();
        hand2.getHandType();
        hand3.makeHand();
        hand3.getHandType();
        hand4.makeHand();
        hand4.getHandType();
        hand5.makeHand();
        hand5.getHandType();

        Poker.printInfo();
    }
}