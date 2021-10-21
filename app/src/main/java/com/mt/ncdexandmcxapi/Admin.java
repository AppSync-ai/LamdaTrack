package com.mt.ncdexandmcxapi;

import static java.lang.Thread.currentThread;

class Admin {

    public static int getLineNumber() {
        return currentThread().getStackTrace()[3].getLineNumber();
    }

}
