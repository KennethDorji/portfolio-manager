package com.mountainview.portfoliomanager.model;

public enum DisposalMethod {
    FIRST_IN_FIRST_OUT,
    LAST_IN_FIRST_OUT,
    HIGH_COST,
    HIGH_COST_LONG_TERM,
    HIGH_COST_SHORT_TERM,
    LOW_COST,
    LOW_COST_LONG_TERM,
    LOW_COST_SHORT_TERM;

    public static final DisposalMethod DEFAULT = FIRST_IN_FIRST_OUT;

    public static DisposalMethod getDefault() {
        return DEFAULT;
    }
}
