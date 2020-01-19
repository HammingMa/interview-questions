package com.mzh.oom;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectBufferMemoryDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("配置的 MaxDirectMemory = " + sun.misc.VM.maxDirectMemory() / 1024 / 1024 + "MB");

        TimeUnit.SECONDS.sleep(1);

        ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }
}
