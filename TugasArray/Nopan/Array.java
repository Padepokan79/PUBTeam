import java.util.Scanner;

public class Array {
	public static void jumlahDanRatarata() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		float jumlah=0,rata=0;
		
			for(int a=0;a<arr1.length;a++) {
				jumlah+=arr1[a];
				rata=jumlah / arr1.length;
			}
			System.out.println("jumlah arr1 : "+jumlah);
			System.out.println("rata-rata arr1 : "+rata);
	}
	public static void search() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int data=0;
		Scanner array=new Scanner(System.in);
		data=array.nextInt();
		for(int a=0;a<arr1.length;a++) {
			if(arr1[a]==data) {
				System.out.println("Data ada pada array1");
				break;
			}else {
				System.out.println("Data tidak ada dalam array1");
				break;
			}
		}
		
	}
	public static void searchIndex() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int data=0;
		int index=0;
		Scanner array=new Scanner(System.in);
		data=array.nextInt();
		for(int a=0;a<arr1.length;a++) {
			
			if(a==data) {
				index=a;
				System.out.println("Berada dalam index ke "+index);
				break;
			}else {
				System.out.println("Data tidak ada dalam array1");
				break;
			}
		}
	}
	
	public static void max() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int max;
		max=arr1[0];
		for(int i=0;i<arr1.length;i++) {
			if(max<arr1[i]) {
				max=arr1[i];
			}
		}
		System.out.println("Nilai max dalam array1 : "+max);
	}
	public static void min() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int min;
		min=arr1[0];
		for(int i=0;i<arr1.length;i++) {
			if(min>arr1[i]) {
				min=arr1[i];
			}
		}
		System.out.println("Nilai min dalam array1 : "+min);
	}
	
	public static void copy() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int[] arr2= new int[arr1.length];
		
		for(int a=0;a<arr1.length;a++) {
			arr2[a]=arr1[a];
			System.out.println(""+arr2[a]);
		}
		
	}
	
	public static void sama() {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int[] arr3= {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
		for(int a=0;a<10;a++) {
			if(arr1[a]==arr3[a]) {
				
			System.out.println(""+arr1[a]);
			}
		}
		
	}
	public static void main(String args[]) {
		//jumlahDanRatarata();
		//search();
		//searchIndex();
		//max();
		//min();
		//copy();
		sama();
	}
}
