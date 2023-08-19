package com.example.springpickytestcode.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayName("ComplexNumber 클래스")
class BDDTest {

    @Nested
    @DisplayName("of 메소드는")
    class Describe_of {
        private final double givenReal = 3d;
        private final double givenImagine = 3d;

        @Nested
        @DisplayName("만약 실수값만 주어지고 허수값은 없다면")
        class Context_with_real {

            @Test
            @DisplayName("i 값이 0 인 복소수를 리턴한다")
            void it_returns_a_valid_complex() {
                final ComplexNumber result = ComplexNumber.of(givenReal);

                Assertions.assertEquals(result.getImagine(), 0d, "리턴된 복소수는 허수 값으로 0 을 갖는다");
                Assertions.assertEquals(result.getReal(), givenReal, "리턴된 복소수는 실수 값으로 주어진 실수 값을 갖는다");
            }
        }

        @Nested
        @DisplayName("만약 실수값과 허수값이 주어진다면")
        class Context_with_real_and_i {
            @Test
            @DisplayName("주어진 실수값과 허수값을 갖는 복소수를 리턴한다")
            void it_returns_a_valid_complex() {
                final ComplexNumber result = ComplexNumber.of(givenReal, givenImagine);

                Assertions.assertEquals(result.getReal(), givenReal, "리턴된 복소수는 실수 값으로 주어진 실수 값을 갖는다");
                Assertions.assertEquals(result.getImagine(), givenImagine, "리턴된 복소수는 허수 값으로 주어진 허수 값을 갖는다");
            }
        }
    }

    @Nested
    @DisplayName("sum 메소드는")
    class Describe_sum {
        @Nested
        @DisplayName("만약 실수부와 허수부가 있는 두 복소수가 주어진다면")
        class Context_with_two_complex {
            private ComplexNumber a, b;

            @BeforeEach
            void prepareNumbers() {
                a = ComplexNumber.of(1d, 2d);
                b = ComplexNumber.of(32d, 175d);
            }

            ComplexNumber subject() {
                return ComplexNumber.sum(a, b);
            }

            @Test
            @DisplayName("실수부와 허수부가 올바르게 계산된 복소수를 리턴한다")
            void it_returns_a_valid_complex() {
                Assertions.assertEquals(a.getReal() + b.getReal(), subject().getReal(),
                        "리턴된 복소수는 두 실수 값의 합을 실수로 갖는다");
                Assertions.assertEquals(a.getImagine() + b.getImagine(), subject().getImagine(),
                        "리턴된 복소수는 두 허수 값의 합을 허수로 갖는다");
            }
        }
    }

    @Nested
    @DisplayName("toString 메소드는")
    class Describe_toString {
        @Nested
        @DisplayName("만약 실수값만 있고 허수값이 없다면")
        class Context_with_real {
            private final double givenNatual = 3d;
            private final String expectPattern = "^3(?:\\.0+)?$";
            private ComplexNumber given = ComplexNumber.of(givenNatual);

            @Test
            @DisplayName("실수부만 표현한 문자열을 리턴한다")
            void it_returns_a_valid_string() {
                assertTrue(given.toString().matches(expectPattern));
            }
        }

        @Nested
        @DisplayName("만약 실수값이 있고 허수값도 있다면")
        class Context_with_real_and_imagine {
            private final double givenNatual = 3d;
            private final double givenImagine = 7d;
            private ComplexNumber given = ComplexNumber.of(givenNatual, givenImagine);
            private String expectPattern = "^3(?:\\.0+)?\\+7(?:\\.0+)?i$";

            @Test
            @DisplayName("실수부 + 허수부i 형식으로 표현한 문자열을 리턴한다")
            void it_returns_a_valid_string() {
                assertTrue(given.toString().matches(expectPattern));
            }
        }
    }

    /**
     * 복소수를 정의한다
     */
    public static class ComplexNumber {
        private double real;
        private double imagine;

        private ComplexNumber() {
        }

        private ComplexNumber(double real, double imagine) {
            this.real = real;
            this.imagine = imagine;
        }

        public static ComplexNumber of(double real, double imagine) {
            return new ComplexNumber(real, imagine);
        }

        public static ComplexNumber of(double real) {
            return new ComplexNumber(real, 0);
        }

        /**
         * 두 복소수의 덧셈을 연산한다
         *
         * @param a 첫 번째 복소수
         * @param b 두 번째 복소수
         * @return 두 복소수의 합
         */
        public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
            return new ComplexNumber(a.real + b.real, a.imagine + b.imagine);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber complex = (ComplexNumber) o;
            return Double.compare(complex.real, real) == 0 &&
                    Double.compare(complex.imagine, imagine) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(real, imagine);
        }

        @Override
        public String toString() {
            if (imagine == 0D) {
                return String.format("%f", real);
            }
            return String.format("%f+%fi", real, imagine);
        }

        public double getReal() {
            return real;
        }

        public double getImagine() {
            return imagine;
        }
    }
}

