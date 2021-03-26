package com.xz.excel.constant;

public enum StatusEnum {


    //===================基础信息（区间：-10~10）=====================
    SUCCESS(1, "success"),
    ERROR(-1, "未知错误");

    /**
     * 响应状态码
     */
    private final int code;
    /**
     * 响应提示
     */
    private final String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static StatusEnum getEnum(int value) {
        StatusEnum[] enums = values();
        for (StatusEnum statusEnum : enums) {
            if (statusEnum.getCode().equals(value)) {
                return statusEnum;
            }
        }
        return null;
    }

    public static String getValue(Integer key) {
        StatusEnum[] businessModeEnums = values();
        for (StatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.code == key) {
                return businessModeEnum.msg;
            }
        }
        return null;
    }
}
