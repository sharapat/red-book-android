package com.dasturlash.redbook.helper.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by QAREKEN on 5/26/2018.
 */

public class DiskIoThreadExecutor implements Executor {
    private final Executor diskIo;

    public DiskIoThreadExecutor() {
        this.diskIo = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(@NonNull Runnable command) {
        diskIo.execute(command);
    }
}
