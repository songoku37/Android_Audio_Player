package com.example.musicalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AudioImage extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer(); // 오디오 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);

        setTitle("노래 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = (TextView)findViewById(R.id.title);
        ImageView song_image = (ImageView)findViewById(R.id.song_image);
        TextView lyrics = (TextView)findViewById(R.id.lyrics);

        Resources res = getResources(); // 리소스 객체 생성

        int stringId;
        String myKey;

        // 이름으로 Id값 가져오기 name : 이름 , defType : drawable , 등 string은 res폴더에 string을 의미
        // 즉 여기선 string xml에 해당하는 이름값이 title + tag(동적) 을 가져온다 getPacakgeName은 맨 위에 패키지 명을 의미
        stringId = res.getIdentifier("title" + tag, "string", getPackageName()); // 2131492921값 출력댐
        myKey = res.getString(stringId); // 학교종
        title.setText(myKey);

        stringId = res.getIdentifier("song_image" + tag, "string", getPackageName());
        myKey = res.getString(stringId);

        int id_image = res.getIdentifier(myKey, "drawable", getPackageName());
        song_image.setImageResource(id_image);

        stringId = res.getIdentifier("lyrics" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        lyrics.setText(myKey);

        stringId = res.getIdentifier("audio" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        int id_audio = res.getIdentifier(myKey, "raw", getPackageName());
        mp = MediaPlayer.create(this,id_audio); // 여기에서 오디오 주소값을 실행한다
        mp.setLooping(false); // 반복하지 않는다
        mp.start(); // 노래를 재생시킨다
    }

    public void goBack(View v) {
        mp.stop(); // 멈추기
        mp.release(); // 메모리 해제
        finish(); // 완전히 삭제
    }
}