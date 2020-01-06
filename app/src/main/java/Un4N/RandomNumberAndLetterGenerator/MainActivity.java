package Un4N.RandomNumberAndLetterGenerator;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private TextInputEditText toBox;
    private TextInputEditText fromBox;
    private Button letterButton;
    private Button numberButton;
    private TextView text;
    private int from;
    private int to;
    private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromBox = (TextInputEditText) findViewById(R.id.from_box);
        toBox = (TextInputEditText) findViewById(R.id.to_box);
        letterButton = (Button) findViewById(R.id.letter_button);
        numberButton = (Button) findViewById(R.id.number_button);
        text = (TextView) findViewById(R.id.text);

        letterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                randomLetter();
            }
        });

        numberButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                randomNumber();
            }
        });
    }

    public void randomNumber()
    {
        try
        {
            from = Integer.parseInt(fromBox.getText().toString());
            to = Integer.parseInt(toBox.getText().toString());
            text.setText(Integer.toString(random.nextInt(to-from+1)+from));
        }
        catch(Exception e) {e.printStackTrace();}
    }

    public void randomLetter()
    {
        text.setText(Character.toString(letters.charAt(random.nextInt(letters.length()))));
    }
}
