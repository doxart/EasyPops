package com.doxart.easypops;

import java.util.Date;

public interface OnDateSelectListener {
    default void onDateSelected(DateResult result) {}
    default void onDismiss() {}
    default void onError(Exception e) {}
}
