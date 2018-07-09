package com.application.entrypoints.rest.core.supplement;

import com.application.core.supplement.SupplementEntity;
import com.application.core.supplement.SupplementUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class SupplementController {
    private final SupplementUseCase supplementUseCase;

    @GetMapping
    public List<GetSupplementDto> listAllSupplements() {
        return toDto(supplementUseCase.listAllSupplements());
    }

    private List<GetSupplementDto> toDto(List<SupplementEntity> entities) {
        return entities.stream()
                .map(e -> new GetSupplementDto(e.getCode(), e.getName()))
                .collect(Collectors.toList());
    }
}
