package key;

public class XEncryptModule {
    public String EncryptX(int key, int prime, String txt) throws Exception{
        System.out.println();
        System.out.println("<< EncryptX >>");
        System.out.println("<< X 암호 알고리즘 작업 중 >>");

        char[] txtArr = txt.toCharArray();
        int ascii = 0;  //byte나 short가 안되는 이유는 char가 0부터 시작하고, 쟤들은 음수부터 시작.. 공간은 있어도 형변환 안됨
        int res = 0;
        String ChiperTxt = "";
        for (int i = 0; i < txtArr.length; i++){
            ascii = (char)txtArr[i]; //txtArr[i]랑 둘다 0.04~6초대나오는데 형변환 하긴 하지만 (char)txtArr로 간다. 속조 좀 좋게 나오네
            res = (key*ascii)%prime;
            ChiperTxt = ChiperTxt + (char)res;
        }
       // System.out.println(ChiperTxt);

        return ChiperTxt;
    }
}

// int res = (key*txt)%prime;
// return res;