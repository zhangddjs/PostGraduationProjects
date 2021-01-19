package po;

	/**
	*	*@author yangsj
	*/

	public class Address{
	private int addressId;
	private int addressProvince;
	private int addressCity;
	private int addressCounty;
	private String addressInfo;

	public int getAddressId(){
		return this.addressId;
	}
	public void setAddressId(int addressId){
		this.addressId=addressId;
	}
	public int getAddressProvince(){
		return this.addressProvince;
	}
	public void setAddressProvince(int addressProvince){
		this.addressProvince=addressProvince;
	}
	public int getAddressCity(){
		return this.addressCity;
	}
	public void setAddressCity(int addressCity){
		this.addressCity=addressCity;
	}
	public int getAddressCounty(){
		return this.addressCounty;
	}
	public void setAddressCounty(int addressCounty){
		this.addressCounty=addressCounty;
	}
	public String getAddressInfo(){
		return this.addressInfo;
	}
	public void setAddressInfo(String addressInfo){
		this.addressInfo=addressInfo;
	}

}