package com.whut.cailiao.ms.api.constant;

/**
 * Created by niuyang on 16/3/6.
 * 问卷模块相关常量
 */
public final class QuestionnaireConstant {

    public enum QuestionnaireTemplateStatus {
        EDITING(1),
        PUBLISHED(2);

        QuestionnaireTemplateStatus(int value) {
            this.value = value;
        }

        private int value;

        public int value() {
            return this.value;
        }
    }

    public enum QuestionnaireContentStatus {
        EDITING(1),
        COMMITTED(2),
        PASS(3);

        QuestionnaireContentStatus(int value) {
            this.value = value;
        }

        private int value;

        public int value() {
            return this.value;
        }
    }

}
