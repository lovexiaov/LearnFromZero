package com.lovexiaov.learnfromzero.tools;

import java.io.Closeable;
import java.io.IOException;

/**
 * Close the object who implement Closeable interface.
 * Created by lovexiaov on 15/12/10.
 */
public class Closer {

    private Closer() {}

    public static void close(Closeable obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
