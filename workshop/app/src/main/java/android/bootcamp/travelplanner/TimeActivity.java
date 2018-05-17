package android.bootcamp.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TimeActivity extends Activity {

    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Bundle extras = getIntent().getExtras();
        time = extras.getString("time");

        TextView result = (TextView) findViewById(R.id.time);
        result.setText(time);

    }
    public void calculateTotalTime(View view) {

        int buffer = Integer.parseInt(((EditText) findViewById(R.id.buffer)).getText().toString());
        String totalTime = String.valueOf(Integer.parseInt(time) + buffer);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("totalTime",totalTime);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
