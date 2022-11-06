package com.backend.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionModel {
    private String msg;
}
