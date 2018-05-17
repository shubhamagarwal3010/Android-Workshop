package android.bootcamp.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class TravelPlannerActivity extends Activity {

  private final int requestCode = 20;
  private ImageView imageHolder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_travel_planner);
    imageHolder = (ImageView)findViewById(R.id.captured_photo);

  }

  public void calculate(View view) {
    int distance = Integer.parseInt(((EditText) findViewById(R.id.distance)).getText().toString());
    int velocity = Integer.parseInt(((EditText) findViewById(R.id.velocity)).getText().toString());
    String time = String.valueOf(distance/velocity);

    Intent i = new Intent(this, TimeActivity.class);
    i.putExtra("time",time);
    startActivityForResult(i, 1);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 1) {
      if(resultCode == Activity.RESULT_OK){
        String result=data.getStringExtra("totalTime");

        TextView  totalTime= (TextView) findViewById(R.id.totalTime);
        totalTime.setText(result);
      }
    }
    if(this.requestCode == requestCode && resultCode == RESULT_OK){
      Bitmap bitmap = (Bitmap)data.getExtras().get("data");
      imageHolder.setImageBitmap(bitmap);
    }
  }//onActivityResult

  public void launchCamera(View view) {
    Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(photoCaptureIntent, requestCode);
  }
}
