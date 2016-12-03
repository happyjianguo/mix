package test.common;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by joshua on 16/12/3.
 */
public class CommonCodec {

    public static void main(String[] args){
        String str = "中国";
        Base64 base64 = new Base64();
        try{
            str = base64.encodeToString(str.getBytes("UTF-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        System.out.println("Base64 encode: " + str);

        str = new String(Base64.decodeBase64(str));
        System.out.println("Base64 decoding: "+ str);
    }
}
