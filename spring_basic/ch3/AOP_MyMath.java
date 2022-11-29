
import org.springframework.stereotype.Component;

@Component
public class MyMath {       // 핵심 기능(target)으로 사용할 클래스
    public int add(int a, int b) {
        return a+b;
    }

    public int add(int a, int b, int c) {
        return a+b+c;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }
}
