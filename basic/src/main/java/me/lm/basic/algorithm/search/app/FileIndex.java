package me.lm.basic.algorithm.search.app;

import me.lm.basic.algorithm.search.SymbolTable;
import me.lm.basic.algorithm.search.binary.BinarySearchTree;

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
        SymbolTable<String, Set<File>> st = new BinarySearchTree<>();
        // process files

        // find file with special word
    }


}
