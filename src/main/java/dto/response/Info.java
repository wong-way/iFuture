package dto.response;

/**
 * Created by DELL on 2017-07-20.
 */
public class Info {
    private int code;
    private String message;

    public Info(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
