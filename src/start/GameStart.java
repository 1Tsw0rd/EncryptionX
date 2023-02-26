package start;

import file.TxtReader;
import file.TxtWriter;
import key.Base64Work;
import key.GeneKeyModule;
import key.XEncryptModule;
import kisa.Seed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameStart {

    //1-1. Key 변수
    private static int PrimeNum; //소수
    private static int PublicKey; //공개키
    private static int PrivateKey; //개인키

    //1-2. Key 생성 참조변수...
    private static GeneKeyModule getKey(int ChoiceNum){
        return new GeneKeyModule(ChoiceNum);
    }

    //콘솔 입력변수
    protected static BufferedReader ConsoleIn = null;

    public static void main(String[] args) {
        XConsole();
    }//end main

    public static void XConsole(){
        try {
            //do while로 계속 반복은 고민
            ConsoleIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("                      ,w                          \n" +
                    "                ,Dy5Dy,  XXXXX9,                 \n" +
                    "             ,DDW        XXXXXXXXXXB              \n" +
                    "           wBW           ZZZZZZZZZZZZZ            \n" +
                    "          Bw             ZZZZTESTZZZZZZZ          \n" +
                    "        jD               ZZZZZZZZZZZZZZZZ,        \n" +
                    "       yj                ZZZZZZBASE64ZZZZZD       \n" +
                    "      jj                 ZZZZZZZZZZZZZZZZZZW      \n" +
                    "      z                  ZZZZZENCRYPTIONXZZZ      \n" +
                    "     z       ZZZZZ       ZZZZZZZZZZZZZZZZZZZZ     \n" +
                    "     z     ,ZPRIMEZZ     ZZZZWZZZSEEDZZZZZZZZZ     \n" +
                    "     B     WZZ127ZZZ     ZZZZW           ZZZZX     \n" +
                    "     D      9Z2ZZZZ      ZZZZZZZZSEEDZZZZZZZZX     \n" +
                    "     B        7W9        ZWZZZZZENCRYPTIONXZZZ     \n" +
                    "     8                 ZZ  ZZZZZZZZZZZZZZZZZZ     \n" +
                    "     D              yZZZ Z   8ZZZZZBASE64ZZZ9     \n" +
                    "      8         ZZZZZZZZ Z5       ZZZXXZZZZZ      \n" +
                    "      ,D        ZZZZZZZ  ZZz      ZZZZZZZZZ       \n" +
                    "       wD       ZZZZZ    ZZZZ     ZZZZZZZZ        \n" +
                    "         z      Z5       ZZZZZZZ8 ZZZZZZZ         \n" +
                    "          D5             ZZZZZZZZZZZZZZ5          \n" +
                    "            B5           ZZZZZZZZZZZZ8            \n" +
                    "              yD5,       XZZZZZZZZZZ               \n" +
                    "                 WD5y55j ZZZZZ8,                  \n\n" +
                    "          ///////////////////////////             \n" +
                    "          //    U don't know me    //             \n" +
                    "          //     but i know U      //              \n" +
                    "          ///////////////////////////              \n");
            //by Mr.Oh (2022-07-15 AM 1:38)

            System.out.println("<< Encryption X Menu >>");
            System.out.println("1. Generate key - Public key system");
            System.out.println("2. Encrypt X - (준비사항)암호화 대상 파일명 : test.txt");
            System.out.println("3. Decrypt X - 이건 복구...");
            System.out.println("입력 : ");

            String choice = ConsoleIn.readLine();

            switch (choice){
                case "1":
                    System.out.println('\n' + "<< 1. Generate key - Public key system >>");
                    XGeneKeys();
                    XConsole();
                    break;
                case "2":
                    System.out.println('\n' + "<< 2. Encrypt X >>");
                    System.out.println("이건 암호화...");
                    EncryptX();
                    XConsole();
                    break;
                case "3":
                    System.out.println('\n' + "<< 3. Decrypt X >>");
                    System.out.println("이건 복호화...");
                    DecryptX();
                    XConsole();
                    break;
                default:
                    System.out.println("뭐하냐... 넌 이거 쓰지마 凸(`д´#)");
                    Thread.sleep(5000); //5초 대기했다가 종료
                    System.exit(0); //응.. 잘가...
            }
            ConsoleIn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }//end XConsole()
    private static void XGeneKeys() throws IOException {

        //속도 테스트-시작
        long start = System.currentTimeMillis();

        int num = 0;
        int primeCk2 = 0; //소수판별 나누기 2
        int primeCk3 = 0; //소수판별 나누기 3

        do {
            //1. 소수 입력 및 127이상 소수 체크
            System.out.println("127 이상 소수 입력 : ");
            num = Integer.parseInt(ConsoleIn.readLine());
            primeCk2 = num%2;
            primeCk3 = num%3;
        }
        while (num <= 126 || primeCk2 == 0 || primeCk3 == 0);

        if (num >=127){
            //2. 공개키 & 개인키 세팅
            GeneKeyModule XKeys = getKey(num); //범위 127 이상
            PrimeNum = XKeys.XPrimeNum;
            PublicKey = XKeys.XPublicKey;
            PrivateKey = XKeys.XPrivateKey;

            System.out.println("<< 생성된 값들 - 메모하세요 >>");
            System.out.println("소수는 : " + PrimeNum);
            System.out.println("공개키는 : " + PublicKey);
            System.out.println("개인키는 : " + PrivateKey);

        } else {
            System.out.println("담당자에게 연락하세요....");
        }
        //return; 초기메뉴 가는거..

        //속도 테스트-끝
        long end = System.currentTimeMillis();
        System.out.println('\n' + "실행 시간 : " + ( end - start )/1000.0 + "초");
    } //end XGeneKeys()

    private static void EncryptX() throws Exception {
        //속도 테스트-시작
        long start = System.currentTimeMillis();

        //<< 암호화 >>
        //1-1. txt 파일 읽기
        TxtReader TxtR = new TxtReader();
        String TxtEn = TxtR.TxtReader("test.txt");
        System.out.println("★★파일 읽기 성공★★");// 결과 : " + TxtEn);

        //1-2. Base64 인코딩 - X 암호화 위해
        Base64Work Base64En = new Base64Work();
        TxtEn = Base64En.Base64Encode(TxtEn);
        System.out.println("★★Base64 인코딩 성공★★");//"결과 : " + TxtEn);
/*
        //테스트
        Seed seed = new Seed();
        String decryptedMessage = TxtEn;
        Base64Work Base64Dn = new Base64Work();
        String TxtEn2 = Base64Dn.Base64Decode(decryptedMessage);
        System.out.println('\n' + "★Base64 디코딩 성공 결과 : " + TxtEn2);
*/
        //1-3. 공개키 암호 - X 암호
        String Xresult = "";
        XEncryptModule testX = new XEncryptModule();

        int YorN = 0;
        do {
            //(공개)키 및 소수 입력
            System.out.println("(공개)키 입력 : ");
            PublicKey = Integer.parseInt(ConsoleIn.readLine());

            System.out.println("소수 입력 : ");
            PrimeNum = Integer.parseInt(ConsoleIn.readLine());

            System.out.println("(공개)키 값 : " + PublicKey + " || 소수 값 : " + PrimeNum);
            System.out.println("!!!!! (주의)키 및 소수 값이 0 이하인 경우 미실행 됨 !!!!!");
            System.out.println("!!!!! (주의)잘못된 값 입력 시 미실행 됨 !!!!!");
            System.out.println("실행하시겠습니까?(1: 실행) : ");
            YorN = Integer.parseInt(ConsoleIn.readLine());

            System.out.println("y" + YorN);
        }
        while (YorN != 1 || PublicKey <= 0 || PrimeNum <= 0);

        //공개키 암호 - X 암(복)호화 - Public Key
        Xresult = testX.EncryptX(PublicKey, PrimeNum, TxtEn);

        System.out.println("<< X 암호화 결과 >> " + '\n' + Xresult); //여기가 이상한 애나와 SEED로 한번 더 ㄱㄱ

        //1-4. 대칭키 암호 - SEED 암호화
        Seed seed = new Seed();
        String encryptedMessage = seed.seedEncrypt(Xresult);
        System.out.println('\n' + "★SEED 암호화 결과 => " + encryptedMessage);
        System.out.println("파일 길이 : " + encryptedMessage.length());

        //1-5. 결과 파일 생성
        TxtWriter TxtW = new TxtWriter();
        TxtW.TxtWriter(encryptedMessage, "[Encrypt-X]");

        //속도 테스트-끝
        long end = System.currentTimeMillis();
        System.out.println('\n' + "암호화 사용 시간 : " + ( end - start )/1000.0 + "초");
    }//end EncryptX()

    private static void DecryptX() throws Exception {
        //속도 테스트-시작
        long start = System.currentTimeMillis();

        //<< 복호화 >>
        //1-1. txt 파일 읽기
        TxtReader TxtR = new TxtReader();
        String TxtDn = TxtR.TxtReader("[Encrypt-X]test.txt");
        System.out.println('\n' + "★★파일 읽기 성공 결과★★"); // + TxtDn +  TxtDn.length());

        //1-2. 대칭키 암호 SEED - 복호화
        Seed seed = new Seed();
        String decryptedMessage = seed.seedDecrypt(TxtDn);
        System.out.println("★SEED 복호화 결과 => "+ '\n' + decryptedMessage);

        int YorN = 0;
        do {
            //(공개)키 및 소수 입력
            System.out.println("(개인)키 입력 : ");
            PrivateKey = Integer.parseInt(ConsoleIn.readLine());

            System.out.println("소수 입력 : ");
            PrimeNum = Integer.parseInt(ConsoleIn.readLine());

            System.out.println("(개인)키 값 : " + PrivateKey + " || 소수 값 : " + PrimeNum);
            System.out.println("!!!!! (주의)키 및 소수 값이 0 이하인 경우 미실행 됨 !!!!!");
            System.out.println("!!!!! (주의)잘못된 값 입력 시 미실행 됨 !!!!!");
            System.out.println("실행하시겠습니까?(1: 실행) : ");
            YorN = Integer.parseInt(ConsoleIn.readLine());

            System.out.println("y" + YorN);
        }
        while (YorN != 1 || PrivateKey <= 0 || PrimeNum <= 0);

        //1-3. 공개키 암호 - X 암호
        String Xresult = "";
        XEncryptModule testX = new XEncryptModule();
        //공개키 암호 - X 암(복)호화 - Pribate Key
        Xresult = testX.EncryptX(PrivateKey, PrimeNum, decryptedMessage); //특징이지.. 같은 암호 알고리즘으로 작업함
        System.out.println("복호문 : " + Xresult);

        //1-4. Base64 디코딩 - X 암호화 위해
        Base64Work Base64Dn = new Base64Work();
        TxtDn = Base64Dn.Base64Decode(Xresult);
        System.out.println('\n' + "★★Base64 디코딩 성공★★");// 결과 : " + TxtDn);

        //1-5. 결과 파일 생성
        TxtWriter TxtW = new TxtWriter();
        TxtW.TxtWriter(TxtDn, "[Decrypt-X]");

        //속도 테스트-끝
        long end = System.currentTimeMillis();
        System.out.println('\n' + "복호화 사용 시간 : " + ( end - start )/1000.0 + "초");
    }//end DecryptX()
} //end class EncryptionX

//(보류)암호화 강도 강화 기능
//NotModule NotWork = new NotModule();
// Xresult = NotWork.NotCheck(Xresult); // 암호화 강화 Not 연산