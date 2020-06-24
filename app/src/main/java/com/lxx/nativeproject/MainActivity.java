package com.lxx.nativeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lxx.nativerust.FilecoinBlsSignUtil;


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
        String seed = "4c279adb09ad7bad4f9f83b52c9faf373c7d19dc6b9d8d02075463d181ea9f05";
        String privateKeySeed = FilecoinBlsSignUtil.generateBlsSeed();

//        String ons = new String(Hex.decode("4b9d122b1b277ade492dff84f4f4ea3c928a7fe47bb59cb421d501f298ca4e2c"));

        String publicKey = FilecoinBlsSignUtil.filPrivateKeyPublicKey("b12d151a8de9ec75e8b863f67075687feb05186a3d8571159963bae177e8aa0d");
        String privateKey = FilecoinBlsSignUtil.filPrivateKeyGenerateWithSeed("4c279adb09ad7bad4f9f83b52c9faf373c7d19dc6b9d8d02075463d181ea9f05");
        System.out.println(publicKey);
        System.out.println(privateKey);

//        String message = "hello foo";
        String message = "0171a0e40220dbcb39aa11eca8f35eee1b28228baf5dc1fe458c1a02e579bf7f259182e7d17f";
//        String message = "0171a0e4022023e5214bbc9befe3b2ff91cb3baef6078e420bca07393fe2a2164f39f87139f6";

        String sign = FilecoinBlsSignUtil.filPrivateKeySign(privateKey, message);
//        String sign = FilecoinBlsSignUtil.filPrivateKeySign(Hex.decode(privateKey), message);
//        List<Byte> sign = FilecoinBlsSignUtil.filPrivateKeySign(privateKey, message);

//        a2846bb9aa4e99199ce297aac4c9f30025d74e8bd74dab01ae775fea89e39b74cc7325b3c824f52672e9cff0a6ab2a1f028259b5af066980ee4705010586d71ffd278c63d1fb9a47000fb62e76fb13466fa8305bcf4453f7c2ccd6782f0d9f10
//        a2846bb9aa4e99199ce297aac4c9f30025d74e8bd74dab01ae775fea89e39b74cc7325b3c824f52672e9cff0a6ab2a1f028259b5af066980ee4705010586d71ffd278c63d1fb9a47000fb62e76fb13466fa8305bcf4453f7c2ccd6782f0d9f10

        System.out.println("sign：" + sign);

    }
}
