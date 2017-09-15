package cn.com.sinosoft.bomsmgr.entity.ge;

import java.io.Serializable;
import java.util.Date;

public class TAuthMenufun implements Serializable {
    private String id;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String mfId;

    private String pmfId;

    private String mfName;

    private String mfLink;

    private String mfType;

    private String mfDesc;

    private String mfRank;

    private String mfLevel;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMfId() {
        return mfId;
    }

    public void setMfId(String mfId) {
        this.mfId = mfId == null ? null : mfId.trim();
    }

    public String getPmfId() {
        return pmfId;
    }

    public void setPmfId(String pmfId) {
        this.pmfId = pmfId == null ? null : pmfId.trim();
    }

    public String getMfName() {
        return mfName;
    }

    public void setMfName(String mfName) {
        this.mfName = mfName == null ? null : mfName.trim();
    }

    public String getMfLink() {
        return mfLink;
    }

    public void setMfLink(String mfLink) {
        this.mfLink = mfLink == null ? null : mfLink.trim();
    }

    public String getMfType() {
        return mfType;
    }

    public void setMfType(String mfType) {
        this.mfType = mfType == null ? null : mfType.trim();
    }

    public String getMfDesc() {
        return mfDesc;
    }

    public void setMfDesc(String mfDesc) {
        this.mfDesc = mfDesc == null ? null : mfDesc.trim();
    }

    public String getMfRank() {
        return mfRank;
    }

    public void setMfRank(String mfRank) {
        this.mfRank = mfRank == null ? null : mfRank.trim();
    }

    public String getMfLevel() {
        return mfLevel;
    }

    public void setMfLevel(String mfLevel) {
        this.mfLevel = mfLevel == null ? null : mfLevel.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TAuthMenufun other = (TAuthMenufun) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getMfId() == null ? other.getMfId() == null : this.getMfId().equals(other.getMfId()))
            && (this.getPmfId() == null ? other.getPmfId() == null : this.getPmfId().equals(other.getPmfId()))
            && (this.getMfName() == null ? other.getMfName() == null : this.getMfName().equals(other.getMfName()))
            && (this.getMfLink() == null ? other.getMfLink() == null : this.getMfLink().equals(other.getMfLink()))
            && (this.getMfType() == null ? other.getMfType() == null : this.getMfType().equals(other.getMfType()))
            && (this.getMfDesc() == null ? other.getMfDesc() == null : this.getMfDesc().equals(other.getMfDesc()))
            && (this.getMfRank() == null ? other.getMfRank() == null : this.getMfRank().equals(other.getMfRank()))
            && (this.getMfLevel() == null ? other.getMfLevel() == null : this.getMfLevel().equals(other.getMfLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getMfId() == null) ? 0 : getMfId().hashCode());
        result = prime * result + ((getPmfId() == null) ? 0 : getPmfId().hashCode());
        result = prime * result + ((getMfName() == null) ? 0 : getMfName().hashCode());
        result = prime * result + ((getMfLink() == null) ? 0 : getMfLink().hashCode());
        result = prime * result + ((getMfType() == null) ? 0 : getMfType().hashCode());
        result = prime * result + ((getMfDesc() == null) ? 0 : getMfDesc().hashCode());
        result = prime * result + ((getMfRank() == null) ? 0 : getMfRank().hashCode());
        result = prime * result + ((getMfLevel() == null) ? 0 : getMfLevel().hashCode());
        return result;
    }
}