package org.opensource.alg.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 硬币组合次数最少
 */
public class Coin {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3,7};
        //
        int result = 100;
        int count = 0;

        Integer[] choose = new Integer[result+1];

        for (int i = 0; i <= result; i++) {
            if(i<coins[0]){
                choose[i] = null;
            }else{
                Integer[] coinMinCount = new Integer[coins.length];
                for (int j = 0; j < coins.length; j++) {
                    int i1 = i - coins[j];
                    if(i1==0){
                        coinMinCount[j] = 1;
                    }else if(i1>0){
                        if (choose[i1]!=null && choose[i1]>0) {
                            coinMinCount[j] = choose[i1]+1;
                        }else{
                            coinMinCount[j] = null;
                        }
                    }else{
                        coinMinCount[j] = null;
                    }
                }
                choose[i] = getMini(coinMinCount,i);
            }
        }
        System.err.println(Arrays.toString(choose));
    }

    static Integer getMini(Integer[] arr,int aa){
        List<Integer> arrList = Arrays.stream(arr).filter(Objects::nonNull).collect(Collectors.toList());
        if (arrList.size()==0) {
            return null;
        }
        int mini = arrList.get(0);
        int duplicate = arrList.get(0);
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i)  < mini) {
                mini = arr[i];
            }
            if(i>0&& arrList.get(i)==duplicate){
                System.err.println(Arrays.toString(arr) + "== "+aa);
            }
        }
        return mini;
    }
}
