/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sou
 */
public class Rata2Arr1 {

    Double avg;
    Double sum;

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    Double avgArr1(Integer[] arr) {
        avg=0.0;
        sum=0.0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        avg=sum/arr.length;
        return avg;
    }
    String cekIsExist(Integer a,Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(a==arr[i]){
                return "Angka "+a+" Ada di array";
            }
        }
        return "Angka "+a+" Tidak Ada di array";
    }
    void posisiArr1(Integer a,Integer[] arr){
        Integer[] index = new Integer[10];
        Integer counter=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==a){
                index[counter]=i;
                counter++;
            }
        }
        for (int i = 0; i < counter; i++) {
            System.out.println("Angka "+a+" Index ke "+index[i]);
        }
        if(counter ==0 ){
            System.out.println("Tidak di temukan");
        }
    }
    
    void ubahIsiArray(Integer index,Integer angkaBaru,Integer [] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i==index){
                arr[index]=angkaBaru;
                break;
            }
        }
        return;
    }
    Integer maxArr1(Integer[] arr){
        Integer maxA=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxA){
                maxA=arr[i];
            }
        }
        return maxA;
    }
    
    Integer minArr1(Integer[] arr){
        Integer minA=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<minA){
                minA=arr[i];
            }
        }
        return minA;
    }
    
    
    void hapusPosisiArr1(Integer index,Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i==index){
                for (int j = i; j < arr.length-1; j++) {
                    arr[j]=arr[j+1];
                }
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
    void copyArr1Arr2(Integer []arr1,Integer []arr2){
        for (int i = 0; i < arr1.length; i++) {
            arr2[i]=arr1[i];
        }
    }
    
    void cetakDuplikasi(Integer [] arr){
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= 77; j++) {
                if(arr[i]==j){
                    System.out.println(arr[i]+" ");
                }else{
                }
            }
        }
    }
    
    void sortingArr(Integer[] arr){
         int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    void jumlahArr1Arr3(Integer[]arr1,Integer[]arr3,Integer[]arr4){
        for (int i = 0; i < arr1.length; i++) {
            arr4[i]=arr3[i]+arr1[i];
        }
    }
    void samaArr1Arr3(Integer[]arr1,Integer[]arr3){
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]==arr3[i]){
                System.out.println(arr1[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        Rata2Arr1 r= new Rata2Arr1();
        Integer[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        Integer[] arr2 = new Integer[10];
        Integer[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
        Integer[] arr4 = new Integer[10];
        System.out.println("Rata - Rata "+r.avgArr1(arr1));
        System.out.println("Cek Arr1 "+ r.cekIsExist(14, arr1));
        r.posisiArr1(56, arr1);
        //r.ubahIsiArray(2, 10, arr1);
        System.out.println(arr1[2]);
        r.hapusPosisiArr1(3, arr1);
        System.out.println("");
        System.out.println("Nilai Terbesar : "+r.maxArr1(arr1));
        System.out.println("Nilai Terkecil : "+r.minArr1(arr1));
        r.copyArr1Arr2(arr1, arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]+" ");
        }
        System.out.println("Sorting array : ");
        r.sortingArr(arr1);
        r.jumlahArr1Arr3(arr1, arr3, arr4);
        
        System.out.println("Jumlah arr 1 arr 3 (Tapi arr1 sudah di sorting)");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr4[i]+" ");
        }
        
        System.out.println("");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr1[i]+" ");
        }
//System.out.println("Duplikasi");
        //r.cetakDuplikasi(arr1);
        
    }
}
