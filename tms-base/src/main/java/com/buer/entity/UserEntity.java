package com.buer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * 
 * @author 于海宁
 * @since 2019-10-03
 */
@TableName("user")
public class UserEntity implements Serializable {

    @TableId(value = "GID", type = IdType.AUTO)
    private Integer gid;

    @TableField("NAME")
    private String name;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
