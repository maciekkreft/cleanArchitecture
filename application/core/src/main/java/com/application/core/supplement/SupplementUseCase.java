package com.application.core.supplement;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SupplementUseCase {
    private final SupplementDataGateway supplementDataGateway;

    public List<SupplementEntity> listAllSupplements() {
        return supplementDataGateway.getAllSupplements();
    }
}
