/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainingarray;

import java.util.Scanner;

/**
 *
 * @author Yunita Niken
 */
public class TrainingArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        int jumlah = 0;
        int nilaiRata=0;
        int panjang=0;
        int tamp=0;
        int min=0;
        int max=0;
//1. Hitung jumlah dan rata-rata dari arr1 di atas
        
  /*for (int i = 0; i < arr1.length; i++){
   panjang=arr1.length;
   jumlah = jumlah + arr1[i];
   nilaiRata = jumlah / panjang;
  }
   System.out.println("Nilai rata-rata = " + "    " + nilaiRata); 
   System.out.println("Jumlah  = " + "    " + jumlah); */
/*2. Apakah suatu bilangan ada di arr1 atau tidak?
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan inputan bilangan :");
         int inputan=scan.nextInt();
        for (int i = 0; i <arr1.length; i++) {
            if (inputan == arr1[i]) {
                 tamp=1;
                 break;
            } 
        }
        
        if (tamp==1) {
            System.out.println( inputan + "there in arr1");
        }else{
            System.out.println("Nilai " + inputan + "nothing in arr1"); 
        }*/
/*3. Suatu bilangan ada di-posisi/index ke berapa di arr1?
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan inputan bilangan yang ada di index :");
         int inputan=scan.nextInt();
         for (int i = 0; i < arr1.length; i++) {
             if (inputan ==arr1[i]) {
                 tamp=i;
                 break;
             }
        }
         System.out.println("inputan berada di index ke "+ tamp);
        
*/
//4. Terima nilai dan ubah nilai u/ suatu posisi pada arr1
    /*    Scanner scan = new Scanner(System.in);
        System.out.println("Masukan inputan bilangan :");
         int inputan=scan.nextInt();
          System.out.println("Masukan index bilangan :");
         int index=scan.nextInt();
         
         for (int i = 0; i <arr1.length; i++) {
            arr1[index]=inputan;
             System.out.println(arr1[i]);
        }*/
       
//5. Hapus suatu posisi dari arr1
     /*   Scanner scan = new Scanner(System.in);
        System.out.println("Inputkan index yang ingin dihapus :");
        int index=scan.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            arr1[index]=arr1[i+1];
            System.out.println(arr1[i]);
        }*/
//6. Sisip suatu bilangan pada posisi tertentu pada arr1
       /*  Scanner scan = new Scanner(System.in); belum beres
        System.out.println("Inputkan index yang ingin ditambahkan :");
        int index=scan.nextInt();
        System.out.println("Inputkan Nilai yang ingin ditambahkan :");
        int inputan=scan.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            arr1[index]=arr1[inputan];
            System.out.println(arr1[i]);
        }*/
//7. Copy isi arr1 ke arr2
      /*  int arrTamp[]={};
        for (int i = 0; i < 10; i++) {
            arr2[i]=arr1[i];
            System.out.println(arr1[i]);
            System.out.println(arr2[i]);
        }*/
//8. Tampilkan nilai minimum arr1
         
        
      /*  for (int i = 0; i < arr1.length; i++) {
           if(arr1[i] < min)
            
               min=arr1[i];
        } 
        System.out.println("nilai minimum : " + min);*/
       
/*9. Tampilkan nilai maksimum arr1
            if(arr1[i] > max)
            
               max=arr1[i];
        } 
        System.out.println("nilai maximum : " + max);
10. Tampilkan bilangan2 yang duplikasi pada arr1
        for (int i = 0; i < arr1.length; i++) { 
  for (int j = i + 1 ; j < arr1.length; j++) {
     if (arr1[i].equals(arr1[j])) { 
          
     } 
  }
}
11. Tampilkan bilangan2 yang sama2 ada di arr1 dan arr3
12. Jumlahkan elemen arr1 dan arr3 simpan pada arr4
13. Tukar nilai antara dua posisi pada arr1
14. Mengurutkan nilai pada arr1*/
    }
    
}
