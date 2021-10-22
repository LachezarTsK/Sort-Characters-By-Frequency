
import java.util.Arrays;

public class Solution {

    public final int TOTAL_ASCII_CHARS_FROM_ZERO_CHAR_TO_LOWERCASE_Z = 75;
    public Letter[] frequency;

    public String frequencySort(String s) {
        initializeFrequency();
        recordFrequency(s);
        return createStringInDecreasingOrderOfCharFrequency();
    }

    public void initializeFrequency() {
        frequency = new Letter[TOTAL_ASCII_CHARS_FROM_ZERO_CHAR_TO_LOWERCASE_Z];
        int n = frequency.length;
        for (int i = 0; i < n; i++) {
            frequency[i] = new Letter();
        }
    }

    public void recordFrequency(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - '0';
            frequency[index].frequency++;
            frequency[index].index = index;
        }
    }

    public String createStringInDecreasingOrderOfCharFrequency() {

        Arrays.sort(frequency, (x, y) -> y.frequency - x.frequency);
        StringBuilder decreasingCharFrequency = new StringBuilder();
        int n = frequency.length;

        for (int i = 0; i < n && frequency[i].frequency > 0; i++) {
            int numberOfChars = frequency[i].frequency;
            while (numberOfChars-- > 0) {
                decreasingCharFrequency.append((char) ('0' + frequency[i].index));
            }
        }

        return decreasingCharFrequency.toString();
    }
}

class Letter {

    int frequency;
    int index;
}
