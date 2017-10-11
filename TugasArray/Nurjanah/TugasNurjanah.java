/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasnurjanah;

/**
 *
 * @author Ai ^^
 */
public class TugasNurjanah {

    /**
     * @param args the command line arguments
     */
    int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}; 
    int[] arr2 = new int[10]; 
    int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79}; 
    int[] arr4 = new int[10]; 
    public void rata_rata(){
        // Hitung jumlah dan rata-rata dari arr1 di atas
       // int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}; 
        int jum = 0, rata=0;
        for(int a=0; a<arr1.length; a++){
            jum = jum + arr1[a];
        }
        rata = jum / arr1.length;
        System.out.println("Rata_rata : "+rata+"\nJumlah : "+jum);
        
    }
    public void cekInput(int input){
        //Apakah suatu bilangan ada di arr1 atau tidak?
       // int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int tam = 0;
        for(int a=0; a<arr1.length; a++){
            if (input==arr1[a]){
                tam =1 ;
            }else{
                tam =0;
            }
        }
        if (tam ==1){
            System.out.println("ada yang sama");
        }else{
            System.out.println("tidak ada yang sama");
        }
        
    }
    public void posisi(int input){
        //Suatu bilangan ada di-posisi/index ke berapa di arr1?
        int tam = 0;
         for(int a=0; a<arr1.length; a++){
            if (input==arr1[a]){
                System.out.println("Angka "+ input + "ada di array index : " + a);
                tam++;
            }
        }
        if(tam == 0){
                System.out.println("tidak ada yang sama");
        }
    }
    public void ubah(int input, int posisi){
        //Terima nilai dan ubah nilai u/ suatu posisi pada arr1
        for(int a=0; a< posisi; a++){
            arr1[posisi-1] = input;
        }
        System.out.println("array posisi ke : " + (posisi) + " diubah menjadi : " + arr1[posisi-1]);

    }
    public void hapus(int posisi){
        //Hapus suatu posisi dari arr1
        for (int a=0; a<posisi; a++){
          arr1[posisi-1]= 0;
        }

        
    }
    public void sisip(int input, int posisi){
        //Sisip suatu bilangan pada posisi tertentu pada arr1
        for(int a=0; a<arr1.length; a++){
            if ((posisi-1)==0){
                arr1[0]=input;
                arr1[a+1]=arr1[a];
            }else if (posisi==arr1.length){
                arr1[posisi-1]=input;
            }else{
                arr1[posisi-1]=input;
                arr1[a]=arr1[a+1];
            }
        }
        System.out.println("array posisi ke : " + (posisi) + " diisi : " + arr1[posisi-1]);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TugasNurjanah coba = new TugasNurjanah();
        coba.sisip(3,3);
    }
    
}
