package com.lxx.nativerust;

import java.util.List;

public class FilecoinBlsSignUtil {

    //生成bls私钥
    public static native String generateBlsSeed();

    public static native String filPrivateKeyGenerateWithSeed(String seed);

    public static native String filPrivateKeyPublicKey(String privateKey);

    public static native String filPrivateKeySign(String privateKey, String message);
//    public static native String filPrivateKeySign(byte[] privateKey, String message);

    static {
        System.loadLibrary("bls_signatures_rs");
    }
}
