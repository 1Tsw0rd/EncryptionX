package key;

import java.util.Base64;

public class Base64Work {
    public String Base64Encode(String txt){

        String Base64Enccode = ""; //Base64 인코딩 변수

        try {
            if(txt != null){
            //<<암호화를 위한 Base64 인코딩>>
                System.out.println('\n' + "<<Base64Encode>>");
                System.out.println("-Base64 인코딩 대상 : " + txt);
                Base64Enccode = Base64.getEncoder().withoutPadding().encodeToString(txt.getBytes());
                System.out.println("-Base64 인코딩 결과 : " + Base64Enccode);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return Base64Enccode;
    }

    public String Base64Decode(String txt) {
        String Base64Decode = ""; //Base64 디코딩 변수

        try {
            if (txt != null) {
                //<<암호화를 위한 Base64 디코딩>>
                System.out.println('\n' + "<<Base64Decode>>");
                System.out.println("-Base64 디코딩 대상 : " + txt);

                Base64Decode = new String(Base64.getDecoder().decode(txt));
                System.out.println("-Base64 디코딩 결과 : " + Base64Decode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64Decode;
    }
}
