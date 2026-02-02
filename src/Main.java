public class Main {
    public static void main(String[] args) {
        Poker hand = new Poker("Jack", "King", "Ace", "Ace", "Ace");
        hand.getHandType();
        hand.printInfo();
    }
}