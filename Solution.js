
const TOTAL_ASCII_CHARS_FROM_ZERO_CHAR_TO_LOWERCASE_Z = 75;
const CODE_POINT_ASCII_ZERO_CHAR = 48;
var frequency;

/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function (s) {
    frequency = [];
    for (let i = 0; i < TOTAL_ASCII_CHARS_FROM_ZERO_CHAR_TO_LOWERCASE_Z; i++) {
        frequency[i] = [0, i];
    }
    recordFrequency(s);
    return createStringInDecreasingOrderOfCharFrequency();
};

/**
 * @param {string} s
 */
function recordFrequency(s) {
    let n = s.length;
    for (let i = 0; i < n; i++) {
        let index = s.codePointAt(i) - CODE_POINT_ASCII_ZERO_CHAR;
        frequency[index][0]++;
    }
}

/**
 * @return {string}
 */
function createStringInDecreasingOrderOfCharFrequency() {

    frequency.sort((x, y) => y[0] - x[0]);
    let decreasingCharFrequency = "";
    let n = frequency.length;

    for (let i = 0; i < n && frequency[i][0] > 0; i++) {
        let numberOfChars = frequency[i][0];
        while (numberOfChars-- > 0) {
            decreasingCharFrequency += String.fromCodePoint(CODE_POINT_ASCII_ZERO_CHAR + frequency[i][1]);
        }
    }

    return decreasingCharFrequency;
}
