package sort;

/**
 * @Author: qxl
 * @Date: 2020/4/7 9:39
 * @Desc:
 * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3.针对所有的元素重复以上的步骤，除了最后一个；
 * 4.重复步骤1~3，直到排序完成
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] source = {3,2,7,5,6,4};
        sort(source);
        for (int i : source) {
            System.out.println(i);
        }
    }


    public static int[] sort(int[] source){
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1;j++){
                if (source[j] > source[j + 1]){
                    int temp = source[j + 1];
                    source[j + 1] = source[j];
                    source[j] = temp;
                }
            }
        }
        return source;
    }
}
