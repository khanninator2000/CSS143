public class CharList {
    private char[] letters;
    private int size;

    public CharList() {
        letters = new char[8];
        size = 0;
    }

    public CharList(String s) {
        letters = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            letters[i] = s.charAt(i);
        }
        size = letters.length;
    }

    public CharList(CharList c) {
        this.letters = new char[c.letters.length];
        System.arraycopy(c.letters, 0, this.letters, 0, c.letters.length);
        this.size = letters.length;
    }

    public void add(char t) {
        if (size == letters.length) {
            resize();
        }
        letters[size++] = t;
    }

    public char get(int index) {
        return letters[index];
    }

    private void resize() {
        char[] temp = new char[letters.length + (letters.length >> 1)];
        System.arraycopy(letters, 0, temp, 0, letters.length);
        this.letters = temp;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0;i < size; s+=letters[i], i++);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof CharList && this.toString().equals(obj.toString());
    }
}
