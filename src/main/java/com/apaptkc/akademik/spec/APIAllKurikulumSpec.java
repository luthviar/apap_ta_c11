package com.apaptkc.akademik.spec;

import java.util.List;

public class APIAllKurikulumSpec {
    private String status;
    private String msg;
    private List<KurikulumSpec> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<KurikulumSpec> getResult() {
        return result;
    }

    public void setResult(List<KurikulumSpec> result) {
        this.result = result;
    }
}
