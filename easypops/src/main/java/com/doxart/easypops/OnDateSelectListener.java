package com.doxart.easypops;

public interface OnDateSelectListener {
    default void onDateSelected(int day, int month, int year, String formatted) {}
    default void onDismiss() {}
    default void onError(Exception e) {}
}
