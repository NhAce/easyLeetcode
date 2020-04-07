package sort;

/**
 * @Author: qxl
 * @Date: 2020/4/7 10:13
 * @Desc: 插入排序
 *
 * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
 * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 步骤5: 将新元素插入到该位置后；
 * 步骤6: 重复步骤2~5。
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] source = {3,2,7,5,6,4};
        sort(source);
        for (int i : source) {
            System.out.println(i);
        }
    }

    public static void sort(int[] source){
        for (int i = 1; i < source.length; i++) {
            int temp = source[i];
            for(int j = (i - 1); j >= 0; j--){
                if (temp < source[j]){
                    source[j+1] = source[j];
                    source[j] = temp;
                }else {break;}
            }
        }
    }
}
