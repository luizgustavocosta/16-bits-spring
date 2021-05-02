package com.costa.luiz.spring.email;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {

    private final String to;
    private final String subject;
    private final String text;
}
