
/**
 * @param {string} input
 * @return {string}
 */
var frequencySort = function (input) {
    const ASCII_CONTROL_AND_PRINTABLE_CHARACTERS_SIZE = 128;
    const data = new Array(ASCII_CONTROL_AND_PRINTABLE_CHARACTERS_SIZE);

    for (let i = 0; i < data.length; ++i) {
        data[i] = new CharacterData();
    }
    for (let i = 0; i < input.length; ++i) {
        data[input.codePointAt(i)].character = input.charAt(i);
        ++data[input.codePointAt(i)].frequency;
    }

    data.sort((x, y) => y.frequency - x.frequency);
    const charactersByDescendingFrequency = [];
    for (let current of data) {
        while (current.frequency-- > 0) {
            charactersByDescendingFrequency.push(current.character);
        }
    }
    return charactersByDescendingFrequency.join('');
};

function  CharacterData() {
    this.frequency = 0;
    this.character = '\u0000';
}
