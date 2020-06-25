import java.util.Random;

public class RandomQuicksort{
  public static void randomQuicksort(int[] array, int start, int pivot){
    if(start < pivot){
      int index = randomPartition(array, start, pivot);
      randomQuicksort(array, start, index-1);
      randomQuicksort(array, index+1, pivot);
    }
  }//end randomQuicksort

  private static int randomPartition(int[] array, int start, int pivot){
    //randomize pivot
    Random rand = new Random();
    int randPivot = rand.nextInt(pivot-start+1) + start;//get random number [start, pivot]
    //System.out.println("S: " + start + " " + "P: " + pivot + " " + "RAND: " + randPivot);
    swap(array, pivot, randPivot);
    //partition
    int pivotValue = array[pivot];
    int index = start - 1;
    for(int j = start; j < pivot; j++){
      if (array[j] <= pivotValue){
        index++;
        swap(array, index, j);
      }
    }
    swap(array, index+1, pivot);
    return index + 1;
  }

  private static void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}//end class
