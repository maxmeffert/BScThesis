package org.softlang.maxmeffert.bscthesis.core.utils;

import com.google.common.base.Strings;

public class StringUtils implements IStringUtils {
    @Override
    public boolean isNullOrEmpty(String string) {
        return Strings.isNullOrEmpty(string);
    }
}
