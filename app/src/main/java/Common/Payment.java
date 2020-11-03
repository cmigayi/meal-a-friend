package Common;

public class Payment {
    private int guestNum;
    private double mealPerGuestCost,bookingFee,totalMealCost,totalCost;

    public int getGuestNum() {
        return guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }

    public double getMealPerGuestCost() {
        return mealPerGuestCost;
    }

    public void setMealPerGuestCost(double mealPerGuestCost) {
        this.mealPerGuestCost = mealPerGuestCost;
    }

    public double getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(double bookingFee) {
        this.bookingFee = bookingFee;
    }

    public double getTotalMealCost(){
        return mealPerGuestCost * guestNum;
    }

    public double getTotalCost(){
        return getTotalMealCost()+getBookingFee();
    }
}
