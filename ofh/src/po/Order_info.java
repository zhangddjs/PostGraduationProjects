package po;

	/**
	*	*@author yangsj
	*/

	public class Order_info{
	private int id;
	private int orderId;
	private int userId;
	private int shopId;
	private int addressId;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getOrderId(){
		return this.orderId;
	}
	public void setOrderId(int orderId){
		this.orderId=orderId;
	}
	public int getUserId(){
		return this.userId;
	}
	public void setUserId(int userId){
		this.userId=userId;
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