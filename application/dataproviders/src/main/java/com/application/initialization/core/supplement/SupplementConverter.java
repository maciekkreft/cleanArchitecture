package com.application.initialization.core.supplement;

import com.application.dataproviders.supplement.Supplement;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class SupplementConverter {

    @NonNull
    public static List<Supplement> toRows(SupplementsJson jsonAsObject) {
        return jsonAsObject.getSupplements().stream()
                .map(s -> new Supplement(s.getCode(), s.getName()))
                .collect(Collectors.toList());
    }
}
