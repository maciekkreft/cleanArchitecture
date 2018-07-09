package com.application.dataproviders.supplement;

import com.application.core.supplement.SupplementDataGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupplementDataMapper implements SupplementDataGateway {
    private final SupplementRepository supplementRepository;
}
