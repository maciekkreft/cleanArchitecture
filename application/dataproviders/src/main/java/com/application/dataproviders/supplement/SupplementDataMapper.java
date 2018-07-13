package com.application.dataproviders.supplement;

import com.application.core.supplement.SupplementDataGateway;
import com.application.core.supplement.SupplementEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class SupplementDataMapper implements SupplementDataGateway {
    private final SupplementRepository supplementRepository;

    @Override
    public List<SupplementEntity> getAllSupplements() {
        return toEntity(supplementRepository.findAll());
    }

    private List<SupplementEntity> toEntity(Iterable<Supplement> rows) {
        return StreamSupport.stream(rows.spliterator(), false)
                .map(r -> new SupplementEntity(
                        r.getCode(),
                        r.getName(),
                        r.getDose(),
                        r.getDosing()
                ))
                .collect(Collectors.toList());
    }
}
