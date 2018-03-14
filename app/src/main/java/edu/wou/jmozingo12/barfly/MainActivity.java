package edu.wou.jmozingo12.barfly;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ObjectInputStream;

import edu.wou.jmozingo12.barfly.data.BreweriesDO;


public class MainActivity extends AppCompatActivity {

    Button addBreweryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText editTextBreweryName = findViewById(R.id.breweryNameEditor);
        editTextBreweryName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_DONE){
                    createBrewery(textView.getText().toString());

                }
                return handled;
            }
        });

        /**
         * Create new button object in code. Find button by ID of the view.
         * Create the OnClick functionality.
         */
        addBreweryButton = findViewById(R.id.addBreweryButton);
        addBreweryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    /**
     * Creates a new brewery in the database.
     * @param newBreweryName
     */
    public void createBrewery(final String newBreweryName) {
        final BreweriesDO newBrewery = new BreweriesDO();

        newBrewery.setUserId(AWSProvider.getInstance().getIdentityManager().getCachedUserID());
        newBrewery.setBreweryName(newBreweryName);
        newBrewery.setBreweryLocation("1645 NW Division");

        //Dont you dare think about putting anything UI based in this thread. I will find you.
        new Thread(new Runnable() {
            @Override
            public void run() {
                AWSProvider.getInstance().getDynamoDbMapper().save(newBrewery);
            }
        }).start();

    }
}
