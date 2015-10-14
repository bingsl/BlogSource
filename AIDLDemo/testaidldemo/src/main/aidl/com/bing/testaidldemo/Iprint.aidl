// Iprint.aidl
package com.bing.testaidldemo;

// Declare any non-default types here with import statements
//如果不能生成Iprint.java 查看http://www.linuxidc.com/Linux/2015-01/111148.htm
interface Iprint {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
            void print();
}
