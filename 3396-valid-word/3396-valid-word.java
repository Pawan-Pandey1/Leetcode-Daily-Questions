class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }

        int vowel = 0;
        int consonant = 0;
        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch))
                return false;

            if (Character.isLetter(ch)) {
                String vowels = "aeiou";
                char lower = Character.toLowerCase(ch);

                if (vowels.indexOf(lower) != -1) {
                    vowel++;
                } else {
                    consonant++;
                }
            }
        }
        return vowel > 0 && consonant > 0;
    }
}