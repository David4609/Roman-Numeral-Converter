package com.thien.romanconverter;


import org.junit.Test;

/**
 * Facilitates conversion of Arabic numbers to Roman numerals
 *
 * This class functions similar to Integer or Float, in that it has a useful static method for the purpose of the exercise
 */
public class ArabicNumeral {
    /**
     * Turns an Arabic number into a Roman numeral
     * @param arabic the Arabic number
     * @pre 1 <= arabicString <= 3999
     * @return the Roman numeral representation of arabic
     */
    public static String toRoman(int arabic) {
        String answer = "";
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //Always add as many of the largest Roman numerals as you can
        for (int i = 0; i < values.length; i++) {
            while (arabic >= values[i]) {
                answer += romanValue(values[i]);
                arabic -= values[i];
            }
        }
        return answer;
    }

    /**
     * Helper to turn specific integers into their atomic Roman numeral
     * @param arabic the specific arabic number to be converted
     * @return the basic Roman representation
     */
    private static String romanValue(int arabic) {
        switch (arabic) {
            case 1000: return "M";
            case 900: return "CM";
            case 500: return "D";
            case 400: return "CD";
            case 100: return "C";
            case 90: return "XC";
            case 50: return "L";
            case 40: return "XL";
            case 10: return "X";
            case 9: return "IX";
            case 5: return "V";
            case 4: return "IV";
            case 1: return "I";
            default: return "";
        }
    }

    @Test
    public void testArabicConversion() {
        assert toRoman(1).equals("I");
        assert toRoman(99).equals("XCIX");
        assert toRoman(100).equals("C");
        assert toRoman(499).equals("CDXCIX");
        assert toRoman(501).equals("DI");
        assert toRoman(3999).equals("MMMCMXCIX");
    }
}
