package Chapter02_GenerateObjectDestory.item05;

import java.util.List;
import java.util.Objects;

/**
 * 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 */
public class SpellChecker {
    private final String dictionary;

    public SpellChecker(String dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word){return true;}
    public List<String> suggestions(String typo){return null;}
}

//사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않다.
// 대신 클래스(SpellChecker)가 여러 자원 인스턴스를 지원해야하며,
//클라이언트가 원하는 자원(dictionary)을 사용해야 한다
// *** 인스턴스를 생성할때 생성자에 필요한 자원을 넘겨주는 방식이다.
// 이는 의존 객체 주입의 한 형태로, 맞춤법 검사기를 생성할 때 의존 객체인 사전을 주입해 주면 된다.


//핵심 정리
//클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면
//싱글턴과 정적 유틸리티 클래스는 사용하지 않는 것이 좋다. 이 자원들을 클래스가 직접 만들게 해서도 안된다.
//대신 필요한 자원을(혹은 그 자원을 만들어주는 팩터리를) 생성자에(혹은 정적 팩터리나 빌더에) 넘겨주자.
//의존 객체 주입이라 하는 기법은 클래스의 유연성, 재사용성, 테스트 용이성을 기막히게 개선해준다.