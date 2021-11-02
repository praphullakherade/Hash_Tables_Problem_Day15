package com.hashtables;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTables {

    public static void main(String[] args) {
        System.out.println("Welcome to Hash Tables Problem");
        Operation operation = new Operation();

        String sentence ="Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] string=sentence.toLowerCase().split(" ");

        int noOfSlotes = 10;

        Object listOfObj[] = new Object[noOfSlotes];

        for (int i = 0; i < noOfSlotes; i++) {
            listOfObj[i] = new ArrayList<Integer>();
        }

        System.out.println(Arrays.toString(string));
        int count=0;
        for (int i = 0; i < string.length; i++) {
            int key = string[i].hashCode() % noOfSlotes;
            if(key >0) {
                String str2 = string[i];
                for (int j = 0; j < string.length; j++) {
                    if (str2.equals(string[j]))
                        count++;
                }
                str2=str2+"::"+count;
                operation.slotData(str2, listOfObj[key]);
                count=0;
            }
        }

        for (int i = 0; i < listOfObj.length; i++) {
            operation.showSlotedData(listOfObj[i], string[i].hashCode()%10);
        }
    }
}
