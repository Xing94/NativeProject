package com.lxx.nativeproject;

import org.bitcoinj.crypto.MnemonicException;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws MnemonicException.MnemonicLengthException, MnemonicException.MnemonicChecksumException, MnemonicException.MnemonicWordException {

        String ss = "eantEZyAVp8Q/DVDfucxHNGWgrnBXEeLpeFLVmxpXms=";
        System.out.println(Hex.toHexString(Base64.decode(ss)));
    }
}