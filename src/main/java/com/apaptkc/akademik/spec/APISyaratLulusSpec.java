package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APISyaratLulusSpec
{
    private String status;
    private String msg;
    private SyaratLulusSpec result;
}
