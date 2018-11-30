package sunjx.rest;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @Auther: sunjx
 * @Date: 2018/11/30 0030 14:30
 * @Description:
 */
@Data
public class RestResult<T> {

    private String code;
    private String msg;
    private T data;

    public RestResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RestResult success(String msg, Object data){
        return new RestResult(RestEnum.CommonEnum.SUCCESS.getCode(), StringUtils.isEmpty(msg) ? RestEnum.CommonEnum.SUCCESS.getText() : msg, data);
    }

    public static RestResult success(Object data){
        return success(null, data);
    }

    public static RestResult fail(String msg, Object data){
        return new RestResult(RestEnum.CommonEnum.FAIL.getCode(), StringUtils.isEmpty(msg) ? RestEnum.CommonEnum.FAIL.getText() : msg, data);
    }

    public static RestResult fail(Object data){
        return fail(null, data);
    }
}
