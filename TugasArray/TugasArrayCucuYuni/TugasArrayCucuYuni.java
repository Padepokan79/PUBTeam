/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasarraycucuyuni;

import java.util.Scanner;

/**
 *
 * @author Cucu Yuni
 */
public class TugasArrayCucuYuni {

    /**
     * @param args the command line arguments
     */
    public void average(){
        //System.out.println("Test");
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        int temp = 0;
        int avg = 0;
       
        //soal no. 1
        for (int i = 0; i < arr1.length; i++) {
            temp = temp + arr1[i];
            avg = temp/arr1.length;
        }
        System.out.println("Rata - rata arr1 adalah : " + avg);
        
    }
    //no 2
    public void search(){
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        int temp = 0;
        
        System.out.print("Masukkan Angka yang akan di cek : ");
        Scanner inputan= new Scanner(System.in);
        temp= inputan.nextInt();
        
       
    
        for (int i = 0; i < arr1.length; i++) {
            if(temp == arr1[i]){
                System.out.println("Angka ada dalam array "); 
                break;
            } else{
                System.out.println("Angka tidak ditemukan");
               
            }
           
        } 
      
    }
    public void cekIndex(){
         int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        int temp = 0;
        
        System.out.print("Masukkan Angka yang akan di cek : ");
        Scanner inputan= new Scanner(System.in);
        temp= inputan.nextInt();
        
       
    
        for (int i = 0; i < arr1.length; i++) {
           if(arr1[i] == temp){
               System.out.println("Angka ada di array index ke " + i);
           }
        } 
    }
    public void change(){
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        int temp = 0;
        int index =0;
       
        System.out.print("Masukkan Angka baru : ");
        Scanner inputan= new Scanner(System.in);
        temp= inputan.nextInt();
        System.out.print("Index ke berapa : ");
        index= inputan.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            if(i == index){
                arr1[i] = temp;
            }
        }
        System.out.println("Array baru : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
            
        }
       
        
    }
    public void delete(){
   int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
       
        int index =0;
       
        
        Scanner inputan= new Scanner(System.in);
        System.out.print("Index ke berapa yang akan di hapus : ");
        index= inputan.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            if(i == index){
              
            }
        }
        System.out.println("Array baru : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
            
        }        

}
    
    public void showMinandMax(){
    int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        int min = arr1[0];
        int maks = arr1[0];
        int nilai;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < min){
                min = arr1[i];
            }
            if(arr1[i] > maks){
                maks = arr1[i];
            }
   
   }
        System.out.println("Nilai Minimum di Array adalah " + min);
        System.out.println("Nilai Maximum di Array adalah " + maks);
       
       
    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       TugasArrayCucuYuni tugas = new TugasArrayCucuYuni();
       //no.1
       tugas.average();
       //no.2
       tugas.search();
       //no.3
       tugas.cekIndex();
       //no.4
       tugas.change();
       //no.5 blm selesai
       tugas.delete();
       //no.6 dan 7
       tugas.showMinandMax();
       
        
    }
    
}
