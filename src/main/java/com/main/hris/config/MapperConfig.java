package com.main.hris.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class MapperConfig {
    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public static MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
