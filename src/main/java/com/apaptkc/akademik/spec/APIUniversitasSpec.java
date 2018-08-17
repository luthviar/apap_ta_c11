package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIUniversitasSpec {
    private String status;
    private String msg;
    private ResultUniversitasSpec result;

    public String getStatus() {
        return status;
    }

    public ResultUniversitasSpec getResult() {
        return result;
    }

    public void setResult(ResultUniversitasSpec result) {
        this.result = result;
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

}
