package po;

	/**
	*	*@author yangsj
	*/

	public class Shop_address{
	private int id;
	private int shopId;
	private int addressId;

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
	public int getAddressId(){
		return this.addressId;
	}
	public void setAddressId(int addressId){
		this.addressId=addressId;
	}

}