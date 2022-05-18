package krosemann.lise.declarative.coding.kata

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Test {

    @ParameterizedTest
    @CsvSource(value = [
        "'',1,0",
        "a,0,1",
        "a,1,1",
        "b,1,2",
        "z,1,8",
        "abc,1,6",
        "iiii,1,36",
        "xyz,1,21",
        "z,2,8",
        "iiii,2,9",
        "xyz,2,3",
        "lise,1,27",
        "lise,2,9",
        "lise,3,9",
        "abcdefghijklmnopqrstuvwxyz,10,9"
    ])
    fun test(input: String, times: Int, expected: String) {
        println(input)
        println(times)
        println(expected)
        Assertions.assertThat(sumOfDigitsOfStringAfterConvert(input, times))
            .isEqualTo(expected)
    }
}
