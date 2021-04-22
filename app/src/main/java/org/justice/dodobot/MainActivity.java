package org.justice.dodobot;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.graphics.Movie;
        import android.media.Image;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.CalendarView;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Titleimg> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //리사이클러뷰 쓰기 위한 코드
        this.InitializeData();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView_main);

        //이 부분 수정해서 가로 리사이클러뷰
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        recyclerView.setAdapter(new MyAdapter(dataList));  // Adapter 등록

        //리사이클러뷰 쓰기 위한 코드 끝

        //두두챗봇 버튼 눌렀을 때 두두챗봇 화면으로 이동
        ImageButton dodu_chat = (ImageButton) findViewById(R.id.dodu_chat);
        dodu_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chatbot_Activity.class);
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

        //교내지도 버튼 눌렀을 때 교내지도 화면으로 이동
        ImageButton School_map_Button = (ImageButton) findViewById(R.id.school_map);
        School_map_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapFragmentActivity.class);
                startActivity(intent);
            }
        });


        //이용방법 버튼 눌렀을 때 이용방법 화면으로 이동
        ImageButton chatbot_way = (ImageButton) findViewById(R.id.chatbot_way);
        chatbot_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chatbot_way.class);
                startActivity(intent);
            }
        });





        //레이아웃 이미지 버튼 변수 선언
        ImageButton bachelor_notice = (ImageButton)this.findViewById(R.id.bachelor_notice);
        ImageButton event_notice = (ImageButton)this.findViewById(R.id.event_notice);
        ImageButton recruitment_notice = (ImageButton)this.findViewById(R.id.recruitment_notice);
        ImageButton corona_notice = (ImageButton)this.findViewById(R.id.corona_notice);
        ImageButton youtube = (ImageButton)this.findViewById(R.id.youtube);
        ImageButton facebook = (ImageButton)this.findViewById(R.id.facebook);
        ImageButton blog = (ImageButton)this.findViewById(R.id.blog);
        ImageButton instagram = (ImageButton)this.findViewById(R.id.instagram);
        ImageButton call = (ImageButton)this.findViewById(R.id.call);
        ImageButton school_wish = (ImageButton)this.findViewById(R.id.school_wish);



        //클릭이벤트 건의사항 (전자민원)
        school_wish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://minwon.daegu.ac.kr/minwon/login.php"));
                startActivity(intent);
            }
        });



        //클릭이벤트 학사공지
        bachelor_notice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://daegu.ac.kr/article/DG159/list"));
                startActivity(intent);
            }
        });


        //클릭이벤트 교내행사
        event_notice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://daegu.ac.kr/article/DG161/list"));
                startActivity(intent);
            }
        });

        //클릭이벤트 채용공고
        recruitment_notice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://daegu.ac.kr/article/DG163/list"));
                startActivity(intent);
            }
        });

        //클릭이벤트 코로나 공지
        corona_notice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://daegu.ac.kr/article/DG9999/list"));
                startActivity(intent);
            }
        });

        //클릭이벤트 유튜브
        youtube.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/channel/UC_UQd2BhSaENgJRz5bn27wA"));
                startActivity(intent);
            }
        });

        //클릭이벤트 페이스북
        facebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/DaeguUniversity1956"));
                startActivity(intent);
            }
        });

        //클릭이벤트 블로그
        blog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://blog.naver.com/dgu1004"));
                startActivity(intent);
            }
        });

        //클릭이벤트 인스타그램
        instagram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/daegu_univ/?hl=ko"));
                startActivity(intent);
            }
        });

        //클릭이벤트 교내전화
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.daegu.ac.kr/customer/emp/detail#none"));
                startActivity(intent);
            }
        });



        //캘린더뷰 바로 아래 날짜 표시 텍스트뷰
        final TextView calendar_date = findViewById(R.id.calendar_date); //날짜 변수
        final TextView schedule = findViewById(R.id.schedule); //일정 변수
        final TextView schedule_2 = findViewById(R.id.schedule_2); //일정 변수 2번째(일정이 두개 있을 경우)
        CalendarView calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                calendar_date.setText(String.format("%d년 %d월 %d일 학사일정", year, month, dayOfMonth)); //날짜 출력 텍스트뷰


                //날짜별 대구대학교 대학 일정 기록 ---------------------------------------------------------

                //2020년 11월 학사일정 --------------------------------
                if(year==2020 & month == 11 & dayOfMonth == 1){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 2){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 3){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 4){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 5){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 6){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 7){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 8){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 9){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 10){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 11){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 12){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 13){
                    schedule.setText(String.format("제 2학기 수업일수 2/3 선"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 14){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 15){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 16){
                    schedule.setText(String.format("겨울 계절수업 수강신청"));
                    schedule_2.setText(String.format("2021학년도 제1학기 전과전형 신청기간"));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 17){
                    schedule.setText(String.format("겨울 계절수업 수강신청"));
                    schedule_2.setText(String.format("2021학년도 제1학기 전과전형 신청기간"));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 18){
                    schedule.setText(String.format("겨울 계절수업 수강신청"));
                    schedule_2.setText(String.format("2021학년도 제1학기 전과전형 신청기간"));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 19){
                    schedule.setText(String.format("겨울 계절수업 수강신청"));
                    schedule_2.setText(String.format("2021학년도 제1학기 전과전형 신청기간"));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 20){
                    schedule.setText(String.format("임시휴강 / 겨울 계절수업 수강신청"));
                    schedule_2.setText(String.format("2021학년도 제1학기 전과전형 신청기간"));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 21){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 22){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 23){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 24){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 25){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 26){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 27){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 28){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 29){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 11 & dayOfMonth == 30){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }





                //2020년 12월 학사일정 --------------------------------
                else if(year==2020 & month == 12 & dayOfMonth == 1){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 2){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 3){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 4){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 5){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 6){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 7){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 8){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 9){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 10){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 11){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 12){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 13){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 14){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 15){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 16){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 17){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 18){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 19){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 20){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 21){
                    schedule.setText(String.format("제 2학기 기말 시험기간"));
                    schedule_2.setText(String.format("제 2학기 성적입력 및 공시 마감"));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 22){
                    schedule.setText(String.format("겨울방학"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 23){
                    schedule.setText(String.format("겨울 계절수업 개강"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 24){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 25){
                    schedule.setText(String.format("크리스마스"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 26){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 27){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 28){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 29){
                    schedule.setText(String.format("제 2학기 성적이의신청 및 정정"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 30){
                    schedule.setText(String.format("제 2학기 성적이의신청 및 정정"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2020 & month == 12 & dayOfMonth == 31){
                    schedule.setText(String.format("제 2학기 성적이의신청 및 정정"));
                    schedule_2.setText(String.format(""));
                }




                //2021년 1월 학사일정 --------------------------------

                else if(year==2021 & month == 1 & dayOfMonth == 1){
                    schedule.setText(String.format("신정"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 2){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 3){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 4){
                    schedule.setText(String.format("제2학기 최종성적 확정"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 5){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 6){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 7){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 8){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 9){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 10){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 11){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 12){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 13){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 14){
                    schedule.setText(String.format("겨울 계절수업 종강"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 15){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 16){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 17){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 18){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 19){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 20){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 21){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 22){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 23){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 24){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 25){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 26){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 27){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 28){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 29){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 30){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 1 & dayOfMonth == 31){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }



                //2021년 2월 학사일정 --------------------------------

                else if(year==2021 & month == 2 & dayOfMonth == 1){
                    schedule.setText(String.format("2021학년도 제1학기 장바구니 수강신청 기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 2){
                    schedule.setText(String.format("2021학년도 제1학기 장바구니 수강신청 기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 3){
                    schedule.setText(String.format("2021학년도 제1학기 장바구니 수강신청 기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 4){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 5){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 6){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 7){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }else if(year==2021 & month == 2 & dayOfMonth == 8){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 9){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 10){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 11){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format("설연휴"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 12){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format("설연휴"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 13){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format("설연휴"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 14){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 15){
                    schedule.setText(String.format("2021학년도 제 1학기 수강신청 기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 16){
                    schedule.setText(String.format("2021학년도 제 1학기 수강신청 기간"));
                    schedule_2.setText(String.format(""));
                }else if(year==2021 & month == 2 & dayOfMonth == 17){
                    schedule.setText(String.format("2021학년도 제 1학기 수강신청 기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 18){
                    schedule.setText(String.format("2021학년도 제 1학기 수강신청 기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 19){
                    schedule.setText(String.format("제 1학기 휴복학 신청기간, 재학생 등록기간"));
                    schedule_2.setText(String.format("2020학년도 전위 학위수여일"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 20){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 재학생 등록기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 21){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 재학생 등록기간"));
                }else if(year==2021 & month == 2 & dayOfMonth == 22){
                    schedule.setText(String.format("신입생 입학식, 신입생 수강신청 기간"));
                    schedule_2.setText(String.format("제 1학기 휴복학 신청기간, 재학생 등록기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 23){
                    schedule.setText(String.format("신입생 입학식, 신입생 수강신청 기간"));
                    schedule_2.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 24){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 25){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 26){
                    schedule.setText(String.format("2021학년도 제 1학기 휴복학 신청기간"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 27){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }
                else if(year==2021 & month == 2 & dayOfMonth == 28){
                    schedule.setText(String.format("일정없음"));
                    schedule_2.setText(String.format(""));
                }


            }
        });

    }








    //메인화면 타이틀 이미지, 이 부분에 이미지 추가해서 만들 수 있다.
    public void InitializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new Titleimg(R.drawable.card_1));
        dataList.add(new Titleimg(R.drawable.card_2));
        dataList.add(new Titleimg(R.drawable.card_3));
        dataList.add(new Titleimg(R.drawable.card_4));
        dataList.add(new Titleimg(R.drawable.card_5));
        dataList.add(new Titleimg(R.drawable.card_6));
        dataList.add(new Titleimg(R.drawable.card_7));

    }


    //--------------------리사이클러뷰 끝!!!------------------------------------


    public void home_click (View view){
        Toast.makeText(getApplicationContext(),"이미 Home 화면 입니다.", Toast.LENGTH_SHORT).show();
    }
}

