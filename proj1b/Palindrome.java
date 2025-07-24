public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        int len = word.length();
        int i = 0;
        int j = len - 1;
        for (; i < len / 2; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> n, CharacterComparator cc) {
        if (n.size() <= 1) {
            return true;
        } else {
            Character fir = n.removeFirst();
            Character las = n.removeLast();
            boolean rest = isPalindromeHelper(n, cc);
            return (cc.equalChars(fir, las)) && rest;
        }
    }
}
