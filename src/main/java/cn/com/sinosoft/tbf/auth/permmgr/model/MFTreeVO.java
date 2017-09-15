package cn.com.sinosoft.tbf.auth.permmgr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 单个系统树状菜单功能点
 */
public class MFTreeVO implements Cloneable{
	
	private MFVO mfVO;
    private List<MFTreeVO> children;
	
	public MFVO getMfVO() {
		return mfVO;
	}
	public void setMfVO(MFVO mfVO) {
		this.mfVO = mfVO;
	}
	public List<MFTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<MFTreeVO> children) {
		this.children = children;
	}
	public void addChild(MFTreeVO mfTreeVO){
		if(this.children == null){
			this.children = new ArrayList<MFTreeVO>();
		}
		this.children.add(mfTreeVO);
	}
	public MFTreeVO clone() {  
		MFTreeVO o = null;  
        try {  
            o = (MFTreeVO) super.clone();  
        } catch (CloneNotSupportedException ex) {  
            ex.printStackTrace();  
        }  
        return o;  
    }
}
