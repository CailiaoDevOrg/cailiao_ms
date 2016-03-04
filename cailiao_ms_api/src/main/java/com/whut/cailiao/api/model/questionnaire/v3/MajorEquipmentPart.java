package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;
import java.util.List;

/**
 * 主要设备
 * 
 * @author niuyang
 *
 */
public class MajorEquipmentPart implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 生料磨 **/
	private List<ShengLiaoMoItem> shengLiaoMoItem;
	/** 水泥磨 **/
	private List<ShuiNiMoItem> shuiNiMoItem;
	/** 窑规格 **/
	private String scale;

	public List<ShengLiaoMoItem> getShengLiaoMoItem() {
		return shengLiaoMoItem;
	}

	public void setShengLiaoMoItem(List<ShengLiaoMoItem> shengLiaoMoItem) {
		this.shengLiaoMoItem = shengLiaoMoItem;
	}

	public List<ShuiNiMoItem> getShuiNiMoItem() {
		return shuiNiMoItem;
	}

	public void setShuiNiMoItem(List<ShuiNiMoItem> shuiNiMoItem) {
		this.shuiNiMoItem = shuiNiMoItem;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public class ShengLiaoMoItem implements Serializable {
		/** 粉磨方式 **/
		private String shengLiaoMoWay;
		/** 规格型号 **/
		private String shengLiaoMoModule;
		/** 数量 **/
		private int shengLiaoMoNumber;

		public String getShengLiaoMoWay() {
			return shengLiaoMoWay;
		}

		public void setShengLiaoMoWay(String shengLiaoMoWay) {
			this.shengLiaoMoWay = shengLiaoMoWay;
		}

		public String getShengLiaoMoModule() {
			return shengLiaoMoModule;
		}

		public void setShengLiaoMoModule(String shengLiaoMoModule) {
			this.shengLiaoMoModule = shengLiaoMoModule;
		}

		public int getShengLiaoMoNumber() {
			return shengLiaoMoNumber;
		}

		public void setShengLiaoMoNumber(int shengLiaoMoNumber) {
			this.shengLiaoMoNumber = shengLiaoMoNumber;
		}

	}

	public class ShuiNiMoItem implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/** 粉磨方式 **/
		private String shuiNiMoWay;
		/** 规格型号 **/
		private String shuiNiMoModule;
		/** 数量 **/
		private int shuiNiMoNumber;

		public String getShuiNiMoWay() {
			return shuiNiMoWay;
		}

		public void setShuiNiMoWay(String shuiNiMoWay) {
			this.shuiNiMoWay = shuiNiMoWay;
		}

		public String getShuiNiMoModule() {
			return shuiNiMoModule;
		}

		public void setShuiNiMoModule(String shuiNiMoModule) {
			this.shuiNiMoModule = shuiNiMoModule;
		}

		public int getShuiNiMoNumber() {
			return shuiNiMoNumber;
		}

		public void setShuiNiMoNumber(int shuiNiMoNumber) {
			this.shuiNiMoNumber = shuiNiMoNumber;
		}
	}

}
