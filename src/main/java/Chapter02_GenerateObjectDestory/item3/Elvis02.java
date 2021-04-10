package Chapter02_GenerateObjectDestory.item3;


/**
 * 정적 팩터리 방식의 싱글턴
 */
public class Elvis02 {
    private static final Elvis02 INSTANCE = new Elvis02();
    private Elvis02(){}

    public static Elvis02 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding(){}
}

//Elvis02.getInstance 는 항상 같은 객체의 참조를 반환하므로 제2의 Elvis02 인스턴스란
//결코 만들어지지 않는다.(역시 리플렉션을 통한 예외는 똑같이 적용된다.)