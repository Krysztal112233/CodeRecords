package dev.krysztal.l4b2;

import java.util.ArrayList;

public class KrysztalCodes {

    ArrayList<Integer> numCombine = new ArrayList<>();
    int count = 0;
    int maxStep;

    KrysztalCodes(int maxStep) {
        this.maxStep = maxStep;
    }

    public int run() {
        dfsRun(0);
        return this.count;
    }

    // 使用DFS（深度优先搜索）
    // 相对暴力枚举，能有更明确的边界
    // 并且拥有剪枝能力，能在父节点不满足时直接跳过接下来的所有子节点
    private void dfsRun(int step) {
        // 边界为 步数等于预期长度
        if (step == this.maxStep) {
            dfsCheck();
            return;
        }

        // 开始递归
        for (int i = 1; i < 10; i++) {
            // 不允许有重复
            if (this.numCombine.contains(i))
                continue;
            this.numCombine.add(i);
            this.dfsRun(step + 1);
            // 回溯
            this.numCombine.remove(this.numCombine.size() - 1);
        }

    }

    private void dfsCheck() {
        int a = this.numCombine.get(0);
        int b = this.numCombine.get(1);
        int c = this.numCombine.get(2);
        int d = this.numCombine.get(3);
        int e = this.numCombine.get(4);
        // System.out.printf("%d%d * %d%d%d = %d%d%d * %d%d\n", a, b, c, d, e, a, d, b,
        // c, e);
        // ab*cde==adb*ce
        if (((a * 10 + b) * (c * 100 + d * 10 + e)) == ((a * 100 + d * 10 + b) * (c * 10 + e))) {
            this.count += 1;
        }
    }

}
