public class LinearSearch extends SearchAlgorithm {
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int index = 0;
        for (; index < words.length && !(words[index].equalsIgnoreCase(wordToFind)); incrementCount(), index++);
        if (index < words.length) {
            return index;
        }
        else {
            throw new ItemNotFoundException("Item not found");
        }
    }

    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(words, wordToFind, 0);
    }

    private int recSearch(String[] words, String word_to_find, int index) throws ItemNotFoundException {
        if (index == words.length) {
            throw new ItemNotFoundException("Item not found");
        }
        if (words[index].equals(word_to_find)) {
            return index;
        }
        incrementCount();
        return recSearch(words, word_to_find, index + 1);
    }
}
