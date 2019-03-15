/**
 * @Author: WSS
 * @Date:
 * @Description: 归并排序
 * 时间复杂度:O(nlogn)
 * 空间复杂度：O(n)
 * 算法稳定性：稳定
 *
 * 归并与快排都应用分治思想。
 *
 * 分治思想:将一个大的问题分为若干个足够小的问题，当所有小问题解决后，将结果合并起来就是整个问题的求解。
 * 所有使用分治思想解决的问题均可利用递归的技巧完美解决。
 *
 *  递推公式：
 * merge_sort(p…r) = merge(merge_sort(p…mid), merge_sort(mid+1…r))
 *  终止条件：
 * p >= r 不用再继续分解
 */
public class MergeSort {
    public static void mergeSort(int[] target){
        int n = target.length;
        if (n<=1){
            return;
        }
        int mid = n/2;
        mergeInternal(target,0,n-1);
    }

    /***
     * 分治排序
     * @param array 要排序的集合
     * @param low 开始位置
     * @param high 结束位置
     */
    private static void mergeInternal(int[] array,int low,int high){
        //优化：当元素个数比较小时，调用直接插入排序
        if (high - low <= 16){
            InsertSort.insertSort(array);
            return;
        }
        int mid = low + (high-low)/2;
        //左边小数组
        mergeInternal(array,low,mid);
        //右边小数组
        mergeInternal(array,mid+1,high);
        //将array[p...mid]与array[mid+1...r]合并为array[p...r]
        //优化：当左边数组最大元素都小于右边数组最小元素，说明整个数组有序，直接结束排序
        if (array[mid] >= array[mid+1]) {
            merge(array,low,mid,high);
        }
    }

    /***
     * 合并函数
     * @param array
     * @param p 开始位置
     * @param mid 中间位置
     * @param r 结束位置
     */
    private static void merge(int[] array,int p,int mid,int r){
        int i = p;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[r-p+1];
        //两部分数组都还有数据
        while (i <= mid && j <= r){
            //小于等于保证了有序性
            if (array[i] <= array[j]){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }
        //判断两个数组中哪个还有元素
        int start = i;
        int end = mid;
        //如果剩下第二个数组
        if(j <= r){
            start = j;
            end = r;
        }
        //将剩余数据拷贝回temp数组
        while (start <= end){
            temp[k++] = array[start++];
        }
        //将temp中的数组拷贝回原数组a[p...r]
        for(i = 0;i <= r-p;i++){
            array[p+i] = temp[i];
        }
    }

    //测试
    public static void main(String[] args) {
        int[] test = new int[]{9,8,7,6,5,4,3,2,1};
        mergeSort(test);
        Tool.print(test);//结果：[1 2 3 4 5 6 7 8 9]
    }
}

