package com.zipcodewilmington;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) return true;
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseArray = new String[array.length];
        int pointer = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[pointer] = array[i];
            pointer++;
        }
        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        if (Arrays.equals(array, StringArrayUtils.reverse(array))) {
            return true;
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j < array.length; j++) {
                //System.out.println(array[j] + " " + alphabet.substring(i, i+1));
                if (array[j].toLowerCase().contains(alphabet.substring(i, i+1))) {
                    break;
                }
                if (j == array.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for (String element : array) {
            if (element.equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newArray = new ArrayList<String>(Arrays.asList(array));
        newArray.remove(valueToRemove);
        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<String>(Arrays.asList(array));
        for (int i = 0; i < newArray.size() - 1; i++) {
            if (newArray.get(i).equals(newArray.get(i+1))) {
                newArray.remove(i);
                i--;
            }
        }
        return newArray.toArray(new String[newArray.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> copyArray = new ArrayList<String>(Arrays.asList(array));
        ArrayList<String> packedArray = new ArrayList<String>();
        ArrayList<String> memoryStack = new ArrayList<String>();
        memoryStack.add(copyArray.get(0)); // adds first string in newArray to the memory stack so the for loop can compare
        String addMeUp = copyArray.get(0);

        for (int i = 1; i < copyArray.size(); i++) {
            if (copyArray.get(i).equals(memoryStack.get(memoryStack.size()-1))) {
                addMeUp += copyArray.get(i);
            }
            else {
                packedArray.add(addMeUp);
                addMeUp = copyArray.get(i);
                memoryStack.add(copyArray.get(i));
            }
        }
        packedArray.add(addMeUp);
        System.out.println(packedArray);
        return packedArray.toArray(new String[packedArray.size()]);
    }


}
