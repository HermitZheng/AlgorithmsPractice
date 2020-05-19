package tree;

/**
 * @author zhuqiu
 * @date 2020/3/15
 */
public class AVLNode {

    int value;
    int depth;   // 深度，这里计算每个结点的深度，通过深度的比较可得出是否平衡
    AVLNode parent;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public AVLNode() {
    }
}
