package dialog;
public class VariableExample {
    // 정적 변수
    private static int staticVariable;
    
    // 인스턴스 변수
    private int instanceVariable;
    
    public static void main(String[] args) {
        // 객체 인스턴스 생성
        VariableExample instance1 = new VariableExample();
        VariableExample instance2 = new VariableExample();
        
        // 정적 변수 사용
        VariableExample.staticVariable = 10;
        System.out.println("정적 변수 staticVariable의 값: " + VariableExample.staticVariable);
        
        // 인스턴스 변수 사용
        instance1.instanceVariable = 20;
        instance2.instanceVariable = 30;
        System.out.println("인스턴스 변수 instanceVariable의 값 (instance1): " + instance1.instanceVariable);
        System.out.println("인스턴스 변수 instanceVariable의 값 (instance2): " + instance2.instanceVariable);
    }
}