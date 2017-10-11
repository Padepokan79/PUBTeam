import java.util.Scanner;

public class QayArray {
	Scanner input= new Scanner(System.in);
	int array1[]={25,14,56,15,36,56,77,18,29,49};
	int[] array2= new int[10];
	int[] array3={2,19,47,14,36,56,57,49,43,79};
	int[] array4=new int[10];
	public void HitungRate(){
		int tamp=0;
		for(int x=0;x<array1.length;x++){
			tamp=tamp+array1[x]; 	
		}	
		System.out.print("Ini jumlah array nya :"+tamp+"\nINi rata-ratanya :"+tamp/array1.length);
		
	}
	public void CekArray(){
		int inputan,stat=0,pos=0;
		System.out.print("Masukan Bilangan :");
		inputan=input.nextInt();
		for(int x=0;x<array1.length;x++){
			if(inputan==array1[x]){
				stat=1;
				pos=x;
				break;
			}
		}
		if(stat==1){
			System.out.println("Bilangan Ada");
		}else{
			System.out.println("Bilangan tidak ada");
		}
		System.out.println("Berada di pos :"+ pos);
	}
	public void Update(){
		int update,pos;
		int ArrayTamp[]=new int[10];
		for(int x=0;x<array1.length;x++){
			ArrayTamp[x]=array1[x];
		} 
		System.out.print("Masukan Bilangan :");
		update=input.nextInt();
		System.out.print("Masukan posisi :");
		pos=input.nextInt();
		
		for(int x=0; x<pos;x++){
			for(int y=0;y<ArrayTamp.length;y++){
				if(pos==y){
					ArrayTamp[pos-1]=update;
					break;
				}
			}
		}
		for(int x=0;x<array1.length;x++){
			System.out.print(" "+ArrayTamp[x]);
			
		}
		
	}
	public void Hapus(){
		int pos;
		int ArrayTamp[]=new int[10];
		for(int x=0;x<array1.length;x++){
			ArrayTamp[x]=array1[x];
		}
		System.out.print("Masukan posisi :");
		pos=input.nextInt();
		
		for(int y=0;y<ArrayTamp.length-1;y++){
			if(pos==y){
				ArrayTamp[pos]=ArrayTamp[y+1];
			}else if(y>pos){
				ArrayTamp[pos]=ArrayTamp[y+1];
			}
		}
		for(int x=0;x<array1.length;x++){
			System.out.print(" "+ArrayTamp[x]);
			
		}
		
	}
	public void Copy(){
		for(int x=0;x<array1.length;x++){
			array2[x]=array1[x];
		}
		System.out.print("Ini Copyanya di Array2 : ");
		for(int x=0;x<array1.length;x++){
			System.out.print(array2[x]+" ");
		}
		
	}
	public void NilaiMin(){
		int nilaiMin=0;
		nilaiMin=array1[0];	
		for(int x=1;x<array1.length;x++){
			if(nilaiMin>array1[x]){
				nilaiMin=array1[x];
			}
		}
		System.out.print("Ini nilai Minimum Dari array1: "+nilaiMin);		
	}
	public void NilaiMax(){
		int nilaiMax;
		nilaiMax=array1[0];	
		for(int x=1;x<array1.length;x++){
			if(nilaiMax<array1[x]){
				nilaiMax=array1[x];
			}
		}
		System.out.print("Ini nilai Maximum Dari array1: "+nilaiMax);		
	}
	public void Duplikasi(){
		int tam1=0,tam2=0;	
		for(int x=0;x<array1.length;x++){
			for(int y=1;y<array1.length;y++){
				if(array1[x]==array1[y] && y!=x){
					tam1=array1[x];
					tam2=array1[y];
				}
			}
			
		}
		System.out.print("Ini bilangan yang sama :"+tam1);		
	}
	
	public static void main(String args[]){
		QayArray objek =new QayArray();
		objek.Hapus();
	}
}
