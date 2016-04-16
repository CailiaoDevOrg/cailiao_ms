package com.whut.cailiao.api.constant;

import java.io.Serializable;

/**
 * Created by gammaniu on 16/4/15.
 */
public final class NewsContant {

    public enum Level {

        IMPORTANT(3), TEMP(2), NORMAL(1);

        private int value;

        Level(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public enum Status {

        DISPLAY(1), PAUSE(2);

        private int value;

        public int value() {
            return value;
        }

        Status(int value) {
            this.value = value;
        }
    }

}
