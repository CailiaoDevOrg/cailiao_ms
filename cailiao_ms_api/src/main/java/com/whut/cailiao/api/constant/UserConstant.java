package com.whut.cailiao.api.constant;

/**
 * Created by gammaniu on 16/4/18.
 */
public class UserConstant {

    public enum Status {

        ACTIVE(1), DISABLED(2);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public enum Method {

        GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

        private String value;

        Method(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

}
