package edu.wou.jmozingo12.barfly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button otherActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Create new button object in code. Find button by ID of the view.
         * Create the OnClick functionality.
         *
        otherActivityButton = findViewById(R.id.OtherActivityButton);
        otherActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, youActivityName.class);

                    context.startActivity(intent);
            }
        });
         */
    }
}
