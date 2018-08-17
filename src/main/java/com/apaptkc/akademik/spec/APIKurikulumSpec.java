package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIKurikulumSpec {
    private String status;
    private String msg;
    private KurikulumSpec result;

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

    public KurikulumSpec getResult() {
        return result;
    }

    public void setResult(KurikulumSpec result) {
        this.result = result;
    }
}
