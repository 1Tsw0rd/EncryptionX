package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class TxtWriter {
    public static void TxtWriter(String ChiperTxt, String fileFront ) throws IOException {

        //while 이용해서 같은 파일 있으면 이름 뒤에 (a)추가하게 하자!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

          try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileFront + "test.txt"));
            //C:\Users\NetMon\Desktop\더큰내일\0.업프로젝트\EncryptionX
            //  System.out.println("암호화할 데이터 " + ChiperTxt);
              System.out.println('\n'+"<< TxtWriter >>");

            if (ChiperTxt != null){
                System.out.println(fileFront + "test.txt 파일 제작중...");
                writer.write(ChiperTxt);
              //writer.newLine(); 불필요
                writer.flush();
                writer.close();
                System.out.println(fileFront + "test.txt 파일 제작완료");
            }
        } catch (IOException e) {
            System.out.println("TxtWriter 오류 발생!!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

/*
         String Base64Decode = ""; //Base64 디코딩 변수
            String Base64Decode = new String(Base64.getDecoder().decode(ChiperTxt));
            System.out.println("디코드는 : " + Base64Decode);
 */