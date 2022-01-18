package me.lm.basic.algorithm.search.app;

import me.lm.basic.algorithm.search.SymbolTable;
import me.lm.basic.algorithm.search.binary.BinarySearchTree;

import java.util.Set;

/**
 * 基于SET&ST的文件关联上下文
 *
 * @author bule_ann
 * @since 2022/1/18
 */
public class Concordance {
    public static void main() {
        // 符号表 word -> 单词位置列表
        SymbolTable<String, Set<Integer>> st = new BinarySearchTree<>();
        // process files

        // find -n&+n index context with special word
    }

}
