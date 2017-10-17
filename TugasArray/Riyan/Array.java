import javax.lang.model.type.NullType;

public class Array {
	public static void main(String[] args) {
		int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int[] arr2 = new int[10];
		int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
		int[] arr4 = new int[10];
		int[] newData = new int[arr1.length - 1];
		
		
		// no.1
		/*
		int jumlah = 0;
		int avg ;
		for(int x=0 ; x < arr1.length ; x++) {
			jumlah = jumlah + arr1[x];
		}
		avg = jumlah / arr1.length;
		System.out.println("Jumlah : "+ jumlah);
		System.out.println("Rata-rata : "+ avg);
		*/
		
		//no.2
		/*
		int a=18;
		for(int b=0 ; b < arr1.length ; b++) {
			if(a == arr1[b]) {
				System.out.println("ada");
			}
		} 
		*/	
		
		//no.3	
		/*
		int c=77;
		for(int b=0 ; b < arr1.length ; b++) {
			if(c == arr1[b]) {
				System.out.println(c+ " ada di index ke: "+b);
			}
		} 
		*/
		//no.4
		/*
		int d=18;
		for(int b=0 ; b < arr1.length ; b++) {
			if(d == arr1[b]) {
				System.out.print("awalnya : "+arr1[b]);
				arr1[b] = 100;
				System.out.println(" diubah menjadi : "+arr1[b]);	
			}
		}
		*/
		//no.5 belum
		/*
		 int e=25;
		int index=0;
		for(int b=0 ; b < arr1.length ; b++) {
			if(e != arr1[b]) {
				newData[b]=arr1[b];
			}else {
				
			}
			System.out.println(newData[b]);
		}
		*/
		//no.6 belum
		/*
		int index = 2;
		int value = 20;
		int tamp;
		for(int x=0 ; x < arr1.length ; x++) {
			if(x == index) {
				tamp=arr1[x+1];
				arr1[x]=value;
			}
			System.out.println(arr1[x]);
		}
		*/
		//no.7
		/*
		for(int x=0 ; x < arr1.length ; x++) {
			arr2[x]=arr1[x];
			System.out.println(arr2[x]);
		}
		*/
		
		//no.8
		int tamp;
		for(int x=0 ; x < arr1.length ; x++) {
			if(arr1[x] < arr1[x+1]) {
				tamp=arr1[x];
				System.out.println(tamp);
			}else {
				
			}
		}
	}
}