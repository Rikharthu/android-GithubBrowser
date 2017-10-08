package com.example.uberv.githubbrowser;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Global executor pools for the whole application.
 * <p>
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 */
@Singleton
public class AppExecutors {

    public static final int NETWORK_IO_THREADS_COUNT = 3;

    private final Executor mDiskIO;
    private final Executor mNetworkIO;
    private final Executor mMainThread;


    public AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        mDiskIO = diskIO;
        mNetworkIO = networkIO;
        mMainThread = mainThread;
    }

    // TODO why we annotate this as @Inject? There are no consturctor params...
    @Inject
    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(),
                Executors.newFixedThreadPool(NETWORK_IO_THREADS_COUNT),
                new MainThreadExecutor());
    }

    private static class MainThreadExecutor implements Executor {

        private Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable runnable) {
            mMainThreadHandler.post(runnable);
        }
    }
}
