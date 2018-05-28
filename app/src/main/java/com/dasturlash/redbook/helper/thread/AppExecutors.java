package com.dasturlash.redbook.helper.thread;

import java.util.concurrent.Executor;

/**
 * Created by QAREKEN on 5/26/2018.
 */

public class AppExecutors {
    private final Executor diskIo;
    private final Executor mainThread;

    private AppExecutors(Executor diskIo, Executor mainThread) {
        this.diskIo = diskIo;
        this.mainThread = mainThread;
    }

    public AppExecutors() {
        this(new DiskIoThreadExecutor(), new MainThreadExecutor());
    }

    public Executor getDiskIo() {
        return diskIo;
    }

    public Executor getMainThread() {
        return mainThread;
    }
}
