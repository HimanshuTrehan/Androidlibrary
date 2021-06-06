package com.himanshu.customergludemolibrary.Interface;

import com.himanshu.customergludemolibrary.Modal.RegisterModal;

public interface DataListner {

    void onData(RegisterModal registerModal);
    void onFail(String message);

}
