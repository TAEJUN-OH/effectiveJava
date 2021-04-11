package Chapter02_GenerateObjectDestory.item06;

import java.util.regex.Pattern;

/**
 * 불필요한 객체 생성을 피하라.
 */

/**
 * 값비싼 객체를 재사용해 성능을 개선한다.
 */
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD] | D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}

//Pattern 인스턴스는 한 번 쓰고 버려져서 곧바로 가비지 컬렉션 대상이 되므로
//Pattern 인스턴스를 클래스 초기화(정적 초기화) 과정에서 직접 생성해 캐싱해두고,
//나중에 isRomanNumeral 메서드가 호출될 때마다 이 인스턴스를 재사용하다.
