public class Practice {
    public static void main(String[] args){
        int[] bubbleArr = {4, 6, 2, 7, 3, 8};
//        bubbleSort(bubbleArr, 6);
        int[] quickArr = {5, 4, 7, 2, 8 };
//        quickSort(quickArr,0, 4);
        System.out.println(countSort("geeksforgeeks"));
    }
    public static void bubbleSort(int[] numArr, int n){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(numArr[j] > numArr[j + 1]){
                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < numArr.length; i++){
            System.out.println(numArr[i]);
        }
    }
    public static int partition(int[] numArr, int lo, int hi){
        int pivot = numArr[hi];//sets the pivot to the last number in the array
        int i = (lo - 1);//sets the i iteration to -1
        for(int j = lo; j <= hi-1; j++){//run through the array
            if(numArr[j] <= pivot){//if number at j is less than pivot
                i++;//add to i
                int temp = numArr[i];//swap number at i with number at j
                numArr[i] = numArr[j];
                numArr[j] = temp;
            }
        }
        int part = numArr[i+1];//swap i+1 with pivot
        numArr[i+1] = numArr[hi];
        numArr[hi] = part;
        return i + 1;//return i+1 to return pivot index
    }
    public static void quickSort(int[] numArr, int lo, int hi){
        if(lo < hi){
            int piv = partition(numArr,lo,hi);
            quickSort(numArr,lo,piv-1);
            quickSort(numArr,piv + 1, hi);
            for (int i = 0; i<numArr.length; i++){
                System.out.println(numArr[i]);
            }
            System.out.println();
        }
    }
    public static String countSort(String words)
    {
        char[] letters = words.toCharArray();//Turn string into char array
        int n = letters.length;//get length of array
        char[] sorted = new char[n];//Create array same size as string that will store sorted letters
        int count[] = new int[256];//Create an array to store counts of chars
        for (int i = 0; i < 256; ++i) {//initialize all values to 0
            count[i] = 0;
        }
        for (int i = 0; i < n; ++i) {//for the length of the char array
            ++count[letters[i]];//for every char, add 1 to the char position in count array
        }
        for (int i = 1; i <= 255; ++i) {
            count[i] += count[i - 1];//add char index counts
        }
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[letters[i]] - 1] = letters[i];
            --count[letters[i]];
        }
        for (int i = 0; i < n; ++i) {//change values in letters to equal the sorted array
            letters[i] = sorted[i];
        }
        String sortedString = "";
        for (int i = 0; i < n; i++) {
            sortedString += letters[i];
        }
        return sortedString;//change it back to string
    }
}
