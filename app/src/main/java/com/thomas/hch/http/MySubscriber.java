package com.thomas.hch.http;

import rx.Subscriber;

/**
 * Created by tangmingjian on 16/2/24.
 */
public abstract class MySubscriber<T> extends Subscriber<T> {

    public void onBegin() {
    }
}
