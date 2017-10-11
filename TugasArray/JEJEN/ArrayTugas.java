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

    BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

    int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
    int[] arr2 = new int[10];
    int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
    int[] arr4 = new int[10];
    int angka = 0;
    int posisi = 0;
    boolean status = false;

    public void no1() {
        System.out.println("no1.Hitung jumlah dan rata-rata\n");
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }
        avg = sum / arr1.length;
        System.out.println(avg);
    }

    public void no2() throws IOException {
        System.out.println("no2.Apakah suatu bilangan ada di arr1 atau tidak?\n");
        System.out.print("Masukan Angka : ");
        angka = Integer.parseInt(dataIn.readLine());
        status = false;
        for (int i = 0; i < arr1.length; i++) {
            if (angka == arr1[i]) {
                status = true;
            }
        }
        if (status) {
            System.out.println("\nDATA ADA");
        } else {
            System.out.println("\nDATA TIDAK ADA");
        }
    }

    public void no3() throws IOException {
        System.out.println("no3.Suatu bilangan ada di-posisi/index ke berapa di arr1?\n");
        System.out.print("Masukan Angka : ");
        angka = Integer.parseInt(dataIn.readLine());
        status = false;
        for (int i = 0; i < arr1.length; i++) {
            if (angka == arr1[i]) {
                status = true;
                angka = i;
                break;
            }
        }

        if (status == true) {
            angka += 1;
            System.out.print("Posisi : " + angka);
            angka -= 1;
            System.out.print("\nIndex  : " + angka);
        } else {
            System.out.println("\nDATA TIDAK ADA");
        }
    }

    public void no4() throws IOException {
        System.out.println("no4.Terima nilai dan ubah nilai u/ suatu posisi pada arr1");
        System.out.print("Masukan Angka : ");
        angka = Integer.parseInt(dataIn.readLine());
        System.out.print("Masukan Posisi : ");
        posisi = Integer.parseInt(dataIn.readLine());
        arr1[posisi - 1] = angka;
    }

    public void no5() throws IOException {
        System.out.println("no5. Hapus suatu posisi dari arr1");
        System.out.print("Masukan Posisi : ");
        posisi = Integer.parseInt(dataIn.readLine());

    }

    public void no6() throws IOException {
        System.out.println("no6.Sisip suatu bilangan pada posisi tertentu pada arr1");
        System.out.print("Masukan Angka : ");
        angka = Integer.parseInt(dataIn.readLine());
        System.out.print("Masukan Posisi : ");
        posisi = Integer.parseInt(dataIn.readLine());
    }

    public void no7() {
         System.out.println("no7. Copy isi arr1 ke arr2");
         for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    public void no8() {
        System.out.println("no8.Tampilkan nilai minimum arr1");
        int MIN = arr1[0];
        for (int c = 0; c < 10; c++) {
            if (arr1[c] < MIN) {
                MIN = arr1[c];
            }
        }
        System.out.println("Nilai Minimum = "+MIN);

    }

    public void no9() {
        System.out.println("no9.Tampilkan nilai Maximum arr1");
        int MAX = arr1[0];
          for (int c = 1; c < arr1.length; c++) {
            if (arr1[c] > MAX) {
                MAX = arr1[c];
            }
        }
          System.out.println("Nilai Maximum = "+MAX);
    }
    
    public void no10(){
        System.out.println("no10. Tampilkan bilangan2 yang duplikasi pada arr1\n");
        
        for (int i = 0; i < arr1.length; i++) {
             arr2[i] = arr1[i];
            
        }
    }
    
    public void cetakArr1() {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");

        }
    }

    public static void main(String[] args) throws IOException {

        ArrayTugas arr = new ArrayTugas();
        System.out.println("TUGAS ARRAY");
//        arr.no1();
//        arr.no2();
//        arr.no3();
//        arr.no4();
//        arr.no8();
//        arr.no9();
        
        
        arr.cetakArr1();

    }

}
