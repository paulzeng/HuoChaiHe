package com.thomas.hch.http;

/**
 * @author liuhai
 * @version $Rev$
 * @time 2016/3/19 14:31
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate 2016/3/19$
 * @updateDes ${TODO}
 */
public class CommonResult {
    private boolean Success;

    private int Code;

    private String Message;

    private int Count;

    private String Contents;

    private Object Object;

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

    public java.lang.Object getObject() {
        return Object;
    }

    public void setObject(java.lang.Object object) {
        Object = object;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "Success=" + Success +
                ", Code=" + Code +
                ", Message='" + Message + '\'' +
                ", Count=" + Count +
                ", Contents='" + Contents + '\'' +
                ", Object=" + Object +
                '}';
    }
}
