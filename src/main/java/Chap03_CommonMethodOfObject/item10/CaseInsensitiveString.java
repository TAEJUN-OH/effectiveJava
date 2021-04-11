package Chap03_CommonMethodOfObject.item10;

import java.util.Objects;

/**
 * equals 메서드를 재정의할 때는 반드시 일반 규약 5가지를 따라야 한다.
 * 다음은 Object 명세에 적힌 규약이다.
 *
 * equals 메서드는 동치관계를 구현하며, 다음을 만족한다.
 * 1. 반사성(reflexivity): null 이 아닌 모든 참조값 x에 대해, x.equals(x)는 true 다.
 * 2. 대칭성(symmetry) : null 이 아닌 모든 참조 값 x,y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.
 * 3. 추이성(transitivity): null 이 아닌 모든 참조값 x,y,z에 대해, x.equals(y)가 true이고 y.equals(z)도 true 이면 x.equals(z)도 true다 (삼단논법)
 * 4. 일관성(consistency) : null이 아닌 모든 참조값 x,y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
 * 5. null-아님 : null 이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.
 */

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    //대칭성 위배!
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(
//                    ((CaseInsensitiveString)o).s);
//        }
//        if (o instanceof String) { //한 방향으로만 동작한다!
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }

    // 대칭성을 만족하게 수정
    @Override public boolean equals(Object o){
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
        // String에 대한 instanceof 부분을 빼고 구현한다.
    }
}

//CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
//String s = "polish";
//
//cis.equals(s); // true
//s.equals(cis); // false


