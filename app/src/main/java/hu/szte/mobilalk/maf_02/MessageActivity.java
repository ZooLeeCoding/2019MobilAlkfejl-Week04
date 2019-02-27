package hu.szte.mobilalk.maf_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "hu.szte.mobilalk.maf_02.REPLY";

    private TextView displayView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent starterIntent = getIntent();
        String message = starterIntent.getStringExtra(Intent.EXTRA_TEXT);
        this.displayView = findViewById(R.id.displayView);
        this.displayView.setText(message);
        this.editText = findViewById(R.id.editText);
    }

    public void back(View view) {
        String reply = "I'm back!";
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void imageClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                this.editText.getText(),
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onRadioPress(View view) {
        String chosen = "";
        switch(view.getId()) {
            case R.id.radioButton:
                chosen = "elso";
                break;
            case R.id.radioButton2:
                chosen = "masodik";
                break;
            case R.id.radioButton3:
                chosen = "harmadik";
                break;
            default:
                break;
        }
        Toast toast = Toast.makeText(getApplicationContext(),
                chosen + " volt kiválasztva",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}
