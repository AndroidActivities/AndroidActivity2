package agut_giralt.androidactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == resultCode) {
            String stringExtra = data.getStringExtra("string");
            TextView view1 = (TextView) findViewById(R.id.textView4);// Obtain text from the textView
            view1.setText(stringExtra);
        }
    }

    /**
     * Creates an Intent, Gather Information and start the new Activity
     */
    public void changeActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);      //Create the intent
        EditText edit1 = (EditText) findViewById(R.id.editText);    // Obtain text from the EditText
        EditText edit2 = (EditText) findViewById(R.id.editText2);   // Obtain text from the EditText
        String string = createString(edit1.getText().toString(),    // Obtain the String to print
                            Integer.parseInt(edit2.getText().toString()));
        intent.putExtra("string",string);                           // Add the string to print
        startActivityForResult(intent, 2);                          //Start the intent
    }

    /**
     * Creates the String that will print in the other Activity
     * @param edit1 String
     * @param edit2 Time to repeat the string
     * @return The string that will see the other
     */
    private String createString(String edit1, int edit2) {
        String string = "";
        if (edit2 < 1) return "Error";
        for (int i = 0; i < edit2; i ++) {
            string += edit1 + " ";
        }
        return string;
    }
}