package org.yeongtae.global.validators;

/**
 * 필수 항목 체크
 *
 */

// RequiredValidator 인터페이스는 필수 항목을 체크하는 기능을 가지고 있습니다.
public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }
}
