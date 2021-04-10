package Chapter02_GenerateObjectDestory.item3;

/**
 * 열거 타입 방식의 싱글턴 - 바람직한 방법
 */
public enum Elvis03 {
    INSTANCE;

    public void leaveTheBuilding(){}
}

//대부분 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴읃 만드는 가장 좋은 방법이다.
//단, 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 이 방법을 사용할 수 없다.
