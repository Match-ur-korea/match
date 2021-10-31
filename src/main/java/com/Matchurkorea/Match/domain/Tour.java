package com.Matchurkorea.Match.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tour {
    private String userId;
    private String tourId;
    private String contentId;

    @Override
    public String toString() {
        return "Tour{" +
                "userId='" + userId + '\'' +
                ", tourId='" + tourId + '\'' +
                ", contentId='" + contentId + '\'' +
                '}';
    }
}
