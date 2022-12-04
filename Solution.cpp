
#include <array>
#include <string>
using namespace std;

class Solution {

    struct CharacterData {
        int frequency = 0;
        char character = '\u0000';
    };
    inline static const int ASCII_CONTROL_AND_PRINTABLE_CHARACTERS_SIZE = 128;

public:
    string frequencySort(string& input) const {
        array< CharacterData, ASCII_CONTROL_AND_PRINTABLE_CHARACTERS_SIZE> data{};
        for (const auto& current : input) {
            data[current].character = current;
            ++data[current].frequency;
        }

        //C++20: std::ranges::sort(data, comparator);
        sort(data.begin(), data.end(), [](const CharacterData& x, const CharacterData& y) {return x.frequency > y.frequency;});
        string charactersByDescendingFrequency;
        for (const auto& current : data) {
            charactersByDescendingFrequency.append(current.frequency, current.character);
        }
        return charactersByDescendingFrequency;
    }
};
