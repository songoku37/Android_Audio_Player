package com.example.musicalbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("노래 목록");
    }

    public void play(View v) {

        int id = v.getId(); // 클릭한 것에 Id값을 가져옴 (진짜 id값 x)
        LinearLayout layout = (LinearLayout)findViewById(id); // 그 값에 해당되는 객체 생성 [Attribute 접근가능]
        String tag = (String)layout.getTag(); // 그 layout에 속성값인 Tag를 가져올 수 있음

        Intent it = new Intent(this, AudioImage.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
}
