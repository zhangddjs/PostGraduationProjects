package po;

	/**
	*	*@author yangsj
	*/

	public class Goods{
	private int goodsId;
	private String goodsName;
	private String goodsPrice;
	private String goodsImage;
	private String goodsInfo;
	private int goodsamount;
	private String goodsType;
	private int goodsSaleamount;

	public int getGoodsId(){
		return this.goodsId;
	}
	public void setGoodsId(int goodsId){
		this.goodsId=goodsId;
	}
	public String getGoodsName(){
		return this.goodsName;
	}
	public void setGoodsName(String goodsName){
		this.goodsName=goodsName;
	}
	public String getGoodsPrice(){
		return this.goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice){
		this.goodsPrice=goodsPrice;
	}
	public String getGoodsImage(){
		return this.goodsImage;
	}
	public void setGoodsImage(String goodsImage){
		this.goodsImage=goodsImage;
	}
	public String getGoodsInfo(){
		return this.goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo){
		this.goodsInfo=goodsInfo;
	}
	public int getGoodsamount(){
		return this.goodsamount;
	}
	public void setGoodsamount(int goodsamount){
		this.goodsamount=goodsamount;
	}
	public String getGoodsType(){
		return this.goodsType;
	}
	public void setGoodsType(String goodsType){
		this.goodsType=goodsType;
	}
	public int getGoodsSaleamount(){
		return this.goodsSaleamount;
	}
	public void setGoodsSaleamount(int goodsSaleamount){
		this.goodsSaleamount=goodsSaleamount;
	}

}