package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.dto.InputDto;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @DisplayName("자동차가 제대로 생성되는지 확인하는 테스트")
    @Test
    void createCarTest() {
        String[] carNames = {"pobi", "crong", "honux"};
        RacingGame racingCar = new RacingGame(new InputDto(new ArrayList<>(Arrays.asList(carNames)), 5));
        assertEquals(3, racingCar.getCarList().size());
    }

    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1"}, delimiter = ':')
    @ParameterizedTest(name = "자동차가 랜덤 수에 따라 움직이는지 안 움직이는지 테스트")
    void carMove(int randomNumber, int expected) {
        Car car = new Car("fobi");
        car.carCanGoJudge(randomNumber);
        assertThat(car.getDistance()).isEqualTo(expected);
    }
}