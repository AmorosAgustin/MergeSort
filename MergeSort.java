//Importing what I need to use random numbers

import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
    public static void main(String[] args) {

//I generate an array with length between 6 and 10
        int n = ThreadLocalRandom.current().nextInt(6, 10);
        int[] numList = new int[n];

//I fill my array with random numbers between -100 and 100
        for (int i = 0; i < n; i++) {
            numList[i] = ThreadLocalRandom.current().nextInt(-100, 99 + 1);

        }

        System.out.println("The original array contains the following " + n + " elements:");
        for (int b : numList) {
            System.out.println(b);
        }

        sort(numList, 0, n - 1);

        System.out.println("After using mergesort we get: ");
        for (int b : numList) {
            System.out.println(b);
        }


    }

    public static void merge(int[] numList, int a, int h, int b) {
        //I create two arrays in which i'll put the halves of my original array with their respective lenghts
        int lengthL = h - a + 1;
        int lengthR = b - h;


        int[] arrayL = new int[lengthL];
        int[] arrayR = new int[lengthR];

        //I fill the arrays with the halves of the original
        for (int i = 0; i < lengthL; i++)
            arrayL[i] = numList[a + i];
        for (int r = 0; r < lengthR; r++)
            arrayR[r] = numList[h + 1 + r];

        //Here I compare both halves and start putting them in the original in order from lowest to highest
        int j = 0;
        int k = 0;
        int current = a;
        while (j < lengthL && k < lengthR) {
            if (arrayL[j] < arrayR[k]) {
                numList[current] = arrayL[j];
                j++;

            } else {
                numList[current] = arrayR[k];
                k++;

            }
            current++;
        }
        //Copy remaining elements of left and right arrays

        while (j < lengthL) {
            numList[current] = arrayL[j];
            j++;
            current++;
        }
        while (k < lengthR) {
            numList[current] = arrayR[k];
            k++;
            current++;
        }


    }

    public static void sort(int[] numList, int a, int b) {

        //I check that the start and the end aren't the same position of the original array
        if (a < b) {
            int half = (a + (b - 1)) / 2;

            sort(numList, a, half); //This recursion ends when the size is too small to keep comparing.
            sort(numList, half + 1, b);

            merge(numList, a, half, b);//Here is where we order the original array from lowest to highest
        }

    }
}
