package me.lm.zuul2;

import rx.Observable;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Singleton
public class SampleService {

    private final AtomicBoolean status;

    public SampleService() {
        // change to true for demo
        this.status = new AtomicBoolean(false);
    }

    public boolean isHealthy() {
        return status.get();
    }

    public Observable<String> makeSlowRequest() {
        return Observable.just("test").delay(500, TimeUnit.MILLISECONDS);
    }
}
