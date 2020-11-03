package Common;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class GeneralUtils{
    public int guest;

    public void selectDateFromCalender(Context context, final TextView textView){

        int mYear, mMonth, mDay, mHour, mMinute;

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textView.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public int addGuests(){
        if(guest < 20){
            guest++;
        }
        return guest;
    }

    public int removeGuests(){

        if(guest >= 2){
            guest--;
        }
        return guest;
    }

}
