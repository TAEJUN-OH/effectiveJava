package Chapter02_GenerateObjectDestory.item02;

/**
 * 생성자에 매개변수가 많다면 빌더를 고려하라.
 *
 * 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.
 * 쓰기 쉽고 읽기 쉽다.
 */
public class NutritionFacts {
    //매개변수들은 (기본값이 있다면) 기본값으로 초기화된다.
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium; //나트륨
    private final int carbohydrate; // 탄수화물

    public static class Builder{
        //필수 매개변수
        private final int servingSize;
        private final int servings;

        //선택 매개변수 - 기본값으로 초기화한다.
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings	 = builder.servings;
        calories	 = builder.calories;
        fat			 = builder.fat;
        sodium 		 = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    //NutritionFacts 클래스는 불변이며, 모든 매개변수의 기본값들을 한곳에 모아뒀다.
    //빌더의 세터 메서드들은 빌더 자신을 반환하기 때문에 연쇄적으로 호출할 수 있다.
    //이런 방식을 메서드 호출이 흐르듯 연결된다는 뜻으로 풀루언트API(fluent API) 혹은 메서드 연쇄(method chaining)라 한다.

    //이 클래스의 클라인트 코드
    NutritionFacts cocaCola = new NutritionFacts.Builder(240,8)
        .calories(100).sodium(35).carbohydrate(27).build();

}
