package com.Matchurkorea.Match.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Area {
    서울("1","서울"),
    인천("2","인천"),
    대전("3","대전"),
    대구("4","대구"),
    광주("5","광주"),
    부산("6","부산"),
    울산("7","울산"),
    세종("8","세종"),
    경기도("31","경기도"),
    강원도("32","강원도"),
    충청북도("33","충청북도"),
    충청남도("34","충청남도"),
    경상북도("35","경상북도"),
    경상남도("36","경상남도"),
    전라북도("37","전라북도"),
    전라남도("38","전라남도"),
    제주도("39","제주도");

    private final String areacode;
    private final String areaname;

    Area(String areacode, String areaname){
        this.areacode = areacode;
        this.areaname = areaname;
    }

    private static final Map<String, String> AreaMap = Collections.unmodifiableMap( Stream.of(values()).collect(Collectors.toMap(Area::getAreacode, Area::name)));

    public static Area of(final String code){
        return Area.valueOf(AreaMap.get(code));
    }
}