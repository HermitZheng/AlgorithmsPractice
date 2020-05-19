package Sort;

/**
 * @author zhuqiu
 * @date 2020/3/19
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 8, 6, 3, 7, 9};
        int[] sort = heapSort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static int[] heapSort(int[] arr) {        // 新建一个堆（
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {      // 从第一个非叶子结点开始，遍历到根结点
            heapAdjust(arr, len, i);                 // 每次“加入”一个结点就做一次调整
        }
        for (int i = len - 1; i >= 1; i--) {           // 遍历一整棵树（堆）
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;                           // 将根节点和堆的最后一个结点互换
            heapAdjust(arr, i, 0);                // 对除了最后一个节点以外的堆进行调整
        }
        return arr;
    }

    public static void heapAdjust(int[] arr, int len, int i) {
        int p = i;              // 一个“指针”，用于选择将要调整的元素
        int temp = arr[i];      // 将需要调整的最上方的那个元素保存下来（在排序中指的是根节点）
        int index = 2 * p + 1;  // 根据公式，指向的是p指针指向的元素的左子结点

        while (index < len) {                    // 确保不越界
            if (index < len - 1) {                 // 如果index（左子结点）不是堆的最后一个结点
                if (arr[index] < arr[index + 1]) { // 如果左子结点小于右子结点
                    index++;                    // 选择右结点与父节点进行调整
                }
            }
            if (arr[index] > temp) {            // 如果选择的子节点大于父节点
                arr[p] = arr[index];            // 将父节点与子节点“交换”（子节点暂时不赋值）
                p = index;                      // 更新父节点（向下继续调整）
                index = 2 * p + 1;              // 更新子节点（继续判断是否要调整）
            } else {
                break;
            }
        }
        arr[p] = temp;      // 调整完毕，将原来的父节点交还给子节点
    }
}
