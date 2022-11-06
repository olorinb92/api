package com.backend.api.exception;

import com.backend.api.helper.JsonHelper;
import com.backend.api.model.ExceptionModel;
import com.google.gson.Gson;

public class PlayerExistException extends Exception {
    public PlayerExistException(ExceptionModel model) {
        super(JsonHelper.parse(model));
    }
}
