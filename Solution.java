
import java.util.Arrays;

public class Solution {

    private final class CharacterData {
        int frequency = 0;
        char character = '\u0000';
    }

    private static final int ASCII_CONTROL_AND_PRINTABLE_CHARACTERS_SIZE = 128;

    public String frequencySort(String input) {
        CharacterData[] data = new CharacterData[ASCII_CONTROL_AND_PRINTABLE_CHARACTERS_SIZE];
        for (int i = 0; i < data.length; ++i) {
            data[i] = new CharacterData();
        }
        for (int i = 0; i < input.length(); ++i) {
            data[input.charAt(i)].character = input.charAt(i);
            ++data[input.charAt(i)].frequency;
        }

        Arrays.sort(data, (x, y) -> y.frequency - x.frequency);
        StringBuilder charactersByDescendingFrequency = new StringBuilder();
        for (CharacterData current : data) {
            while (current.frequency-- > 0) {
                charactersByDescendingFrequency.append(current.character);
            }
        }
        return charactersByDescendingFrequency.toString();
    }
}
