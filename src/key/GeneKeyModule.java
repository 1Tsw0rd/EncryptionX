package key;
public class GeneKeyModule {
    public static int XPrimeNum; //소수 => 입력값 또는 DB 저장된 값으로
    public static int XPublicKey; //공개키
    public static int XPrivateKey; //개인키

    public GeneKeyModule(int XChoiceNum){
        this.XPrimeNum = XChoiceNum;
        this.XPublicKey = (XPrimeNum - 1) / 2;
        this.XPrivateKey = (XPrimeNum - 2);


        System.out.println("<< Key 생성 완료 >>");
        /*
        System.out.println("XChoiceNum : " + XChoiceNum);
        System.out.println("XPrimeNumber : " + XPrimeNum);
        System.out.println("XPublicKey : " + XPublicKey);
        System.out.println("XPrivateKey : " + XPrivateKey);
        System.out.println();
        */
    }
}
