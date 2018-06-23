package com.application.core.sheet;

import java.util.List;

public interface SheetDataGateway {
    SheetEntity addSheet(SheetEntity sheet);
    boolean exists(SheetEntity sheet);
    List<SheetEntity> findAllByPollCodeAndUserEmail(String pollCode, String userEmail);
}