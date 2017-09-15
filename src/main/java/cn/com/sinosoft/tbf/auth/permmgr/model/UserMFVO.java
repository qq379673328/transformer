package cn.com.sinosoft.tbf.auth.permmgr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户所有菜单功能点
 */
public class UserMFVO {
	
	/**
	 * 所有菜单功能点
	 */
	private Map<String, MFTreeVO> mFTrees;
	private List<MFVO> mfList;
	
	public Map<String, MFTreeVO> getmFTrees() {
		return mFTrees;
	}

	public void setmFTrees(Map<String, MFTreeVO> mFTrees) {
		this.mFTrees = mFTrees;
	}
	
	public List<MFVO> getMfList() {
		return mfList;
	}

	public void setMfList(List<MFVO> mfList) {
		this.mfList = mfList;
	}

	public UserMFVO(){
		this.mFTrees = new HashMap<String, MFTreeVO>();
	}
	
	/**
	 * 新增功能树
	 * @param appId
	 * @param mfTree
	 */
	public void putMFTree(String appId, MFTreeVO mfTree){
		this.mFTrees.put(appId, mfTree);
	}

	/**
	 * 获取指定应用所有功能点
	 * @return
	 */
	public List<MFVO> getFunsByAppId(String appId){
		List<MFVO> funs = new ArrayList<MFVO>();
		MFTreeVO mfTree = mFTrees.get(appId);
		if(mfTree != null){
			handleFunTree(mfTree, funs);
		}
		return funs;
	}
	
	/**
	 * 获取指定应用所有功能点-mflink
	 * @return
	 */
	public List<String> getFunsByAppIdStr(String appId){
		List<MFVO> funs = getFunsByAppId(appId);
		List<String> ret = new ArrayList<String>();
		if(funs != null && funs.size() > 0){
			for(MFVO mf : funs){
				ret.add(mf.getMfLink());
			}
		}
		return ret;
	}
	private void handleFunTree(MFTreeVO mfTree, List<MFVO> mfVOs){
		MFVO mfVO = mfTree.getMfVO();
		if(PermInfo.MFTYPE_FUN.equals(mfVO.getMfType())){//功能点
			mfVOs.add(mfVO);
		}
		List<MFTreeVO> children = mfTree.getChildren();
		if(children != null && children.size() > 0){
			for(MFTreeVO vo : children){
				handleFunTree(vo, mfVOs);
			}
		}
	}
	
	/**
	 * 根据应用id获取功能树-包含菜单和功能点
	 * @param appId
	 * @return
	 */
	public MFTreeVO getMFTreeByAppId(String appId){
		return this.mFTrees.get(appId);
	}
	
	/**
	 * 获取菜单
	 * @return
	 */
	public MFTreeVO getMenuTreeByAppId(String appId){
		MFTreeVO appMfTree = mFTrees.get(appId);
		if(appMfTree != null){
			MFTreeVO newMfTree = appMfTree.clone();
			handleMenuTree(newMfTree);
			return newMfTree;
		}else{
			return null;
		}
	}
	private void handleMenuTree(MFTreeVO mfTree){
		MFVO mfVO = mfTree.getMfVO();
		if(PermInfo.MFTYPE_MENU.equals(mfVO.getMfType())){//功能点
			mfTree = null;
		}else{
			List<MFTreeVO> children = mfTree.getChildren();
			if(children != null && children.size() > 0){
				for(MFTreeVO vo : children){
					handleMenuTree(vo);
				}
			}
		}
		
	}
	
}
