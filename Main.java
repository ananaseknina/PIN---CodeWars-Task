package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static int[] returnPossibleDigits(int x){
            if(x==1) {
                int[] possibleDigits1 = {2,4};
                return possibleDigits1;
            }
            if(x==2) {
                int[] possibleDigits2 = {1,3,5};
                return possibleDigits2;
            }
            if(x==3){
                int[] possibleDigits3 = {2,6};
                return possibleDigits3;
            }
            if(x==4){
                int[] possibleDigits4 = {1,5,7};
                return possibleDigits4;
            }
            if(x==5){
                int[] possibleDigits5 = {2,4,6,8};
                return possibleDigits5;
            }
            if(x==6){
                int[] possibleDigits6 = {3,5,9};
                return possibleDigits6;
            }
            if(x==7){
                int[] possibleDigits7 = {4,8};
                return possibleDigits7;
            }
            if(x==8){
                int[] possibleDigits8 = {7,9,5};
                return possibleDigits8;
            }
            if(x==9){
                int[] possibleDigits9 = {6,8};
                return possibleDigits9;
            }
            if(x==0){
                int[] possibleDigits0 = {8};
                return possibleDigits0;
            }
            return null;
        }
        public static void display (ArrayList<int[]> list){
            for(int[] e:list){
                System.out.print(Arrays.toString(e)+" ");
            }
        }
        public static int[] stringToArray(String pin){
            int[] pinConverted = new int[pin.length()];
            for(int i =0;i<pin.length();i++){
                pinConverted[i] = Integer.parseInt(pin.charAt(i)+"");
            }
            return pinConverted;
        }

        public static ArrayList<int[]> generateVariants(int[] initialPin){
            //do as many times as many digits an initial input-pin
            ArrayList<int[]> variants = new ArrayList<int[]>();
           // System.out.println(Arrays.toString(initialPin));
            variants.add(initialPin);
           // display(variants);
            for(int i =0;i<initialPin.length;i++){
                int[] possibleDigits = returnPossibleDigits(variants.get(0)[i]);
                int numberIterations = variants.size();
                for(int j =0;j<numberIterations;j++){
                    for(int e: possibleDigits){
                        int[] toBeAdded = variants.get(j).clone();
                        toBeAdded[i] = e;
                        variants.add(toBeAdded);
                       // System.out.println("Added"+Arrays.toString(toBeAdded));
                       // display(variants);
                    }
                }
            }
            return variants;
        }

        public static ArrayList<String> convertToStringList(ArrayList<int[]> input){
          ArrayList<String> pins = new ArrayList<String>();
          for(int[] e:input){
              String converted="";
              for(int i =0;i<e.length;i++){
                  converted+=e[i];
              }
              pins.add(converted);
          }
          return pins;
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println(Arrays.toString(returnPossibleDigits(4)));
        System.out.println("Provide a PIN: ");
        Scanner sc = new Scanner(System.in);
        String pin = sc.nextLine();
        int[] pinAsArray = stringToArray(pin);
        ArrayList<int[]> pinsArrays= generateVariants(pinAsArray);
        ArrayList<String> pinsStrings = convertToStringList(pinsArrays);
        System.out.println(pinsStrings);

    }
}
