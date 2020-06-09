package com.mina.spelDemo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Value("#{'Mina shaker'}")
    private String name;
    @Value("#{systemProperties['user.country']}")
    private String country;
    @Value("#{26}")
    private int age;
    @Value("#{systemProperties['user.language']}")
    private String language;
    @Value("#{systemProperties['user.timezone']}")
    private String timeZone;

    public User(@Value("#{systemProperties['user.country']}") String country,
                @Value("#{systemProperties['user.language']}") String language) {
        this.country = country;
        this.language = language;
    }
}
