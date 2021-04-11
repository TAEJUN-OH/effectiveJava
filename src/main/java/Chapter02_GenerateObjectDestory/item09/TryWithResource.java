package Chapter02_GenerateObjectDestory.item09;

import java.io.*;

/**
 * try-finally 보다는 try-with-resources 를 사용하라
 */


/**
 * try-with-resources - 자원을 회수하는 최선책!
 * 닫아야 하는 자원을 뜻하는 클래스를 작성한다면 AutoCloseable 을 반드시 구현해라.
 */
public class TryWithResource {
    static String firstLineOfFile(String path , String defaultVal) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal; //파일을 열거나 데이터를 읽지 못할때 예외 대신 기본값을 반환한 예
        }
    }
    //readLine과 (코드에서는 나타나지 않는)close 호출 양쪽에서 예외가 발생하면,
    //close에서 발생한 예외는 숨겨지고 readLine에서 발생한 예외가 기록된다.
    //이렇게 숨겨진 예외들도 그냥 버려지지는 않고, 스택 추적 내역에 '숨겨졌다(suppressed)'는 꼬리표를 달고 출력된다.

    /**
     * 복수의 자원을 처리하는 try-with-resources - 짧고 매혹적이다!
     */
    private static final int BUFFER_SIZE = 10; //임시
    static void copy(String src, String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf,0, n);
            }
        }
    }
}

/**
 * 핵심정리.
 * 꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고, try-with-resources 를 사용하자.
 * 예외는 없다. 코드는 더 짧고 분명해지고, 만들어지는 예외 정보도 훨씬 유용하다.
 */


