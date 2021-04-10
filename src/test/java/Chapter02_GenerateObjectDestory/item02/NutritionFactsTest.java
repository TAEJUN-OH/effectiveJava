package Chapter02_GenerateObjectDestory.item02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutritionFactsTest {
    @Test
    public void 빌더패턴_영양소_클라이언트코드() {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}