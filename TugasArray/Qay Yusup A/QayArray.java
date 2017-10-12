import java.util.Scanner;

public class QayArray {
	Scanner input= new Scanner(System.in);
	int[] array1={25,14,56,15,36,56,77,18,29,49};
	int[] array2= new int[10];
	int[] array3={2,19,47,14,36,56,57,49,43,79};
	int[] array4=new int[10];
	
	
	//-----------Code By Qay Yusup No.1
	public void HitungRate(){
		int tamp=0;
		for(int x=0;x<array1.length;x++){
			tamp=tamp+array1[x]; 	
		}	
		System.out.print("Ini jumlah array nya :"+tamp+"\nINi rata-ratanya :"+tamp/array1.length);
		
	}
	//-----------Code By Qay Yusup No.2 dan No.3
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
	//-----------Code By Qay Yusup No.4
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
					ArrayTamp[pos]=update;
					break;
				}
			}
		}
		for(int x=0;x<array1.length;x++){
			System.out.print(" "+ArrayTamp[x]);
			
		}
		
	}
	//-----------Code By Qay Yusup No.5
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
				ArrayTamp[y]=ArrayTamp[y+1];
			}else if(y>pos && y<=ArrayTamp.length){
				ArrayTamp[y]=ArrayTamp[y+1];
				
			}
		}
		for(int x=0;x<array1.length-1;x++){
			System.out.print(" "+ArrayTamp[x]);
			
		}
		
	}
	
	//-----------Code By Qay Yusup No.6
	public void Sisip(){
		int inputan,pos,tamp1=0;
		System.out.print("Masukan Bilangan :");
		inputan=input.nextInt();
		System.out.print("Masukan posisi:");
		pos=input.nextInt();
		for(int x=pos;x<array1.length-pos+1;x++){
			tamp1=array1[x];
			array1[x]=inputan;
			inputan=array1[x+1];
			array1[x+1]=tamp1;
		}
		for(int x=0;x<11;x++){
		System.out.print(" "+array1[x]);
		
		}
		
	}
	//-----------Code By Qay Yusup No.7
	public void Copy(){
		for(int x=0;x<array1.length;x++){
			array2[x]=array1[x];
		}
		System.out.print("Ini Copyanya di Array2 : ");
		for(int x=0;x<array1.length;x++){
			System.out.print(array2[x]+" ");
		}
		
	}
	//-----------Code By Qay Yusup No.8
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
	
	//-----------Code By Qay Yusup No.9
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
	//-----------Code By Qay Yusup No.10
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
	//-----------Code By Qay Yusup No.11
	public void Banding(){
		int sama[]=new int[6];
		int idx=0;
		for(int x=0;x<array1.length;x++){
			for(int y=0;y<array1.length;y++){
				if(array1[y]==array3[x]){
					sama[idx]=array1[y];
						idx++;
				}
			}
		}
		for(int a=0;a<idx
				;a++){
			System.out.print(" "+sama[a]);
		}
	}
	
	//-----------Code By Qay Yusup No.12
	public void Jumlahkan(){
		for(int x=0; x<array1.length;x++){
			array4[x]=array1[x]+array3[x];
		}
		for(int x=0; x<array1.length;x++){
			System.out.print(" "+array4[x]);
		}
	}
	//-----------Code By Qay Yusup No.13
	public void Tukar(){
		int tam,pos1,pos2;
		int ArrayTamp[]=new int[10];
		for(int x=0;x<array1.length;x++){
			ArrayTamp[x]=array1[x];
		} 
		System.out.print("Masukan posisi 1 :");
		pos1=input.nextInt();
		System.out.print("Masukan posisi 2 :");
		pos2=input.nextInt();
		
		for(int x=0;x<ArrayTamp.length;x++){
			if(pos1==x || pos2==x){
				tam=ArrayTamp[pos1];
				ArrayTamp[pos1]=ArrayTamp[pos2];
				ArrayTamp[pos2]=tam;
				break;
			}
		}
		System.out.print("Setelah di Tukar :");
		for(int x=0;x<array1.length;x++){
			System.out.print(" "+ArrayTamp[x]);
		}
	}
	//-----------Code By Qay Yusup No.14
	public void Urutkan(){
		int tam;
		int ArrayTamp[]=new int[10];
		for(int x=0;x<array1.length;x++){
			ArrayTamp[x]=array1[x];
		} 
		for(int x=0;x<ArrayTamp.length;x++){
			for(int y=0;y<ArrayTamp.length-1;y++){
				if(ArrayTamp[y]>ArrayTamp[y+1]){
					tam=ArrayTamp[y];
					ArrayTamp[y]=ArrayTamp[y+1];
					ArrayTamp[y+1]=tam;
				}
			}
		}
		for(int x=0;x<ArrayTamp.length;x++){
			System.out.print(ArrayTamp[x]+" ");
		}
	}
public static void main(String args[]){
		QayArray objek =new QayArray();
		objek.Sisip();
}

}