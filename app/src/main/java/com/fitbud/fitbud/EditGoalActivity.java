package com.fitbud.fitbud;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;


public class EditGoalActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goal);
    }

    public void cancelGoal(View view) {
        this.finish();
    }

    public void saveGoal(View view) {
        String msg = "";
        double currWeight = 0.0, goalWeight = 0.0;
        int age = 0, feet = 0, inches = 0;

        EditText currField = (EditText) findViewById(R.id.CurrentWeight);
        try { currWeight = Double.parseDouble(currField.getText().toString());}
        catch (Exception e){ msg = "Cannot convert Current Weight"; }
        if (currWeight < 0.0) msg = "Cannot have negative Weight";

        EditText goalField = (EditText) findViewById(R.id.TargetWeight);
        try { goalWeight = Double.parseDouble(goalField.getText().toString());}
        catch (Exception e){ msg = "Cannot convert Target Weight"; }
        if (goalWeight < 0.0) msg = "Cannot have negative Weight";

        NumberPicker agePicker = (NumberPicker) findViewById(R.id.AgePicker);
        NumberPicker feetPicker = (NumberPicker) findViewById(R.id.FeetPicker);
        NumberPicker inchPicker = (NumberPicker) findViewById(R.id.InchPicker);
        age = agePicker.getValue(); feet = feetPicker.getValue(); inches = inchPicker.getValue();

        if (!msg.equals("")){
            AlertDialog errDialog = new AlertDialog.Builder(this).create();
            errDialog.setTitle("Error"); errDialog.setMessage(msg); errDialog.show();
        }
        else {

        }
        //Intent intent = new Intent(this, EditGoalActivity.class);
        //startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() { }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_edit_goal, container, false);
            return rootView;
        }
    }
}
