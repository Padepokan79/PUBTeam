/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasarray;

/**
 *
 * @author ulil
 */
public class TugasArray {

    static void printArr1(int arr1[]){
        System.out.println("Isi dari arr : ");
        for(int b=0;b<arr1.length;b++){
            System.out.println(arr1[b]);
        }
    }
    static void Nomor1(int arr1[]){
        float jum=0;
        for(int a=0;a<arr1.length;a++){
            jum+=arr1[a];
        }
        System.out.println("Jumlah arr1 : "+jum+"\nRata-rata arr1 : "+(jum/arr1.length));
    }
    
    static void Nomor2(int arr1[],int bil){
        int st=0;
        for(int a=0;a<arr1.length;a++){
            if(arr1[a]==bil){
                st=1;
                break;
            }else{
                st=0;  
            }
        }
        if(st==0){
            System.out.println("Bilangan "+bil+" tidak ada di dalam arr1");
        }else{
            System.out.println("Bilangan "+bil+" ada di dalam arr1");
        }
    }

    static void Nomor3(int arr1[],int bil){
        int a=0;
        for(a=0;a<arr1.length;a++){
            if(arr1[a]==bil){
                break;
            }
        }
        System.out.println("Bilangan "+bil+" berada di index ke - "+a);
    }
    
    static void Nomor4(int arr1[],int nilai, int i){
        arr1[i]=nilai;
        printArr1(arr1);
    }
    
    static void Nomor5(int arr1[],int i){
        int[] tamp=new int[arr1.length-1];
        int x=0;
        for(int a=0;a<arr1.length;a++){
           if(a!=i){
                tamp[x]=arr1[a];
                x++;
            }
        }
        arr1=tamp;
        printArr1(arr1);
    }
    
    static void Nomor6(int arr1[],int nilai, int pos){
        int[] tamp=new int[arr1.length+1];
        for(int a=0;a<arr1.length+1;a++){
            if(a<pos){
                tamp[a]=arr1[a];
            }else if(a>pos){
                tamp[a]=arr1[a-1];
            }else{
                tamp[a]=nilai;
            }
        }
        arr1=tamp;
        printArr1(arr1);
    }
    
    static void Nomor7(int arr1[],int arr2[]){
        arr2=arr1;
    }
    
    static void min(int arr1[]){
        int min=arr1[0];
        for(int a=0;a<arr1.length;a++){
            if(min>arr1[a]){
                min=arr1[a];
            }
        }
        System.out.println("Nilai minimum arr1 : "+min);
    }
    
    static void max(int arr1[]){
        int min=arr1[0];
        for(int a=0;a<arr1.length;a++){
            if(min<arr1[a]){
                min=arr1[a];
            }
        }
        System.out.println("Nilai maximum arr1 : "+min);
    }
    
    static void Nomor10(int arr1[]){
        for(int a=0;a<arr1.length;a++){
            for(int b=a;b<arr1.length;b++){
                if(arr1[a]==arr1[b]&&b>a){
                    System.out.println("nilai duplikasi : "+arr1[b]);
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] arrContohDuplikasi = {25, 25, 56, 15, 36, 49, 77, 18, 29, 49};
        int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] arr2 = new int[10];
        int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        int[] arr4 = new int[10];
        Nomor1(arr1);
        Nomor2(arr1,29);
        Nomor3(arr1,18);
        Nomor4(arr1,20,2); 
        Nomor5(arr1,1);
        Nomor6(arr1,8,3);
        min(arr1);
        max(arr1);
        Nomor10(arr1);
    }
    
}
