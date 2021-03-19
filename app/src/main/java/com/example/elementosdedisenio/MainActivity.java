package com.example.elementosdedisenio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Integer buttonLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buttonLevel = 0;
        this.setLevelToImageButton();

    }

    public void levelTesting (View view) {
        this.buttonLevel++;
        Button btn1 = (Button) findViewById(R.id.button3);
        this.setLevelToImageButton();
        btn1.setText(this.buttonLevel.toString());
        if (this.buttonLevel == 2) this.buttonLevel = 0;
    }

    private void setLevelToImageButton() {
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);
        Drawable drawable = btn.getDrawable();
        drawable.setLevel((this.buttonLevel));
    }

    public  void makeTransition(View view) {
        ImageButton button = (ImageButton) findViewById(R.id.imageButton2);
        Drawable drawable = button.getDrawable();
        if (drawable instanceof TransitionDrawable) {
            ((TransitionDrawable) drawable).startTransition(15000);
        }
    }

    public void makeClip (View view) {
        ImageView imageview = (ImageView) findViewById(R.id.image);
        Drawable drawable = imageview.getBackground();
        if (drawable instanceof ClipDrawable) {
            ((ClipDrawable)drawable).setLevel(drawable.getLevel() + 1000);
        }
        Button btn = (Button) findViewById(R.id.button6);
        btn.setText("clipped");
    }
}