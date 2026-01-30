
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int highCards = 0;
        int onePairs = 0;
        int twoPairs = 0;
        int threeOAKs = 0;
        int fullHouses = 0;
        int fourOAKs = 0;
        int fiveOAKs = 0;
//Pick first element in the Array
//Traverse the Array to see if any other element is the same
        String[] hand = {"King", "King", "Ace", "Ace", "Ace"};


//Record the number of items found that match the chosen item (if none found, keep at 1), add this number to an empty string.
//If any item in the list has been counted as a match, remove that item from the list
//Repeat steps 1-4 for the other items in the list


//If final list/array has three items, increment number of One Pairs by 1
        if (hand.length == 3){
            onePairs++;
        }
//If final list/array has two items, increment number of 3OAKs by 1
        if (hand.length == 2){
            threeOAKs++;
        }
//If final list/array has five items, increment number of High Cards by 1



//If final list/array has one item, check if the string created in step 3 has a length of 2 or 3

//if the length is 2, increment 4OAKs by 1

//is the length is 3, increment Two Pairs by 1

//If final list/array has zero items, check is the string created in step 3 has a length of 1 or 2

//if the length is 1, increment 5OAKs by 1

//if the length is 2, increment Full Houses by 1

    }
}