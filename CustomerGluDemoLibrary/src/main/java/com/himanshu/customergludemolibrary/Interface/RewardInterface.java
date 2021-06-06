package com.himanshu.customergludemolibrary.Interface;

import com.himanshu.customergludemolibrary.Modal.RewardModel;

public interface RewardInterface {

    void onSuccess(RewardModel rewardModel);
    void onFailure(String message);
}
