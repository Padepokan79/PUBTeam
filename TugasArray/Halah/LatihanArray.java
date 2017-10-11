/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanarray;

import java.util.Scanner;

/**
 *
 * @author Halah
 */
public class LatihanArray {

    /**
     * @param args the command line arguments
     */
            int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
            int[] arr2 = new int[10];
            int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
            int[] arr4 = new int[10];
    ///////////////////////////////////NO 1        
    public void rata(){
            int rata=0;
            int tmp;
                for(int i=0; i<arr1.length;i++){
                    rata=rata+arr1[i]; 
                }
            tmp=rata/arr1.length;
            System.out.println(tmp);
    }
    
    ///////////////////NO 2
    public void cekAda(){
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan angka : ");
            int angka = input.nextInt(); 
                for(int i=0; i<arr1.length;i++){
                    if(angka==arr1[i]){
                        System.out.println("Angka "+ angka + " ada dalam Array :) :)");
                    }
                }
    }
    
    //////////////////////////NO 3
    public void posisi(){
         Scanner input = new Scanner(System.in);
         System.out.print("Masukkan angka : ");
         int angka = input.nextInt(); 
            for(int i=0; i<arr1.length;i++){
                if(angka==arr1[i]){
                    System.out.println("Posisi angka "+ angka + " ada di Index "+ i);
                }
            }
    }
    
    /////////////////////////////NO 4
    public void ubah(){
         Scanner input = new Scanner(System.in);
         System.out.println("Data yang ada dalam array ");
            for(int i=0; i<arr1.length;i++){
                System.out.print(arr1[i] + " ");
            }
         System.out.print("\nMasukkan posisi : ");
         int posisi = input.nextInt(); 
         System.out.print("Masukkan angka : ");
         int angka = input.nextInt(); 
            for(int i=0; i<arr1.length;i++){
                if(posisi==i){
                    arr1[i]=angka;
                    System.out.println("Posisi index "+ posisi + " diubah menjadi "+ angka);
                }
            }
            System.out.println("Data yang ada dalam array setelah diubah ");
            for(int i=0; i<arr1.length;i++){
                System.out.print(arr1[i] + " ");
            }
    }
    
    ///////////////////////////NO 5
    public void hapus(){
        
    }
    
    ///////////////////////////NO 6
    public void sisip(){
        
    }
    
    /////////////////////////NO 7
    public void copy(){
        
    }
    
    ///////////////////////////NO 8
    public void minim(){
//        int min = 0;
//        //for(int x=0; x<arr1.length; x++){
//            for(int y=0; y<arr1.length; y++){
//                if(arr1[y]>arr1[y+1]){
//                    min=arr1[y+1];
//                }else{
//                    min=arr1[y];
//                }
//            }
//        //}
//        System.out.println(min);
    }
    
    ///////////////////////NO 9
    public void maxim(){
        
    }
    
    ////////////////////////NO 10
    public void duplikasi(){
        
    }
    
    ///////////////////////////NO 11
    public void sama(){
        System.out.println("Data Array 1");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+ " ");
        }
        
        System.out.println("\nData Array 3");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr3[i]+ " ");
        }
        System.out.println("Data yang sama ");
        for (int i=0;i<arr1.length;i++){
            if(arr1[i]==arr3[i])
            System.out.println(arr1[i]+ " ");
        }
    }
    
    /////////////////////////NO 12
    public void jmlElemen(){
        for (int i=0;i<arr1.length;i++){
            arr4[i]=arr1[i]+arr3[i];
        }
        System.out.println("Data Array 4 ");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr4[i]+ " ");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LatihanArray ar= new LatihanArray();
//        ar.rata();
//        ar.cekAda();
//        ar.posisi();
//          ar.ubah();
//          ar.minim();
//        ar.jmlElemen();
        ar.sama();
        }
        
}
