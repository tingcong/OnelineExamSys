package com.tc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by htc on 2017/4/18.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 2784921582689930919L;
    //    主键
    private Integer id;

    //  姓名
    private String name;

    //账号
    private String account;

    //密码
    private String pwd;

    //备注
    private String remark;

    //账户创建时间
    private Date createDatetime;

    //信息修改时间
    private Date ModifiedDatetime;

    //新密码
    private String newPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getModifiedDatetime() {
        return ModifiedDatetime;
    }

    public void setModifiedDatetime(Date modifiedDatetime) {
        ModifiedDatetime = modifiedDatetime;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
