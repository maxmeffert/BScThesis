package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class IoC {
    private static Injector injector;

    private static Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new IoCConfig());
        }
        return injector;
    }

    public static <T> T get(Class<T> type) {
        return getInjector().getInstance(type);
    }

}
