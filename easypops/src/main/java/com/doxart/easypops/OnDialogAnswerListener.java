package com.doxart.easypops;

public interface OnDialogAnswerListener {
    default void onPositive() {}

    default void onNegative() {}
    default void onLater() {}
}
