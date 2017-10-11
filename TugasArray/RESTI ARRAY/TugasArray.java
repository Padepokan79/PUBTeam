/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasarray;

/**
 *
 * @author SiNeng
 */
public class TugasArray {
    private int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
    private int[] arr2 = new int[10];
    private int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
    private int[] arr4 = new int[10];
    
    //soal nomor 1 (menghitung rata-rata arr1)
    public void hitungRataRataArr1(){
        double sum=0;
        double rata_rata;
        for(int i=0; i< arr1.length; i++){
            sum=sum+arr1[i];
        }
        System.out.println(sum);
        rata_rata=sum/arr1.length;
        System.out.println("Rata-rata arr1 : "+rata_rata);
    }
    
    //nomor 2 (cek array arr1)
    public void cekArray(int cek){
        int st=0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]==cek){
                st=1;
                break;
            }
        }
        if(st==1){
            System.out.println("Angka yang di cari ada di array");
        }else{
            System.out.println("Angka yang di cari tidak ada di dalam array");
        }
    }
    
    //nomor 3 (cek index arr1)
    public void cekIndex(int cek){
        int st=0;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==cek){
                System.out.println("Angka "+cek+" ada di index ke-"+i); 
                st=1;
            }
        }
        if(st==0){
            System.out.println("Angka tidak ada di dalam array");
        }
    }
    
    //nomor 4 (terima nilai ubah nilai arr1)
    public void ubahValue(int nilai, int posisi){
        if (posisi >= arr1.length){
            System.out.println("Posisi terlalu besar");
        }else if(posisi<1){
            System.out.println("Posisi dimulai dari 1");
        }else{
            arr1[posisi-1]=nilai;
        }
    }
    
    // nomor 5 (hapus posisi arr1)
    public void hapusPosisi(int posisi){
        int[] tamp= new int[arr1.length-1];
        if (posisi >= arr1.length){
            System.out.println("Posisi terlalu besar");
        }else if(posisi<1){
            System.out.println("Posisi dimulai dari 1");
        }else{
            for(int i=0; i<arr1.length;i++){
                if(i==posisi-1){
                    System.out.println("Posisi "+posisi+", di index "+i+" dengan value "+arr1[i]+" terhapus");
                }else{
                    tamp[i]=arr1[i];
                }
            }
            arr1=tamp;
        }
    }
    
    //nomor6 (menyisipkan nilai baru)
    public void tambah(int nilai, int index){
        
    }
    
    //nomor 7 (menggabungkan arr1 ke arr2)
    public void gabung(){
        for(int i=0;i<arr2.length;i++){
            arr2[i]=arr1[i];
        }
        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TugasArray ta= new TugasArray();
        ta.hitungRataRataArr1();
        ta.cekArray(18);
        ta.cekIndex(49);
        ta.gabung();
    }
}
    

