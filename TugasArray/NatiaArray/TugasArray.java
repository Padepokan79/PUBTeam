/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasarray;

import static java.lang.Double.sum;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Natia
 */
public class TugasArray {
    
    public static void main(String[] args) {
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        double sum = 0, avg = 0;
        int bil, ind;
        
        // no 1
	for(int a=0; a<arr1.length; a++){
		sum = sum + arr1[a];
		avg= sum/arr1.length;
	}
	System.out.println("Jumlah dari Arr1 adalah " + sum + " dan Rata-rata nya adalah " + avg);
        
        //no 2 
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan bilangan yang ingin dicari = ");
        bil=input.nextInt();
        int status=0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]==bil){
                status = 1;
                break;
            }    
	}
        if(status==1){
            System.out.println("Bilangan ada..");
        }else{
            System.out.println("Bilangan tidak ada..");
        }
        
        //no 3
        
        Scanner in = new Scanner(System.in);
        System.out.print("Masukan bilangan yang ingin dicari = ");
        bil=in.nextInt();
        int tamp = 0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]==bil){
                tamp=i;
                break;
            }
        }
        System.out.println("Bilangan ada di index " + tamp);
        
        //no 4
        
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukan bilangan = ");
        bil=inp.nextInt();
        Scanner inpt = new Scanner(System.in);
        System.out.print("Masukan index = ");
        ind=inpt.nextInt();
        for(int i=0; i<arr1.length; i++){
            if(i==ind){
                   arr1[i] = bil;
                   System.out.print(Arrays.toString(arr1));
            }
        }
        
        //no 5
        Scanner inputan = new Scanner(System.in);
        System.out.print("Masukan index = ");
        bil=inputan.nextInt();
        for(int i=0; i<arr1.length; i++){
            if(bil==i){
                   arr1[bil] = arr1[i+1];
                   System.out.print(Arrays.toString(arr1));
            }
        }
        
        //no 6
        
        int max = 0;
        int min = 1000;
        for (int a = 0; a < arr1.length; a++) {
            if (arr1[a] > max) {
                max = arr1[a];
             } else if (arr1[a] < min) {
                min = arr1[a];
             }
        }
        System.out.println("Nilai Maksimum : " + max);
        System.out.println("Nilai Minimun  : " + min);
 }
}
