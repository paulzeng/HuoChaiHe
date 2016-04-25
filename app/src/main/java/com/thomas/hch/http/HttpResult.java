package com.thomas.hch.http;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/18 10:58
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class HttpResult<T> {
    private boolean Success;

    private int Code;

    private String Message;

    private int Count;

    private String Contents;
    //用来模仿Data
    private T Object;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public T getObject() {
        return Object;
    }

    public void setObject(T object) {
        Object = object;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "Success=" + Success +
                ", Code=" + Code +
                ", Message='" + Message + '\'' +
                ", Count=" + Count +
                ", Contents='" + Contents + '\'' +
                ", Object=" + Object +
                '}';
    }
}
