package Chapter02_GenerateObjectDestory.item04;


/**
 * 인스턴스화를 막으려거든 private 생성자를 사용하라.
 */
public class UtilityClass {
    //기본 생성자가 만들어지는 것을 막는다.(인스턴스화 방지용)

    private UtilityClass() {
        throw new AssertionError();
    }
    // 나머지 코드 생략.
}

//명시적 생성자가 private 이니 클래스 바깥에서는 접근할 수 없다.
//모든 생성자는 명시적이든 묵시적이든 상위 클래스의 생성자를 호출하게 되는데, 이를 private 으로 선언했으니
//하위 클래스가 상위 클래스의 생성자에 접근할 길이 막혀버린다.