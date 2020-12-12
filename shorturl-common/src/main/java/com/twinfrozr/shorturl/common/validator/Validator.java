package com.twinfrozr.shorturl.common.validator;

import java.util.Collection;

import com.twinfrozr.shorturl.common.exception.IllegalArgumentBusinessException;
import com.twinfrozr.shorturl.common.exception.LocalError;
import com.twinfrozr.shorturl.common.exception.NullPointerBusinessException;
import org.apache.commons.lang3.Validate;
import org.springframework.util.StringUtils;

/**
 * validator
 * @author mavin
 */
public class Validator extends Validate {

    public static <T> T notNull(final T object, LocalError localError) {
        if (object == null) {
            throw new NullPointerBusinessException(localError);
        }
        return object;
    }

    public static <T> T isNull(final T object, LocalError localError) {
        if (object != null) {
            throw new NullPointerBusinessException(localError);
        }
        return object;
    }

    public static <T extends CharSequence> T notBlank(final T chars, LocalError localError) {
        if (chars == null) {
            throw new NullPointerBusinessException(localError);
        }
        if (!StringUtils.hasLength(chars)) {
            throw new IllegalArgumentBusinessException(localError);
        }
        return chars;
    }

    public static <T extends CharSequence> T notEmpty(final T chars, LocalError localError) {
        if (chars == null) {
            throw new NullPointerBusinessException(localError);
        }
        if (chars.length() == 0) {
            throw new NullPointerBusinessException(localError);
        }
        return chars;
    }

    public static <T extends Collection> T notEmpty(final T collection, LocalError localError) {
        if (collection == null) {
            throw new NullPointerBusinessException(localError);
        }
        if (collection.size() == 0) {
            throw new NullPointerBusinessException(localError);
        }
        return collection;
    }

    public static void isNotZero(final int id, LocalError localError) {
        if (id == 0) {
            throw new NullPointerBusinessException(localError);
        }
    }

    public static void isTrue(boolean expression, LocalError localError) {
        if (expression == false) {
            throw new NullPointerBusinessException(localError);
        }
    }
}