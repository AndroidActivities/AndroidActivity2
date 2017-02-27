package agut_giralt.androidactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView1 = (TextView) findViewById(R.id.TextView1);
        textView1.setText(getIntent().getStringExtra("string"));
    }

    public void changeActivity2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        TextView textView1 = (TextView) findViewById(R.id.TextView1);
        intent.putExtra("string", textView1.getText().toString());
        setResult(2, intent);
        finish();
    }
}