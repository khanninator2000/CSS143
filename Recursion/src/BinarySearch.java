// Krish Kalai
// CSS 143 B
// Recursion

/**
 * A class that implements binary search to find a value in an array.
 */
public class BinarySearch extends SearchAlgorithm {
    /**
     * Iterative binary search. Binary search has a hard complexity of O(log(N)).
     *
     * @param words The List of words to search from.
     * @param wordToFind The word to find in words.
     * @return The index of the element, if it exists.
     * @throws ItemNotFoundException If wordToFind is not present in words.
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int left_index = 0;
        int right_index = words.length - 1;
        int middle;
        while (left_index <= right_index) {
            middle = (left_index + right_index) / 2;
            incrementCount();

            if (words[middle].equals(wordToFind)) {
                return middle;
            }

            if (words[middle].compareTo(wordToFind) > 0) {
                right_index = middle - 1;
            }
            else if (words[middle].compareTo(wordToFind) < 0) {
                left_index = middle + 1;
            }
        }
        throw new ItemNotFoundException();
    }
    
    /**
     * Recursive binary search.
     *
     * @param words The array of words to search through.
     * @param wordToFind The word to find.
     * @return The index of the item, if it exists.
     * @throws ItemNotFoundException If wordToFind is not present in words.
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(words, wordToFind, 0, words.length);
    }
    
    /**
     * Helper function for the recursion call.
     *
     * @param words The array of words to search through.
     * @param wordToFind The word to find.
     * @param left The left bound.
     * @param right The right bound.
     * @return The index of the item, if it exists.
     * @throws ItemNotFoundException If wordToFind is not present in words.
     */
    private int recSearch(String[] words, String wordToFind, int left, int right) throws ItemNotFoundException {
        if (left > right) {
            throw new ItemNotFoundException();
        }
        int middle = (left + right) >>> 1;
        incrementCount();
        return words[middle].compareTo(wordToFind) < 0 ? recSearch(words, wordToFind, middle + 1, right) :
               words[middle].compareTo(wordToFind) > 0 ? recSearch(words, wordToFind, left, middle - 1) : middle;
    }
}
