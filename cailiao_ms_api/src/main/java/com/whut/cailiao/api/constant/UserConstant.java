package com.whut.cailiao.api.constant;

/**
 * Created by gammaniu on 16/4/18.
 */
public class UserConstant {

    public enum Status {

        ACTIVE(1), DISABLED(2), BLACK(3);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public enum Method {

        GET(1), POST(2), PUT(3), DELETE(4);

        private int value;

        Method(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }



}
