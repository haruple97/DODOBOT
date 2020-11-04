package org.justice.dodobot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Chatbot_way extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot_way);


        //홈버튼 누르면 메인화면으로
        ImageView Home_Button = (ImageView) findViewById(R.id.home);
        Home_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //더보기 버튼 눌렀을 때 더보기 화면으로 이동
        ImageView More_Button = (ImageView) findViewById(R.id.more);
        More_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), More.class);
                startActivity(intent);
            }
        });

        //두두챗봇 버튼 눌렀을 때 두두챗봇 화면으로 이동
        ImageButton dodu_chat = (ImageButton) findViewById(R.id.dodu_chat);
        dodu_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chatbot_Activity.class);
                startActivity(intent);
            }
        });



    }







}
