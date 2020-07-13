package com.lxx.nativeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lxx.nativerust.FilecoinBlsSignUtil;

import org.bouncycastle.util.encoders.Hex;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //seedHex：	   4c279adb09ad7bad4f9f83b52c9faf373c7d19dc6b9d8d02075463d181ea9f05
    //privateKey： 256735df3d22d706b5e9de99e1c0b17303833bed0218c0cbd48002a84a1a6a51
    //publicKey：a8dba11a4dddda2170155939a5a283ff17c7f157882205069ab9e52aae93e0628b6f947b055b14c66069dd427bec7f46
    //t3ujfirc365mpke7zqscpeb6k7ej5hgvs4bdilxjmoehchzvamzojkdslsjt4xkjlncnu74m36z45pah5aqmzq

    @Override
    protected void onResume() {
        super.onResume();
        String privateKeySeed = FilecoinBlsSignUtil.generateBlsSeed();
        System.out.println("PrivateKeySeed：" + privateKeySeed);


        String privateKey = FilecoinBlsSignUtil.filPrivateKeyGenerateWithSeed(privateKeySeed);
        System.out.println("PrivateKey：" + privateKey);
        System.out.println("PrivateKeyError：" + FilecoinBlsSignUtil.filPrivateKeyGenerateWithSeed("这是一个错误"));


        String publicKey = FilecoinBlsSignUtil.filPrivateKeyPublicKey(privateKey);
        System.out.println("RightPublicKey：" + publicKey);
        System.out.println("ErrorPublicKey1：" + FilecoinBlsSignUtil.filPrivateKeyPublicKey("4adf1d40754a8c0e80e46b0ec0c2aaa65f9c9e61a2dfe8b37d9192bdc6ec8c8b"));
        System.out.println("ErrorPublicKey2：" + FilecoinBlsSignUtil.filPrivateKeyPublicKey("这是一个错误"));


        String message = "这个一个测试案例";
        String messageHex = Hex.toHexString(message.getBytes());
        String sign = FilecoinBlsSignUtil.filPrivateKeySign(privateKey, messageHex);
        System.out.println("SignMessage：" + sign);
        System.out.println("SignMessageError1：" + FilecoinBlsSignUtil.filPrivateKeySign(privateKey, "消息错误"));
        System.out.println("SignMessageError2：" + FilecoinBlsSignUtil.filPrivateKeySign("签名错误", messageHex));
        System.out.println("SignMessageError3：" + FilecoinBlsSignUtil.filPrivateKeySign("签名错误", "消息错误"));

    }
}
