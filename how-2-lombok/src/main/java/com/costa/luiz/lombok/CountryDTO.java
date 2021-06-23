package com.costa.luiz.lombok;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {

    private Integer id;
    private String name;
    private String code;
    private String continent;
}
