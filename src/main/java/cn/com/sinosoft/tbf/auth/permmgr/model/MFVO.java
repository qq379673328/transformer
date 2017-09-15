/**
 * 
 *
 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @date 2015-7-15
 */
package cn.com.sinosoft.tbf.auth.permmgr.model;


/**
 * 单条菜单功能点
 * @author	<a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @date	2015-7-15
 */
public class MFVO implements Cloneable{
	
	private String id;
    private String appId;
    private String mfId;
    private String pmfId;
    private String mfName;
    private String mfLink;
    private String mfType;
    private String mfDesc;
    private String mfRank;
    private String mfLevel;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMfId() {
		return mfId;
	}
	public void setMfId(String mfId) {
		this.mfId = mfId;
	}
	public String getPmfId() {
		return pmfId;
	}
	public void setPmfId(String pmfId) {
		this.pmfId = pmfId;
	}
	public String getMfName() {
		return mfName;
	}
	public void setMfName(String mfName) {
		this.mfName = mfName;
	}
	public String getMfLink() {
		return mfLink;
	}
	public void setMfLink(String mfLink) {
		this.mfLink = mfLink;
	}
	public String getMfType() {
		return mfType;
	}
	public void setMfType(String mfType) {
		this.mfType = mfType;
	}
	public String getMfDesc() {
		return mfDesc;
	}
	public void setMfDesc(String mfDesc) {
		this.mfDesc = mfDesc;
	}
	public String getMfRank() {
		return mfRank;
	}
	public void setMfRank(String mfRank) {
		this.mfRank = mfRank;
	}
	public String getMfLevel() {
		return mfLevel;
	}
	public void setMfLevel(String mfLevel) {
		this.mfLevel = mfLevel;
	}
	public MFVO clone() {  
		MFVO o = null;  
        try {  
            o = (MFVO) super.clone();  
        } catch (CloneNotSupportedException ex) {  
            ex.printStackTrace();  
        }  
        return o;  
    }
}
