package org.quarkus.dto;

import org.quarkus.model.AccountStatus;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,
        Long accountNumber,
        Long customerNumber,
        String customerName,
        BigDecimal balance,
        AccountStatus accountStatus
) {
}
