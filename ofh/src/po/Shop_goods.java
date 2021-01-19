package po;

	/**
	*	*@author yangsj
	*/

	public class Shop_goods{
	private int id;
	private int shopId;
	private int goodsId;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getShopId(){
		return this.shopId;
	}
	public void setShopId(int shopId){
		this.shopId=shopId;
	}
	public int getGoodsId(){
		return this.goodsId;
	}
	public void setGoodsId(int goodsId){
		this.goodsId=goodsId;
	}

}