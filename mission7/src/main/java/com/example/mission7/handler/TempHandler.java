package com.example.mission7.handler;

import com.example.mission7.exception.GeneralException;
import com.example.mission7.status.BaseErrorCode;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
