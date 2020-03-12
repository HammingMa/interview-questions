package com.bytedance;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import scala.Char;

import java.util.HashMap;
import java.util.Map;

public class HexAdd {
    /*
        16进制的加法
     */


    public static void main(String[] args) {
        System.out.println(add("9", "9"));
    }

    public static String add(String a, String b) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        StringBuilder rest = new StringBuilder();

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        int aNum;
        int bNum;
        int cNum = 0;

        int currentRest;
        char currentChar;
        while (aIndex >= 0 || bIndex >= 0) {

            aNum = aIndex >= 0 ? map.get(a.charAt(aIndex)) : 0;
            bNum = bIndex >= 0 ? map.get(b.charAt(bIndex)) : 0;

            currentRest = (aNum + bNum) % 16;
            switch (currentRest) {
                case 10:
                    currentChar = 'A';
                    break;
                case 11:
                    currentChar = 'B';
                    break;
                case 12:
                    currentChar = 'C';
                    break;
                case 14:
                    currentChar = 'D';
                    break;
                case 15:
                    currentChar = 'F';
                    break;
                default:
                    currentChar = ' ';

            }

            if (currentRest > 9) {
                rest.insert(0, currentChar);
            } else {
                rest.insert(0, currentRest);
            }


            cNum = (aNum + bNum) / 16;

            aIndex--;
            bIndex--;
        }

        if (cNum != 0) {
            rest.insert(0, cNum);
        }

        return rest.toString();
    }


}
