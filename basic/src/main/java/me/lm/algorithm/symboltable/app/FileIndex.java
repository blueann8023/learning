package me.lm.algorithm.symboltable.app;

import me.lm.algorithm.symboltable.SymbolTable;
import me.lm.algorithm.symboltable.binarytree.LinkBinarySearchTree;

import java.io.File;
import java.util.Set;

/**
 * 基于SET&ST的文件索引
 *
 * @author bule_ann
 * @since 2022/1/18
 */
public class FileIndex {
    public static void main() {
        // 符号表 word -> 文件列表
        SymbolTable<String, Set<File>> st = new LinkBinarySearchTree<>();
        // process files

        // find file with special word
    }


}
