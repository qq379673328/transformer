package cn.com.sinosoft.bomsmgr.entity.ge;

import java.io.Serializable;
import java.util.Date;

public class TBizFiles implements Serializable {
    private String id;

    private String filenameSrc;

    private String filenameNew;

    private Date createTime;

    private String createUser;

    private String path;

    private String filetype;

    private Double filesize;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFilenameSrc() {
        return filenameSrc;
    }

    public void setFilenameSrc(String filenameSrc) {
        this.filenameSrc = filenameSrc == null ? null : filenameSrc.trim();
    }

    public String getFilenameNew() {
        return filenameNew;
    }

    public void setFilenameNew(String filenameNew) {
        this.filenameNew = filenameNew == null ? null : filenameNew.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
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
        TBizFiles other = (TBizFiles) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFilenameSrc() == null ? other.getFilenameSrc() == null : this.getFilenameSrc().equals(other.getFilenameSrc()))
            && (this.getFilenameNew() == null ? other.getFilenameNew() == null : this.getFilenameNew().equals(other.getFilenameNew()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getFiletype() == null ? other.getFiletype() == null : this.getFiletype().equals(other.getFiletype()))
            && (this.getFilesize() == null ? other.getFilesize() == null : this.getFilesize().equals(other.getFilesize()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFilenameSrc() == null) ? 0 : getFilenameSrc().hashCode());
        result = prime * result + ((getFilenameNew() == null) ? 0 : getFilenameNew().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getFiletype() == null) ? 0 : getFiletype().hashCode());
        result = prime * result + ((getFilesize() == null) ? 0 : getFilesize().hashCode());
        return result;
    }
}