package com.lxx.nativerust;

import java.util.List;

public class FilecoinBlsSignUtil {

    //生成bls私钥
    public static native String generateBlsSeed();

    public static native String filPrivateKeyGenerateWithSeed(String seed);

    public static native String filPrivateKeyPublicKey(String privateKey);

    /**
     * cid的方式与Secp256k1签名方式一致，需将cid的字节数组转换为hex值，传入进来，
     * 输出值为已经hex的签名的值，最后需要将其转换为base64，放到message中，传入接口
     */
    public static native String filPrivateKeySign(String privateKey, String message);
//    public static native String filPrivateKeySign(byte[] privateKey, String message);

    static {
        System.loadLibrary("fil_bls_sign_rs");
    }
}
