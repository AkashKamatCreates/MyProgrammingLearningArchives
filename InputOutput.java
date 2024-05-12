package org.example;

import java.util.*;

public class InputOutput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        while(t-->0){
            String[] inputs = in.nextLine().split(" ");
            ArrayList<Integer> list = new ArrayList<>();

            for(String element:inputs){
                list.add(Integer.parseInt(element));
            }

            //display elements of the list:
            for(int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
        }


        System.out.println();

        /**
         * String.format("%.2f", floatvariablename);
         * or
         * System.out.printf("%.2f", floatvariablename);
         * both will round off the original float variable to 2 decimal places
         *
         */

        float a = 123.126f;
        float b = Float.parseFloat(String.format("%.2f", a));
        System.out.println("original: "+a+" \nrounded off:"+b);
        System.out.println(String.format("%.2f", a));



        /**
         * For integers:
         *
         * Integer.parseInt(String s) - Parses the string argument as a signed decimal integer.
         * Long.parseLong(String s) - Parses the string argument as a signed decimal long.
         *
         * For floating-point numbers:
         *
         * Float.parseFloat(String s) - Parses the string argument as a float.
         * Double.parseDouble(String s) - Parses the string argument as a double.
         *
         * For other types:
         *
         * Boolean.parseBoolean(String s) - Parses the string argument as a boolean.
         * Byte.parseByte(String s) - Parses the string argument as a byte.
         * Short.parseShort(String s) - Parses the string argument as a signed short.
         */

    }
}
