package me.lm.basic.algorithm.search.app;

import java.util.HashMap;
import java.util.Map;

/**
 * 稀疏矩阵向量乘积算法优化
 *
 * @author bule_ann
 * @since 2022/1/18
 */
public class MatrixVectorMulti {
    public static void main() {
        //  Matrix -> Aarry[SparseVector]

    }

    public static class SparseVector {

        private final Map<Integer, Double> values;

        SparseVector(Double[] vector) {
            values = new HashMap<>();
        }

        void put(Integer index, Double value) {
            // value = 0 不要put
            values.put(index, value);
        }

        Double get(Integer index) {
            if (!values.containsKey(index)) {
                return 0.0d;
            }
            return values.get(index);
        }

        Double dot(Double[] vector) {
            double sum = 0;
            for (int i = 0; i < vector.length; i++) {
                sum += vector[i] * this.get(i);
            }
            return sum;
        }
    }
}
