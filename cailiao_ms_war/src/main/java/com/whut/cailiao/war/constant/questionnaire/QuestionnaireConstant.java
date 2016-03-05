package com.whut.cailiao.war.constant.questionnaire;

/**
 * Created by niuyang on 16/3/6.
 * 问卷模块相关常量
 */
public class QuestionnaireConstant {

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
}
