package edu.xasl.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * ���ڷ�װ��˷���ǰ�����ݶ���
 */
@SuppressWarnings("serial")
public class ResultInfo implements Serializable {
    private boolean flag;//��˷��ؽ������Ϊtrue�������쳣����false
    private Object data;//��˷��ؽ�����ݶ���
    private String errorMsg;//�����쳣�Ĵ�����Ϣ

    //�޲ι��췽��
    public ResultInfo() {
    }
    public ResultInfo(boolean flag) {
        this.flag = flag;
    }
    /**
     * �вι��췽��
     * @param flag
     * @param errorMsg
     */
    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }
    /**
     * �вι��췽��
     * @param flag
     * @param data
     * @param errorMsg
     */
    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean b) {
        this.flag = b;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}