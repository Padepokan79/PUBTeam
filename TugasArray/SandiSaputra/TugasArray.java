/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasarray;

import java.util.Scanner;

/**
 *
 * @author CBRL-Kuroky
 */
public class TugasArray {
 
    int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
    int[] arr2 = new int[11];
    int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
    int[] arr4 = new int[10];
    
    //no1
    public void jumRata(){
        int jum = 0;
        for (int i = 0; i < arr1.length; i++) {
            jum = jum + arr1[i];
        }
        System.out.println("Jumlah data arr1 adalah : "+jum);
        System.out.println("Rata - rata arr1 adalah : "+jum/arr1.length);
    }
    
    //no2
    public void cekData(){
        int data,st=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan data yang akan di cari : ");
        data = in.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]==data){
                st=1;
                break;
            }
        }
        if (st==1){
            System.out.println("Data ada dalam array");
        }else{
            System.out.println("Data tidak ada dalam array");
        }
    }
    
    //no3
    public void cekDataByIndex(){
        int bil,step=0;
        int[] tamp = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan bilangan yang akan di cari : ");
        bil = in.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]==bil){
                tamp[step]=i;
                step++;
            }
        }
        
        if (step==0){
            System.out.println("Bilangan tidak ada dalam array");
        }else{
            System.out.print("Bilangan ada dalam array di index : ");
            for (int a=0; a<step; a++){
                System.out.print(tamp[a]+" ");
            }        
        }
        
    }
    
    //no4
    public void gantiData(){
        int data, index, st=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Data array sebelum : ");
        for (int a = 0; a < arr1.length; a++) {
            System.out.print(arr1[a]+" ");
        }
        System.out.print("\nMasukkan data baru : ");
        data = in.nextInt();
        System.out.print("Masukkan index array yang akan diganti : ");
        index = in.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            if (i==index){
                arr1[i]=data;
            }
        }
        if (st==0){
            System.out.println("Invalid index");
        }
        System.out.print("Data array terbaru : ");
        for (int b = 0; b < arr1.length; b++) {
            System.out.print(arr1[b]+" ");
        }
        
    }
    
    //no5
    public void hapusPosisi(){
        int pos;
        Scanner in = new Scanner(System.in);
        System.out.print("Data array sebelum : ");
        for (int a = 0; a < arr1.length; a++) {
            System.out.print(arr1[a]+" ");
        }
        System.out.print("\nMasukkan posisi yang akan dihapus : ");
        pos = in.nextInt();
        
        if (pos==arr1.length-1){
            arr1[pos]=-1;
        }else{
            for (int i = pos; i < arr1.length-1; i++) {
                arr1[i]=arr1[i+1];
            }
            arr1[arr1.length-1]=-1;
        }
        
        System.out.print("Data array terbaru : ");
        for (int b = 0; b < arr1.length; b++) {
            if (arr1[b]!=-1){
                System.out.print(arr1[b]+" ");
            }
        }
    }
    
    //no6
    public void sisipBilangan(){
        int data, pos, tamp=0;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Data array sebelum : ");
        for (int a = 0; a < arr1.length; a++) {
            System.out.print(arr1[a]+" ");
        }
        
        System.out.print("\nMasukkan data yang akan disisipkan : ");
        data = in.nextInt();
        System.out.print("Masukkan posisi : ");
        pos = in.nextInt();
        
        for (int i = 0; i < arr2.length-1; i++) {
            if (i==pos){
                arr2[i]=data;
            }else{
                if (i>pos){
                    arr2[i]=arr1[i-1];
                }else{
                    arr2[i]=arr1[i];
                }
            }
        }
        
        System.out.print("Data array terbaru : ");
        for (int b = 0; b < arr2.length; b++) {
            if (arr2[b]!=-1){
                System.out.print(arr2[b]+" ");
            }
        }
    }
    
    public static void main(String[] args) {
        TugasArray ta = new TugasArray();
        int pilihan;
        System.out.println("--- Tugas Array ---");
        System.out.println("1. Menghitung jumlah dan rata - rata array");
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan pilihan : ");
        pilihan = in.nextInt();
        if (pilihan==1){
            ta.jumRata();
        }else if (pilihan==2){
            ta.cekData();
        }else if (pilihan==3){
            ta.cekDataByIndex();
        }else if (pilihan==4){
            ta.gantiData();
        }else if (pilihan==5){
            ta.hapusPosisi();
        }else if (pilihan==6){
            ta.sisipBilangan();
        }
    }
    
    
    
}
