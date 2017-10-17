/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytugas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jejen
 */
public class ArrayTugas {

    public int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
    public int[] arr2 = new int[10];
    public int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
    public int[] arr4 = new int[10];
    boolean status = false;

    public double getAvg(int arr[]) {
        //no1.Hitung jumlah dan rata-rata
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        avg = sum / arr.length;
        return avg;
    }

    public boolean cekData(int value, int arr[]) {
        //no2.Apakah suatu bilangan ada di arr1 atau tidak?
        status = false;
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public int getPosisi(int value, int arr[]) {
        //no3.Suatu bilangan ada di-posisi/index ke berapa di arr1?
        status = false;
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public int getIndex(int value, int arr[]) {
        //no3.Suatu bilangan ada di-posisi/index ke berapa di arr1?
        status = false;
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public int[] changeArrayWithPosition(int value, int posisi, int arr[]) {
        //no4.Terima nilai dan ubah nilai u/ suatu posisi pada arr1
        arr[posisi - 1] = value;
        return arr;
    }

    public int[] deleteArrayWithPosition(int posisi, int arr[]) {
        //no5.Hapus suatu posisi dari arr1
        return arr;
    }

    public int[] shiftArrayWithPosition(int value, int posisi, int arr[]) {
        //no6.Sisip suatu bilangan pada posisi tertentu pada arr1
        return arr;
    }

    public void copyArray(int arr1[], int arr2[]) {
        //no7.Copy isi arr1 ke arr2
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);
    }

    public int getMin(int arr[]) {
        //no8.Tampilkan nilai minimum arr1
        int MIN = arr[0];
        for (int c = 0; c < arr.length; c++) {
            MIN = arr[c] < MIN ? arr[c] : MIN;
        }
        return MIN;
    }

    public int getMax(int arr[]) {
        //no9.Tampilkan nilai Maximum arr1
        int MAX = arr[0];
        for (int c = 1; c < arr.length; c++) {
            MAX = arr[c] > MAX ? arr[c] : MAX;
        }
        return MAX;
    }

    public void viewDuplicateInArray(int arr[]) {
        //no10. Tampilkan bilangan2 yang duplikasi pada arr1

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == (arr[j])) {
                    System.out.println("found a duplicate in array : " + arr[i]);
                }
            }
        }
    }

    public void viewDuplicateInArray2(int arr1[], int arr2[]) {
        //no11. Tampilkan bilangan2 yang sama2 ada di arr1 dan arr3
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println("found a duplicate in array : " + arr1[i]);
                }
            }
        }
    }

    public int[] sumWithIndexTwoArray(int arr1[], int arr2[]) {
        //no12.Jumlahkan elemen arr1 dan arr3 simpan pada arr4
        for (int i = 0; i < arr1.length; i++) {
            arr4[i] = arr1[i] + arr2[i];
        }
        return arr4;
    }

    public int[] swichTwoPosition(int arr[]) {
        //no13.Tukar nilai antara dua posisi pada arr1
        int[] arrTamp = new int[arr.length];
        for (int i = 0; i < arr.length; i = i + 2) {
            arrTamp[i] = arr[i + 1];
            arrTamp[i + 1] = arr[i];
        }
        return arrTamp;
    }

    public int[] shortingArray(int arr[]) {
        //no14.Mengurutkan nilai pada arr1
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        return arr;
    }

    public void PrintArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws IOException {

//        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Masukan Angka : ");
//        int angka = Integer.parseInt(dataIn.readLine());
//        System.out.print("Masukan Posisi : ");
//        int posisi = Integer.parseInt(dataIn.readLine());
        ArrayTugas arr = new ArrayTugas();
        //no1
        System.out.println("AVERAGE : " + arr.getAvg(arr.arr1));
        //no2
        System.out.println(arr.cekData(77, arr.arr1));
        //no3
        System.out.println("POSISI : " + arr.getPosisi(77, arr.arr1));
        //no4
        arr.arr1 = arr.changeArrayWithPosition(20, 1, arr.arr1);
        //no7
        arr.copyArray(arr.arr1, arr.arr2);
        //no8
        System.out.println("MAXIMAL : " + arr.getMax(arr.arr1));
        //no9
        System.out.println("MINIMAL : " + arr.getMin(arr.arr1));
        //no10
        arr.PrintArr(arr.arr1);
        arr.viewDuplicateInArray(arr.arr1);
        //no11
        arr.PrintArr(arr.arr1);
        arr.PrintArr(arr.arr3);
        arr.viewDuplicateInArray2(arr.arr1, arr.arr3);
        //no12
        arr.arr4 = arr.sumWithIndexTwoArray(arr.arr1, arr.arr2);
        arr.PrintArr(arr.arr4);
        //no13
        arr.arr4 = arr.swichTwoPosition(arr.arr4);
        arr.PrintArr(arr.arr4);
        //no14
        arr.arr4 = arr.shortingArray(arr.arr4);
        arr.PrintArr(arr.arr4);

//        arr.PrintArr(arr.arr1);
//        arr.PrintArr(arr.arr2);
//        arr.PrintArr(arr.arr3);
//        arr.PrintArr(arr.arr4);
    }

}
