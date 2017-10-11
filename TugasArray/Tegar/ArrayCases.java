package pack.array;

public class ArrayCases {
    
    int[] arr1 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
    int[] arr2 = new int[10];
    int[] arr3 = {2, 39, 47, 14, 36, 56, 57, 49, 43, 79};
    int[] arr4 = new int[10];
    
    //number 1
    public float sum(){
        float sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }
        return sum;
    }
    
    public float average(){
        float average = 0;
        average = sum()/arr1.length;
        
        return average;
    }
    
    //number 2
    public boolean searchNumber(int param){
        boolean status = false;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == param){
                status = true;
                break;
            }
        }
        return status;
    }
    
    //number 3
    public int[] getIndex(int param){
        int[] tamp = {0};
        int indexTamp = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]==param){
                tamp[indexTamp] = i;
            }
            indexTamp++;
        }
        return tamp;
    }
    
    //number 4
    public void searchNumber(int newValue, int pos){
        for (int i = 0; i < arr1.length; i++) {
            if(i == pos){
                arr1[i] = newValue;
            }
        }
    }
    
    //number 5
    
    //number 6
    public int[] arrayInterpolation(int value, int pos){
        int[] tamp = new int[arr1.length+1];
        int tampIndex = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(i == pos){
                tamp[i] = value;
                tampIndex++;
            }
            tamp[tampIndex] = arr1[i];
            tampIndex++;
        }
        
        return tamp;
    }
    
    //number 7
    public void copyArrayArr1AndArr2(){
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }
    
    //number 8
    public int minArr1(){
        int min = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]<min){
                min = arr1[i];
            }
        }
        return min;
    }
    
    //number 9
    public int maxArr1(){
        int max = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]>max){
                max = arr1[i];
            }
        }
        return max;
    }
    
    //number 10
    public void arr1Duplication(){
        int tamp = 0;
        for (int i = 0; i < arr1.length; i++) {
            tamp = arr1[i];
            for (int j = 0; j < arr1.length; j++) {
                if(tamp==arr1[j] && j!=i){
                    System.out.println(tamp + " ada di index " + j);
                    break;
                }
            }
    
        }
    }
    
    //number 11
    
    //number 12
    
    //number 13
    
    //number 14
    public void sortArr1(){
        for (int i = 0; i < arr1.length; i++) {
            int b = arr1[i];
        }
    }
    
    //display array function
    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        ArrayCases ac = new ArrayCases();
        //System.out.println(ac.sum()); //ex. 1
        
        //example 6
//        int[] newArray = ac.arrayInterpolation(100,2); 
//        ac.printArray(newArray);
        
        //example 7
//        ac.copyArrayArr1AndArr2();
//        ac.printArray(ac.arr2);
        
        //example 8
//        System.out.println(ac.minArr1());
        
        //example 10
        ac.arr1Duplication();
    }
}
