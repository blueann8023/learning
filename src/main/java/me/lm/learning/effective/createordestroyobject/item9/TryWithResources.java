package me.lm.learning.effective.createordestroyobject.item9;

import org.junit.Test;

import java.io.*;

/**
 * Created by blue_ann on 11/09/2018.
 */
public class TryWithResources {

    private static int BUFFER_SIZE = 1024;

    // try with finally no longer beat way
    // try with finally
    public String firstLine(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try with finally - more ugly
    public void copy(String srcPath, String dstPath) throws IOException {
        InputStream is = new FileInputStream(srcPath);
        try {
            OutputStream os = new FileOutputStream(dstPath);
            try {
                byte[] buffer = new byte[BUFFER_SIZE];
                int n;
                while ((n = is.read(buffer)) >= 0) {
                    os.write(buffer, 0, n);
                }
            } finally {
                os.close();
            }
        } finally {
            is.close();
        }
    }

    // try with resources need implements auto closable
    // try with resources
    public String firstLine1(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // try with resources
    public void copy1(String srcPath, String dstPath) throws IOException {
        try (InputStream is = new FileInputStream(srcPath); OutputStream os = new FileOutputStream(dstPath)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int n;
            while ((n = is.read(buffer)) >= 0) {
                os.write(buffer, 0, n);
            }
        }
    }

}
