package mar03;

import java.util.HashMap;
import java.util.Map;

public class StringMethods {
    static {
        System.out.println("(1) class:StringMethods: loaded static initializer");
    }
    {
        System.out.println("(2) class:StringMethods: loaded non static initializer");
    }

    public StringMethods() {
        System.out.println("(3) class:StringMethods: loaded default constructor");
    }
    
    public boolean isPalindrome(char[] userStr) {
        for (int i = 0; i < userStr.length / 2; i++) {
            if (userStr[i] != userStr[userStr.length - (i + 1)]) {
                return false;
            }
        }
        return true;
    }
    
    public void countVowelsAndConsonants(char[] userStr) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (char c : userStr) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCount++;
            else if (c >= 'a' && c <= 'z') consonantCount++;
        }
        System.out.println("COUNT: Vowels::" + vowelCount + " | Consonants: " + consonantCount);
    }

    public void countEachChar(char[] userStr) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(char chr : userStr) {
            charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
        }
        System.out.println("CHARACTER COUNT:");
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            System.out.print(entry.getKey() + "::" + entry.getValue()+" |");
        }
        System.out.println();
    }
}
