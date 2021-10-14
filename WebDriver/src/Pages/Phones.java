package Pages;

public class Phones {
	
	public String deviceDetails,price,ratings;
	
	public String getDeviceDetails() {
		return deviceDetails;
	}
	public void setDeviceDetails(String deviceDetails) {
		this.deviceDetails = deviceDetails;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public Phones() {
		// TODO Auto-generated constructor stub
	}
	public Phones(String device,String paise,String kaisa) {
		// TODO Auto-generated constructor stub
		deviceDetails=device;
		price=paise;
		ratings=kaisa;
	}

}
