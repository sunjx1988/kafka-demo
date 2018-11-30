package sunjx.rest;

/**
 * @Auther: sunjx
 * @Date: 2018/11/30 0030 14:32
 * @Description:
 */
public class RestEnum {

    public enum CommonEnum{
        SUCCESS("0000", "成功"),
        FAIL("0001", "失败"),
        ;

        private String code;
        private String text;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        CommonEnum(String code, String text) {
            this.code = code;
            this.text = text;
        }
    }
}
