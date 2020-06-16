package service;

import exception.EmptyArrayException;
import exception.NegativeValueInArrayException;

import java.util.stream.IntStream;

public class MainService {

    public int getTotalWater(int[] array, int total){
        checkTheArraySize(array);
        int peakPointIndex = findPeakPointIndex(array);
        total = getTotalValue(array, total, peakPointIndex);
        int[] subArr = IntStream.range(peakPointIndex, array.length)
                .map(i -> array[i])
                .toArray();
        if(subArr.length > 2){
            return getTotalWater(subArr,total);
        }
        return total;
    }

    private int getTotalValue(int[] array, int total, int peakPointIndex) {
        for(int i = 1 ; i<peakPointIndex;i++){
            total += array[peakPointIndex] - array[i];
        }
        return total;
    }


    private int findPeakPointIndex(int[] array) {
        int firsPeakPointValue = array[0];
        int peakIndex = 0;
        int maxValue = 0;
        for(int i= 1 ; i<array.length;i++){
            checkTheValue(array[i]);
            if (array[i] > firsPeakPointValue) {
                peakIndex =  i;
                break;
            } else if (array[i] > maxValue) {
                maxValue = array[i];
                peakIndex = i;
            }
        }
        return peakIndex;
    }

    private void checkTheArraySize(int[] array) {
        if(array.length == 0){
            throw new EmptyArrayException("Array can not be empty");
        }
    }
    private void checkTheValue(int i) {
        if(i < 0 ){
            throw new NegativeValueInArrayException("Value can not be negative");
        }
    }
}
