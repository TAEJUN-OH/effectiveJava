package Chapter02_GenerateObjectDestory.item3;

/**
 * 싱글턴(singleton) 이란 ?
 * 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.
 * 무상태(statelss)객체나 설계상 유일해야 하는 시스템 컴포넌트를 들 수 있다.
 */

/**
 * public static final 필드 방식의 싱글턴
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis(){}

    public void leaveTheBuilding(){}
}
