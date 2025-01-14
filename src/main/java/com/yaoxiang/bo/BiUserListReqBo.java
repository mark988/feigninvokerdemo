package com.yaoxiang.bo;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author maxiaoguang
 */
@SuperBuilder
@Data
public class BiUserListReqBo extends BiBaseReqBo {
    private Integer userPropertyType;
}
