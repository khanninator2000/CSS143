/**
 * A class that implements Binary Search to find a value in an array.
 *
 */
public class BinarySearch extends SearchAlgorithm {
    /**
     * Iterative binary search. Binary search has a hard complexity of O(log(N)).
     *
     * @param words The List of words to search from.
     * @param wordToFind The word to find in words.
     * @return The index of the element.
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
        throw new ItemNotFoundException("Item not found");
    }

    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(words, wordToFind, 0, words.length);
    }

    public int recSearch(String[] words, String wordToFind, int left, int right) throws ItemNotFoundException {
        if (left > right) {
            throw new ItemNotFoundException("Item not found.");
        }

        int middle = (left + right) / 2;
        if (words[middle].compareTo(wordToFind) == 0) {
            return middle;
        }

        incrementCount();
        if (words[middle].compareTo(wordToFind) > 0) {
            return recSearch(words, wordToFind, left, middle - 1);
        }
        else {
            return recSearch(words, wordToFind, middle + 1, right);
        }
    }

    public int recSearchNO(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearchNO(words, wordToFind, 0, words.length);
    }

    public int recSearchNO(String[] words, String wordToFind, int left, int right) throws ItemNotFoundException {
        if (left > right) {
            throw new ItemNotFoundException("Item not found.");
        }
        int middle = (left + right) / 2;
        return words[middle].compareTo(wordToFind) < 0 ? recSearch(words, wordToFind, middle + 1, right) :
                words[middle].compareTo(wordToFind) > 0 ? recSearch(words, wordToFind, left, middle - 1) : middle;
    }
}
