package com.edgardomingues.code39;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Code39Test {

    @Test
    void calcCheckDigit() {
        assertThat(Code39.calcCheckDigit("5123")).isEqualTo('B');
    }

}