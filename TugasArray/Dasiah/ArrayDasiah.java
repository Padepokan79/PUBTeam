
public class ArrayDasiah {
	public static void main (String[] args) {
		int[] arr1= {25,14,56,15,36,56,77,18,29,49};
		int[] arr2=new int[10];
		int[] arr3= {2,39,47,14,36,56,57,49,43,79};
		int[] arr4=new int[10];
		double tamp=0,count=0;
		
		//===> Jawaban Nomor 1
		for (int x=0;x<arr1.length;x++) {
			tamp+=arr1[x];
			count++;
		}
		System.out.println("Rata-rata dari arr1 adalah "+(tamp/count));
		//=====================
		
		//===> Jawaban Nomor 2
		int y=49,result=0;
		for (int x=0;x<arr1.length;x++) {
			if (arr1[x]==y)
				result=1; 
			break;
		}
		if (result==1)
			System.out.println("Bilangan "+y+" ada di dalam arr1");
		else
			System.out.println("Bilangan "+y+" tidak ada di dalam arr1");
		//=====================
		
		//===> Jawaban Nomor 3
		int a=49,b=0,i=0;
		for (int x=0;x<arr1.length;x++) {
			if (arr1[x]==a) {
				b=1; break;
			}i++;
		}
		if (b==1)
			System.out.println("Bilangan "+a+" ada di dalam arr1 di index ke-"+i);
		else
			System.out.println("Bilangan "+a+" tidak ada di dalam arr1 di index ke-"+i);
		//=====================
		
		//===> Jawaban Nomor 4
		int nilai=7,posisi=1;
		for (int x=0;x<arr1.length;x++) {
			if(x==posisi-1) {
				arr1[x]=nilai;
			}
			break;
		}
		System.out.println("Bilangan "+nilai+" berhasil dimasukan ke dalam arr1 di posisi ke-"+posisi);
		//=====================
		System.out.println("---------------");
		//===> Jawaban Nomor 5 
		int p=1,t=1;
		int[] arrtamp=new int[9];
		for (int x=0;x<arrtamp.length;x++) {
			arrtamp[x]=arr1[x+1];
			if(x==p-1) {
				
			}
		}
		for (int x=0;x<arr1.length;x++) {
			arr1[x]=arrtamp[x];
			System.out.println(arr1[x]);
		}
		for (int x=0;x<arr1.length;x++) {
			System.out.println(arr1[x]);
		}
		/*
		 Sudah benar namun belum tepat
		 */
		//=====================
		
		//===> Jawaban Nomor 6
		int n=100,posisi1=1;
		for (int x=0;x<arr1.length;x++) {
			
		}
	}
}
