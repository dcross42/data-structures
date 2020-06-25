public class MergeSort{

  public static void mergeSort(int[] array, int first, int last){
    if(first < last){
      int middle = (first + last) / 2;//floor function covered by integer division
      mergeSort(array, first, middle);
      mergeSort(array, middle+1, last);
      merge(array, first, middle, last);
    }
  }

  private static void merge(int[] array, int first, int middle, int last){
    int lenLeft = middle - first + 1;
    int lenRight = last - middle;
    int[] left = new int[lenLeft+1];
    int[] right = new int[lenRight+1];

    for(int i = 0; i < lenLeft; i++){
      left[i] = array[first + i];
    }
    for(int i = 0; i < lenRight; i++){
      right[i] = array[middle + i + 1];
    }
  
    right[lenRight] = Integer.MAX_VALUE;
    left[lenLeft] = Integer.MAX_VALUE;

    int i = 0;
    int j = 0;
    for(int k = first; k <= last;k++){
      if(left[i] <= right[j]){
        array[k] = left[i];
        i++;
      }
      else{
        array[k] = right[j];
        j++;
      }
    }
  }
}//end class MergeSort
