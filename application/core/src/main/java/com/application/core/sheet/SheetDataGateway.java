package com.application.core.sheet;

import java.util.List;

public interface SheetDataGateway {
    SheetEntity findOneVersion(Long version, String pollCode, Long userId);
    SheetEntity findLastVersion(String pollCode, Long userId);
    List<SheetEntity> findAllVersions(String pollCode, Long userId);
    SheetEntity addVersion(SheetEntity sheet);
}
