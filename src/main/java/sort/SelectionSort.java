package sort;

/**
 * @Author: qxl
 * @Date: 2020/4/7 9:58
 * @Desc: 选择排序--时间复杂度始终是 O(n2)
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * 步骤1：初始状态：无序区为R[1…n]，有序区为空；
 * 步骤2：第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1…i-1]和R(i…n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1…i]和R[i+1…n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区
 * 步骤3：n-1趟结束，数组有序化了
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] source = {3,2,7,5,6,4};
        sort(source);
        for (int i : source) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] source){
        for (int i = 0; i < source.length; i++) {
            int tempIndex = i;
            for (int i1 = i + 1; i1 < source.length; i1++) {
                if (source[i1] < source[tempIndex]){
                    tempIndex = i1;
                }
            }
            int temp = source[i];
            source[i] = source[tempIndex];
            source[tempIndex] = temp;
        }
        return source;
    }
}
