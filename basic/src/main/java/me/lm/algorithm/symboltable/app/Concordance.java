package me.lm.algorithm.symboltable.app;

import me.lm.algorithm.symboltable.SymbolTable;
import me.lm.algorithm.symboltable.binarytree.LinkBinarySearchTree;

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
        SymbolTable<String, Set<Integer>> st = new LinkBinarySearchTree<>();
        // process files

        // find -n&+n index context with special word
    }

}
