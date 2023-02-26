package file;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

import static start.GameStart.XConsole;

public class TxtReader {
    public String TxtReader(String txtFile) throws IOException {
        String txtWork = ""; //파일 -> 문자열 변수 작업용
        String txtUnion = ""; //문자열 결합

        try {
            BufferedReader reader = new BufferedReader(new FileReader(txtFile, Charset.forName("UTF-8")));
            //C:\Users\NetMon\Desktop\더큰내일\0.업프로젝트\EncryptionX

            System.out.println('\n' + "<< TxtReader >>");
            System.out.println("<< 파일 읽기 작업중 >>");

            int i = 0; //첫문장 체크용
            while ((txtWork=reader.readLine()) != null){
                if (i == 0){
                    txtUnion = txtUnion + txtWork;
                    i++;
                } else {
                    txtUnion = txtUnion + "\r\n" + txtWork  ; //BufferedReader은 개행문자(\r\n) 필요
                }
                //System.out.println("-파일 읽는 중 : " + txtUnion);
            } //end while //end while

            System.out.println("-확인된 파일 내용 : " + txtUnion);
            System.out.println("-파일 길이 : " + txtUnion.length());

            reader.close();

            }//end if try
         catch (FileNotFoundException e) {
            System.out.println("test.txt 또는 복호화 파일을 찾지 못함... 만들어줘..");
            XConsole();
        } catch (Exception e){
            e.printStackTrace();
        }
        return txtUnion;
    }//end TxtReader()
}//end TxtReader class


/*
        String Base64Enccode = ""; //Base64 인코딩 변수
            //<<암호화를 위한 Base64 인코딩>>
            Base64Enccode = Base64.getEncoder().withoutPadding().encodeToString(txtUnion.getBytes());
            System.out.println("Base64 인코딩 : " + Base64Enccode);
*/

/*
            while ((txtWork=reader.readLine()) != null){
                txtUnion = txtUnion + txtWork + "\r\n" ; //BufferedReader은 개행문자(\r\n) 필요
                System.out.println("-파일 읽는 중 : " + txtWork);
            } //end while //end while
  */
        /*finally {
            if(reader != null){
                System.out.println("파일 읽기 종료");

            } //end if finally
        } //end try & finally
        */



        /*
//성능 0.03x대
      int txts1 = 0; //문자열 작업 공간
        int ascii = 0; //아스키코드
        String txts2 = "오호진";
        try {
            File file = new File(txtFile);
            FileReader filereader = new FileReader(file);
            //     FileWriter filewriter = new FileWriter("[new]" + file);



            while ((txts1 = filereader.read()) != -1) { //파일 다 읽으면 -1 반환한다.
                ascii = (char) txts1;
                System.out.println("ascii : " + ascii); // 아스키
                System.out.println("txts : " + (char) txts1); //문자
                System.out.println();
                txts2 = txts2 + (char)txts1;
            }
            System.out.println(txts2);
            String base64test = Base64.getEncoder().withoutPadding().encodeToString(txts2.getBytes());
            System.out.println("base64 : " + base64test);
            String base64decode = new String(Base64.getDecoder().decode(base64test));
            System.out.println("디코드는 : " + base64decode);

            filereader.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못함... TxtReader.java");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txts2;
*/

/* Scanner 0.06초 정도??
        try {
            File file = new File(txtFile);
            Scanner scan = new Scanner(file);

            int txts1 = 0; //문자열 작업 공간
            int ascii = 0; //아스키코드
            String txts2 = "오호진";

            while (scan.hasNextLine()) {
                System.out.println("count : " + ascii);
                System.out.println(scan.nextLine());
                ascii++;

            }
            System.out.println("txts2 : " + txts2);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못함... TxtReader.java");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/