package dto.response;

/**
 * Created by DELL on 2017-07-20.
 */
public class Response<Obj>{
    private Info info;
    private Obj data;

    public Response(Info info, Obj data) {
        this.info = info;
        this.data = data;
    }

    public Response() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Obj getData() {
        return data;
    }

    public void setData(Obj data) {
        this.data = data;
    }
}
