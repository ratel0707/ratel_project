package study.ratelsproject.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private T data;
    private int cnt;

    public Response(T data, int cnt) {
        this.data = data;
        this.cnt = cnt;
    }
}
