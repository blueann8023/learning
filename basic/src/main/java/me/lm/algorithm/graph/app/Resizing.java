package me.lm.algorithm.graph.app;

/**
 * shortest path
 * Content-aware resizing
 * Image resizing
 * <p>
 * To find vertical seam:
 * ・Grid DAG: vertex = pixel; edge = from pixel to 3 downward neighbors. ・Weight of pixel = energy function of 8 neighboring pixels.
 * ・Seam = shortest path (sum of vertex weights) from top to bottom.
 * To remove vertical seam:
 * ・Delete pixels on seam (one in each row).
 *
 * @author bule_ann
 * @since 2022/2/15
 */
public class Resizing {
}
