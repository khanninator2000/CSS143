// Krish Kalai
// CSS 143 B
// Recursion

/**
 * A class that implements linear search to find a value in an array.
 */
public class LinearSearch extends SearchAlgorithm {
    /**
     * Iterative linear search.
     *
     * @param words The array of words to search through.
     * @param wordToFind The word to find in {@code words}.
     * @return The index of the element, if it exists.
     * @throws ItemNotFoundException If wordToFind is not present in words.
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int index = 0;
        for (; index < words.length && !(words[index].equalsIgnoreCase(wordToFind)); incrementCount(), index++);
        if (index < words.length) {
            return index;
        }
        else {
            throw new ItemNotFoundException();
        }
    }
    
    /**
     * Recursive linear search.
     *
     * @param words The array of words to search through.
     * @param wordToFind The word to find.
     * @return The index of the item, if it exists.
     * @throws ItemNotFoundException If wordToFind is not present in words.
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(words, wordToFind, 0);
    }
    
    /**
     * Helper function for the recursion call.
     *
     * @param words The array of words to search through.
     * @param wordToFind The word to find.
     * @param index The current index.
     * @return The index of the item, if it exists.
     * @throws ItemNotFoundException if the word cannot be found
     */
    private int recSearch(String[] words, String wordToFind, int index) throws ItemNotFoundException {
        if (index == words.length) {
            throw new ItemNotFoundException();
        }
        if (words[index].equals(wordToFind)) {
            return index;
        }
        incrementCount();
        return recSearch(words, wordToFind, index + 1);
    }
}
