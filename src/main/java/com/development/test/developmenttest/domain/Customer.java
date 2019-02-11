package com.development.test.developmenttest.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RedisHash("Customer")
public class Customer {

    private @Getter @Setter String id;

    @NotNull(message = "Campo nome obrigatório")
    private @Getter @Setter String name;

    @NotNull(message = "Campo limite de crédito obrigatório")
    private @Getter @Setter BigDecimal limitCredit;

    @NotNull(message = "Campo risco obrigatório")
    private @Getter @Setter String risc;

    private @Getter @Setter Integer rate;

}
