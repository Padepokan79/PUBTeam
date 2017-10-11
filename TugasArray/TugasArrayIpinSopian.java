/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.array.ipin.sopian;

import java.util.Scanner;

/**
 *
 * @author Barne's
 */
public class TugasArrayIpinSopian {
    public int averageArray(int arr[]){
        int len=arr.length;
        int temp=0;
        for (int i = 0; i < len; i++) {
            temp+= arr[i];
        }
        return temp/len;
    }
   
    public int searchNumb(int arr[],int x){
        int stat=0;
        for (int i = 0; i < arr.length; i++) {
          if(arr[i]==x){
              stat++;
          }
        }
        return stat;
    }
    
    public int searchIndex(int arr[],int x){
        int stat=0;
        for ( int i=0; i < arr.length; i++) {
            if(arr[i]==x){
              stat=1;
            }
          }
        return stat;
    }
    
    public void printArray(int arr[]){
        for (int val : arr) {
            System.out.print(val+" ");
        }
    }
    
    public void min(int arr[]){
        int tmp=arr[0];
        for (int i = 0; i < arr.length; i++) {
           if(tmp>arr[i])
            tmp=arr[i];
           
            System.out.println("Nilai minimumnya ialah : "+ tmp);
        }
    }
    
    public void max(int arr[]){
        int tmp=arr[0];
        for (int i = 0; i < arr.length; i++) {
           if(tmp<arr[i])
            tmp=arr[i];
           
            System.out.println("Nilai maximumnya ialah : "+ tmp);
        }
    }
    
    public void sort(int arr[]){
        int tmp=arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 10; j++) {
                if(tmp>arr[i]){
                    tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=arr[j];
                }
            }
            
        }
    }
    public static void main(String[] args) {
        int idx=11;
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}; 
        int[] arr2 = new int[10]; 
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79}; 
        int[] arr4 = new int[10]; 
        int[] temp = new int[idx];
        TugasArrayIpinSopian ta=new TugasArrayIpinSopian();
        
        //input keyboard
        Scanner input=new Scanner(System.in);
        int indek,value;
        // changeValue
        /*
        System.out.print("Masukan posisi yang ingin diubah : ");
        indek=input.nextInt();
        System.out.print("Masukan nialai yang ingin diubah : ");
        value=input.nextInt();
        
        arr1[index-1]=value;
        */
        //delete array item
//         System.out.print("Masukan posisi yang ingin disisipkan : ");
//         indek=input.nextInt();
//         int tmp=0;
//         
//         for (int i = indek; i < arr1.length; i++) {
//             if(indek==0)
//                 i=1;
//            arr1[i-1]=arr1[i];
//            arr1[i]=0;
//         }
        
         //add item
        
//        System.out.print("Masukan posisi yang ingin disisipkan : ");
//        indek=input.nextInt();
//        System.out.print("Masukan nilai yang ingin disisipkan : ");
//        value=input.nextInt();
//        int count=0;
//        for (int i = indek-1; i < temp.length; i++) {
//            if(i==indek-1){
//                temp[i]=value;
//                i++;
//            }else{
//                temp[i]=arr1[count];
//                count++;
//            }
//         }
//        arr1=temp;
        
        //copy
//        for (int i = 0; i < arr1.length; i++) {
//            arr2[i]=arr1[i];
//         }
//
        
        //tambah
        for (int i = 0; i < arr1.length; i++) {
           arr4[i]=arr1[i]+arr3[i];
        }
        ta.printArray(arr1);
         
        
    }
    
}
