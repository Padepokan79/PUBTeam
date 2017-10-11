/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajararray;

import static java.sql.JDBCType.NULL;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class BelajarArray {

    /**
     * @param args the command line arguments
     */
        
        
    static void jumlahDanRataRata(int arr[]){
        float jumlah=0;
        for (int i = 0; i < arr.length; i++) {
            jumlah=jumlah+arr[i];
        }
        System.out.println("jumlah: "+jumlah);
        float avg=jumlah/arr.length;
        System.out.println("rata-rata: "+avg);
    }
    
    static int cekKeberadaanData(int arr[],int data){
        int st=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==data){
                st=1;
                break;
            }
        }
        if(st==0){
            System.out.println("data "+data+" tidak ditemukan di dalam array");
            return 0;
        }else{
            System.out.println("data "+data+" ditemukan di dalam array");
            return 1;
        }
    }
    
    static int cekDataDiIndex(int arr[],int data){
        int st=0, index=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==data){
                st=1;
                index=i;
                break;
            }
        }
        if(st==0){
            System.out.println("data "+data+" tidak ditemukan di dalam array");
        }else{
            System.out.println("data "+data+" ditemukan di dalam array pada index ke "+index);
            
        }
        return index;
    }
    
    static void ubahNilaiDalamArray(int arr[], int data, int index){
        arr[index]=data;
        
    }
    
    static void hapusSatuPosisi(int arr[],int posisi){
        if(posisi>arr.length||posisi<1){
            System.out.println("posisi tidak valid");
        }else{
            int index=posisi-1;
            for (int i = index; i < arr.length; i++) {
                if(i+1<arr.length){
                    arr[i]=arr[i+1];
                }
            }
            int[] arrBaru=new int[arr.length-1];
            arrBaru=arr;
            
        }
    }
    
    static void print(int arr[]){
        for (int b : arr) {
            System.out.println(b);
        }
    
    }
    
    static void tambahDataDiPosisi(int arr[], int data, int posisi){
        
    }
    static void copyArr1keArr2(int arr1[], int arr2[]){
        for (int i = 0; i < arr1.length; i++) {
            arr2[i]=arr1[i];
        }
    }
    
    static void nilaiMinimum(int arr[]){
        int min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println(min);
    }
    
    static void nilaiMaksimum(int arr[]){
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
    
    static void duplikasiInArray(int arr[]){
        int hitung=0;
        for (int i = 0; i < arr.length; i++) {
            
        }
    }
    
    static void duplikasiInOtherArray(int arr[]){
        
    }
    
    static int cekBanyakIsiArray(int arr[]){
        int hitung=0;
        for (int i = 0; i<arr.length; i++) {
            if(arr[i]!='\0'){
                hitung++;
            }
        }
        return hitung;
    }
    
    static void panjangArr4(int arr1[],int arr3[]){
        
    }
    
    static void urutkan(int arr[]){
        int tamp=0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    tamp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tamp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
//        jumlahDanRataRata(arr1);
//        cekKeberadaanData(arr1,5);
//        cekDataDiIndex(arr1,15);
//        Scanner sc=new Scanner(System.in);
//        int dataLemparan=sc.nextInt();
//        int index=sc.nextInt();
//        ubahNilaiDalamArray(arr1,dataLemparan,index);
        //hapusSatuPosisi(arr1,5);
        //nilaiMaksimum(arr1);
        //print(arr1);
        urutkan(arr1);
        print(arr1);
        
    }

}
