package org.justice.dodobot;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;

import org.justice.dodobot.Adapter.pointAdapter;
import org.justice.dodobot.Adapter.pointAdapter_10;
import org.justice.dodobot.Adapter.pointAdapter_11;
import org.justice.dodobot.Adapter.pointAdapter_12;
import org.justice.dodobot.Adapter.pointAdapter_13;
import org.justice.dodobot.Adapter.pointAdapter_14;
import org.justice.dodobot.Adapter.pointAdapter_15;
import org.justice.dodobot.Adapter.pointAdapter_16;
import org.justice.dodobot.Adapter.pointAdapter_17;
import org.justice.dodobot.Adapter.pointAdapter_18;
import org.justice.dodobot.Adapter.pointAdapter_19;
import org.justice.dodobot.Adapter.pointAdapter_2;
import org.justice.dodobot.Adapter.pointAdapter_20;
import org.justice.dodobot.Adapter.pointAdapter_21;
import org.justice.dodobot.Adapter.pointAdapter_22;
import org.justice.dodobot.Adapter.pointAdapter_23;
import org.justice.dodobot.Adapter.pointAdapter_24;
import org.justice.dodobot.Adapter.pointAdapter_25;
import org.justice.dodobot.Adapter.pointAdapter_26;
import org.justice.dodobot.Adapter.pointAdapter_27;
import org.justice.dodobot.Adapter.pointAdapter_28;
import org.justice.dodobot.Adapter.pointAdapter_29;
import org.justice.dodobot.Adapter.pointAdapter_3;
import org.justice.dodobot.Adapter.pointAdapter_30;
import org.justice.dodobot.Adapter.pointAdapter_31;
import org.justice.dodobot.Adapter.pointAdapter_32;
import org.justice.dodobot.Adapter.pointAdapter_33;
import org.justice.dodobot.Adapter.pointAdapter_34;
import org.justice.dodobot.Adapter.pointAdapter_35;
import org.justice.dodobot.Adapter.pointAdapter_4;
import org.justice.dodobot.Adapter.pointAdapter_5;
import org.justice.dodobot.Adapter.pointAdapter_6;
import org.justice.dodobot.Adapter.pointAdapter_7;
import org.justice.dodobot.Adapter.pointAdapter_8;
import org.justice.dodobot.Adapter.pointAdapter_9;

public class MapFragmentActivity extends AppCompatActivity implements OnMapReadyCallback, Overlay.OnClickListener{
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private MapView mapView;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;
    private MapView mapview;



    //infowindow ?????? ?????? ??? ?????????
    private InfoWindow infoWindow1 = new InfoWindow();
    private InfoWindow infoWindow2 = new InfoWindow();
    private InfoWindow infoWindow3 = new InfoWindow();


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.naver_map);

        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);
        //FusedLocationSource ????????? ?????? ????????? ?????? ???????????? ???????????? ????????? ???????????? ???????????? ????????? ??????, ?????? ????????? ?????????
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        //???????????? ?????? ????????? ??? ???????????? ???????????? ??????
        ImageButton dodu_chat = (ImageButton) findViewById(R.id.dodu_chat);
        dodu_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chatbot_Activity.class);
                startActivity(intent);
            }
        });


        //????????? ????????? ??????????????????
        ImageView Home_Button = (ImageView) findViewById(R.id.home);
        Home_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //?????? ????????????
        //???????????? ??????
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map_view);
        if(mapFragment == null){
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map_view, mapFragment). commit();
        }

        //getMapAsync??? ???????????? ???????????? onMapReady ?????? ????????? ??????
        //onMapReady?????? NaverMap ????????? ??????

        mapFragment.getMapAsync(this);

















    }






    @Override
    public void onMapReady(@NonNull final NaverMap naverMap) {
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);


        //?????? ??????



        //????????? ?????? UI ?????????
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setScaleBarEnabled(true);
        uiSettings.setScaleBarEnabled(true);
        uiSettings.setZoomControlEnabled(true);
        uiSettings.setLocationButtonEnabled(true);





        //Spinner ?????? ?????? ??????
        final Spinner map_list_spinner = (Spinner)findViewById(R.id.map_list_spinner);

        map_list_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                String map_list_value = (String) map_list_spinner.getSelectedItem();
                if(map_list_value.equals("??????????????? ??????")){
                    //?????? ??????
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.9030756, 128.851198));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????? ??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter adapter = new pointAdapter(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);


                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.9030756, 128.851198),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);




                }
                else if (map_list_value.equals("??????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.8994466, 128.8552053));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_2 adapter = new pointAdapter_2(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);


                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);
                            return false;
                        }
                    });


                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.8994466, 128.8552053),16) //?????????
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);




                }
                else if (map_list_value.equals("????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.899554, 128.855557));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_3 adapter = new pointAdapter_3(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.899554, 128.855557),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);



                }
                else if (map_list_value.equals("????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.898366, 128.84994));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_4 adapter = new pointAdapter_4(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.898366, 128.84994),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.902615, 128.843726));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_5 adapter = new pointAdapter_5(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.902615, 128.843726),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.900818, 128.851157));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_6 adapter = new pointAdapter_6(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.900818, 128.851157),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("??????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.901263, 128.842518));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_7 adapter = new pointAdapter_7(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.901263, 128.842518),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("????????????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.899449, 128.848326));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_8 adapter = new pointAdapter_8(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.899449, 128.848326),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????????????? 5??????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.898577, 128.846945));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????????????? 5??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_9 adapter = new pointAdapter_9(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.898577, 128.846945),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????????????? 2??????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.902933, 128.845775));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????????????? 2??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_10 adapter = new pointAdapter_10(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.902933, 128.845775),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????????????? 1??????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.902159, 128.844692));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????????????? 1??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_11 adapter = new pointAdapter_11(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.902159, 128.844692),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("???????????? 1??????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.900412, 128.84555));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("???????????? 1??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_12 adapter = new pointAdapter_12(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.900412, 128.84555),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("???????????? 2??????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.90043, 128.845496));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("???????????? 2??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_13 adapter = new pointAdapter_13(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.90043, 128.845496),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("??????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.89996, 128.853146));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_14 adapter = new pointAdapter_14(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.89996, 128.853146),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }

                else if (map_list_value.equals("??????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.8560761, 128.5756975));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_15 adapter = new pointAdapter_15(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.8560761, 128.5756975),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }

                else if (map_list_value.equals("????????????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.9005852, 128.8477491));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_16 adapter = new pointAdapter_16(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.9005852, 128.8477491),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("????????????????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.899581, 128.850517));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_17 adapter = new pointAdapter_17(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.899581, 128.850517),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("???????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.898013, 128.852932));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????? ??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_18 adapter = new pointAdapter_18(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.898013, 128.852932),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.899633, 128.850807));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_19 adapter = new pointAdapter_19(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.899633, 128.850807),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????(????????????)")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.8994466, 128.8552053));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????(????????????)"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_20 adapter = new pointAdapter_20(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.8994466, 128.8552053),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.903939, 128.845112));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_21 adapter = new pointAdapter_21(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.903939, 128.845112),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.901336, 128.849155));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_22 adapter = new pointAdapter_22(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.901336, 128.849155),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ?????????(???)")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.904209, 128.844118));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ?????????(???)"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_23 adapter = new pointAdapter_23(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.904209, 128.844118),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ?????????(???)")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.904948, 128.844788));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ?????????(???)"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_24 adapter = new pointAdapter_24(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.904948, 128.844788),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.90563, 128.84333));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_25 adapter = new pointAdapter_25(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.90563, 128.84333),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.897196, 128.849926));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_26 adapter = new pointAdapter_26(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.897196, 128.849926),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                ///????????? ?????? ???????????? ??????



                else if (map_list_value.equals("8?????? ??????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.903511, 128.843311));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("8?????? ??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_27 adapter = new pointAdapter_27(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });


                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.903511, 128.843311),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.899419, 128.852541));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_28 adapter = new pointAdapter_28(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.899419, 128.852541),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.906603, 128.847068));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_29 adapter = new pointAdapter_29(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.906603, 128.847068),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.900642, 128.843565));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_30 adapter = new pointAdapter_30(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.900642, 128.843565),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????? ?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.900669, 128.854567));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????? ?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_31 adapter = new pointAdapter_31(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.900669, 128.854567),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.901744, 128.846573));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_32 adapter = new pointAdapter_32(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.901744, 128.846573),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("???????????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.900625, 128.856937));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("???????????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_33 adapter = new pointAdapter_33(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.900625, 128.856937),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.899222, 128.851419));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("?????????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_34 adapter = new pointAdapter_34(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.899222, 128.851419),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);


                }
                else if (map_list_value.equals("?????????")){
                    final Marker marker_1 = new Marker();
                    marker_1.setPosition(new LatLng(35.898931, 128.852637));
                    marker_1.setMap(naverMap);
                    marker_1.setCaptionText("??????????????? ??????"); //????????? ?????? ??????

                    marker_1.setOnClickListener(new Overlay.OnClickListener() {
                        @Override
                        public boolean onClick(@NonNull Overlay overlay)
                        {

                            //????????? pointAdapter?????? ?????????
                            ViewGroup rootView = (ViewGroup)findViewById(R.id.imagepoint_1);
                            pointAdapter_35 adapter = new pointAdapter_35(MapFragmentActivity.this, rootView);
                            infoWindow3.setAdapter(adapter);



                            //???????????? ????????????
                            infoWindow3.setZIndex(10);
                            //????????? ??????
                            infoWindow3.setAlpha(0.9f);
                            //????????? ??????
                            infoWindow3.open(marker_1);

                            return false;
                        }
                    });

                    //????????? ??????
                    CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                            new LatLng(35.898931, 128.852637),16)
                            .animate(CameraAnimation.Fly, 1500); //3????????? ???

                    naverMap.moveCamera(cameraUpdate);

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner ???


    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)){
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }





    @Override
    public boolean onClick(@NonNull Overlay overlay){
        if(overlay instanceof Marker){
            Toast.makeText(this.getApplicationContext(), " ", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }


}
