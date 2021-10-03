package com.Matchurkorea.Match.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationPropertiesScan
public final class ApiProperties {

    @Getter
    @RequiredArgsConstructor
    public static final class Tourapi{
        private final String key;
    }

}
