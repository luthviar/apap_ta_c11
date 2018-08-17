package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APISekretariatSpec {
    private String status;
    private String msg;
    private List<SekretariatSpec> result;

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

    public List<SekretariatSpec> getResult() {
        return result;
    }

    public void setResult(List<SekretariatSpec> result) {
        this.result = result;
    }


}
