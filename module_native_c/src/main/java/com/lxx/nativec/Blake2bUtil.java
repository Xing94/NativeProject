package com.lxx.nativec;

public class Blake2bUtil {

    static {
        System.loadLibrary("blake2b_lib");
    }

    public static native byte[] blake2b(byte[] bytes, int length);

}
