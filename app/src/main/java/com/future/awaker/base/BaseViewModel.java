package com.future.awaker.base;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.List;

/**
 * Copyright ©2017 by Teambition
 */

public class BaseViewModel extends BaseObservable {

    public ObservableField<Throwable> isError = new ObservableField<>();
    public ObservableBoolean isEmpty = new ObservableBoolean(false);
    public ObservableBoolean isRunning = new ObservableBoolean(false);

    protected void notifyEmpty(List list) {
        boolean emptyFlag = list == null || list.isEmpty();
        if (emptyFlag != isEmpty.get()) {
            isEmpty.set(emptyFlag);
        }
    }
}
