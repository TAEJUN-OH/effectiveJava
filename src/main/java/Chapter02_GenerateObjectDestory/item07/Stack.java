package Chapter02_GenerateObjectDestory.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 다 쓴 객체 참조를 해제하라.
 */

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /////////메모리 누수가 일어나는 위치 ///////////
//    public Object pop() {
//        if (size == 0) {
//            throw new EmptyStackException();
//        }
//        return elements[--size];
//    }
    //스택에서 꺼내진 객체들을 더 이상 사용하지 않더라도 가비지 컬렉터가 회수하지 않는다.
    //이 스택이 그 객체들의 다 쓴 참조(obsolete reference)를 여전히 가지고 있기 때문이다.
    //여기서 다 쓴 참조란 앞으로 다시 쓰지 않을 참조를 뜻한다.


    /**
     * 제대로 구현한 pop 메서드
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }


    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 떄마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
