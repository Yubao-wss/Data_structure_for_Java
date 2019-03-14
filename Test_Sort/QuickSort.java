import java.util.Random;

/**
 * @Author: WSS
 * @Date: 2019/3/13
 * @Description: 快速排序
 * 20世纪最重要的算法之一,基于分治思想 O(nlogn),1s轻松完成百万数量级的排序
 *
 * 算法思路:从待排序的数组中选取任意一个元素[l..r],称为分区点(基准值)开始遍历过程，每当发现比基准值小的元素就放在基准值左边，每当发现>=基准值元素就放在基准值右边。
 *
 * 当结束一次遍历时，基准值元素一定在最终位置。
 *
 * 问题:当待排序元素近乎有序时，若选取的基准值恰好为最大值，此时分层退化成O(n),此时快排的时间复杂度退化为O(n^2) 最坏情况
 * 最好情况:每次分区点的选择都恰好在中间位置，O(nlogn)
 * 平均O(nlogn)
 *
 * 空间:O(1),原地排序
 *
 * 稳定性:不稳定算法(若基准值为最后一个元素,5 4 3 2 6 1 5)
 */
public class QuickSort {
    public static void quickSort(int[] target){
        int n = target.length;
        if (n <= 1){
            return;
        }
        Internal(target,0,n-1);
    }

    /***
     * 快排递归
     * @param array 待排序的数组
     * @param low 数组起始位置
     * @param hight 数组终止位置
     */
    private static void Internal(int[] array,int low,int hight){
        if (low >= hight){
            return;
        }
        int index = patition3(array,low,hight);
        Internal(array,low,index-1);
        Internal(array,index+1,hight);
    }

    /***
     * 对target[l...h]部分进行分区操作
     * 返回p，使得target[1...p-1] < target[p] ; target[p+1...h] > target[p]
     * @param target 待排序数组
     * @param low 数组开始点
     * @param high 数组结束点
     * @return 分区点下标
     */
    private static int patition1(int[] target,int low,int high) {
        //默认比较元素为待排序数组的第一个元素
        int v = target[low];
        int j = low;
        int i = low+1;
        for (;i <= high; i++){
            //每当碰到小于比较元素的值与j+1位置交换，小于区间长度加一
            if (target[i] < v){
                swap(target,j+1,i);
                j++;
            }
        }
        //当for循环走完只需要将array[l]位置与array[j]位置交换即可保证索引小于j的元素均小于v，索引大于j的元素均大于j
        swap(target,low,j);
        return j;
    }

    //优化1：
    // 当待排序的集合近乎有序时，由于默认选择的第一个元素作为基准值，会导致基准值划分的两个子数组严重不均衡，
    // 此时分层下来的结果近乎于n层，此时快排退化为复杂度为O(n^2)排序算法
    // 解决:随机选取一个元素作为基准值，来降低每次都选到最小或最大值的概率
    private static int patition2(int[] target,int low,int high){
        //随机选定一个下标，将其与第一个索引交换
        int randomIndex = (int) (Math.random()*(high - low + 1) + low);
        swap(target,low,randomIndex);
        int v = target[low];
        int i = low + 1;
        int j = low;
        while (i <= high){
            if (target[i] < v){
                swap(target,i,j+1);
                i++;
                j++;
            }else {
                i++;
            }
        }
        swap(target,low,j);
        return j;
    }

    //优化2：二路快排
    //当待排序集合包含大量重复元素时，由于与基准值相等的元素个数过多，导致数组长度不均衡，此时分层下来的结果近乎n层，快排退化为O(n^2)
    //将大于和小于v的元素放在数组的两端,i索引不断向后扫描，当i的元素小于v时，i++;j索引不断向前扫描，当j的元素大于v时，j--;
    //当i碰到一个>=v的元素以及j碰到一个<=v的元素，交换i与j的元素,i++,j--
    private static int patition3(int[] target,int low,int high){
        int randomIndex = (int) (Math.random()*(high - low + 1) + low);
        swap(target,low,randomIndex);
        int v = target[low];
        int i = low+1;
        int j = high;

        while (true){
            while (i <= high && target[i] < v){
                i++;
            }
            while (j >= low+1 && target[j] > v){
                j--;
            }
            //结束循环的条件
            if (i > j){
                break;
            }

            //当i碰到一个>=v的元素以及j碰到一个<=v的元素，交换i与j的元素,i++,j--
            swap(target,i,j);
            i++;
            j--;
        }
        swap(target,low,j);
        return j;
    }

    /***
     * 交换数组中的两个元素的位置
     * @param array 目标数组
     * @param indexA 元素A下标
     * @param indexB 元素B下标
     */
    private static void swap(int[] array,int indexA,int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
    //测试
    public static void main(String[] args) {
        int[] test = new int[]{5,5,5,5,4};
        quickSort(test);
        Tool.print(test);// [1 2 3 4 5]
    }
}
