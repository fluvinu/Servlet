package application;

public class Food {
	
	
	private int foodId;
	private String foodName;
	private String foodIngredients;
	private String foodDiet;
	private int preptime;
	private int cookTime;
	private String flavorProfile;
	private String foodCourse;
	private String state;
	private String region;
	
	
	public Food() {
		
	}


	public Food(int foodId, String foodName, String foodIngredients, String foodDiet, int preptime, int cookTime,
			String flavorProfile, String foodCourse, String state, String region) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodIngredients = foodIngredients;
		this.foodDiet = foodDiet;
		this.preptime = preptime;
		this.cookTime = cookTime;
		this.flavorProfile = flavorProfile;
		this.foodCourse = foodCourse;
		this.state = state;
		this.region = region;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public String getFoodIngredients() {
		return foodIngredients;
	}


	public void setFoodIngredients(String foodIngredients) {
		this.foodIngredients = foodIngredients;
	}


	public String getFoodDiet() {
		return foodDiet;
	}


	public void setFoodDiet(String foodDiet) {
		this.foodDiet = foodDiet;
	}


	public int getPreptime() {
		return preptime;
	}


	public void setPreptime(int preptime) {
		this.preptime = preptime;
	}


	public int getCookTime() {
		return cookTime;
	}


	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}


	public String getFlavorProfile() {
		return flavorProfile;
	}


	public void setFlavorProfile(String flavorProfile) {
		this.flavorProfile = flavorProfile;
	}


	public String getFoodCourse() {
		return foodCourse;
	}


	public void setFoodCourse(String foodCourse) {
		this.foodCourse = foodCourse;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	
}
