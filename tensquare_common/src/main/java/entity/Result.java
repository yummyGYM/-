package entity;

import lombok.*;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/9 19:06
 * @Modified By：
 */
@Data
@NoArgsConstructor
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object object;

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object object) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.object = object;
    }
}
