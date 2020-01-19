package com.mzh.jvm;

public class JvmDemo {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("totalMemory(-xms) = " +totalMemory+"(字节) "+totalMemory/1024/1024+"M");
        System.out.println("maxMemory(-xmx) = " +maxMemory+"(字节) "+maxMemory/1024/1024+"M");
    }
}
