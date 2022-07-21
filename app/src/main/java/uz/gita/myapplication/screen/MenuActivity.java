package uz.gita.myapplication.screen;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Objects;

import uz.gita.myapplication.R;
import uz.gita.myapplication.utils.MySharedPreference;

public class MenuActivity extends AppCompatActivity {


    MySharedPreference mySharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mySharedPreference = MySharedPreference.getInstance(getApplicationContext());
        AppCompatButton continueGame = findViewById(R.id.continueGame);
        AppCompatButton newGame = findViewById(R.id.newGame);
        AppCompatButton level = findViewById(R.id.level);

        String time = mySharedPreference.getPauseTime().toString();
        String levelText = mySharedPreference.getLevel();

        continueGame.setOnClickListener(view -> {

            if (Objects.equals(levelText, "easy")) {
                Intent intent = new Intent(new Intent(MenuActivity.this, MainActivity.class));
                intent.putExtra("time", time);
                startActivity(intent);
            } else if (Objects.equals(levelText, "medium")) {
                Intent intent = new Intent(new Intent(MenuActivity.this, SecondLevelActivity.class));
                intent.putExtra("time", time);
                startActivity(intent);
            } else if (Objects.equals(levelText, "hard")) {
                Intent intent = new Intent(new Intent(MenuActivity.this, ThirdLevelActivity.class));
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });


        newGame.setOnClickListener(view -> {
            Intent intent = new Intent(new Intent(MenuActivity.this, MainActivity.class));
            intent.putExtra("time", "");
            startActivity(intent);
        });
        level.setOnClickListener(view ->

                startActivity(new Intent(MenuActivity.this, LevelActivity.class)));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);    }


}