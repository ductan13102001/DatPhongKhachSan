package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

//import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class QuanLy_HeThong_Activity extends AppCompatActivity {
    Toolbar home_Toolab;
    DrawerLayout home_Drawerlayout;
    NavigationView home_NavigationView;
    ListView home_listView;
    ArrayList<ItemMenu> home_arraylist;
    MenuAdapter home_adapter;

    Button btnHome_loaiphong, btnHome_cachtinhtien, btnHome_phong;
    Button btnHome_menu_dichvu, btnHome_taikhoanphu, btnHome_thietlapkhac;
    Button btnHome_thongke, btnHome_lichsu, btnHome_huongdan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_quan_ly_he_thong );

        anhxa();
        actionToolBar();
        actionMenu();
    }
    // Làm menu Navigition cho home
    private void actionMenu() {
        // Tạo các thành phần cho menu
        home_arraylist = new ArrayList<>();
        home_arraylist.add(new ItemMenu("Trang chính", R.drawable.ic_house));
        home_arraylist.add(new ItemMenu("Thuê - trả phòng", R.drawable.ic_loop));
        home_arraylist.add(new ItemMenu("Đặt phòng", R.drawable.ic_event_note));
        home_arraylist.add(new ItemMenu("Quản lý kho", R.drawable.ic_data_sever_off));
        home_arraylist.add(new ItemMenu("Quản lý thu chi", R.drawable.ic_transfrom));
        home_arraylist.add(new ItemMenu("Quản lý hệ thống", R.drawable.ic_setting));
        home_arraylist.add(new ItemMenu("Tài khoản", R.drawable.ic_accout_circle));
        home_arraylist.add(new ItemMenu("Hướng dẫn sử dụng", R.drawable.ic_live_help));
        home_arraylist.add(new ItemMenu("Đăng xuất", R.drawable.ic_power));
        home_adapter = new MenuAdapter(this, R.layout.activity_home_item_menu, home_arraylist);
        home_listView.setAdapter(home_adapter);

        ArrayList<ItemMenu> list = home_arraylist;
        // Chuyển màn hình
        home_listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent sceenHome = new Intent(QuanLy_HeThong_Activity.this, TrangChinh_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 1:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, Thue_TraPhong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 2:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, DatPhong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 3:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, QuanLyKho_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 4:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, QuanLy_ThuChi_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 5:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, QuanLy_HeThong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 6:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, TaiKhoan_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 7:
                        sceenHome = new Intent(QuanLy_HeThong_Activity.this, HuongDanSuDung_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 8:
                        // Tao su kien ket thuc app
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        finish();
                        break;
                }
            }
        } );


    }
    // =========================================================================================
    private void actionToolBar(){
        setSupportActionBar(home_Toolab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        home_Toolab.setNavigationIcon(R.drawable.ic_menu);
        home_Toolab.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_Drawerlayout.openDrawer(GravityCompat.START);
            }
        });
    }
    public void anhxa(){
        btnHome_loaiphong = (Button) findViewById(R.id.butHome_Loaiphong);
        btnHome_cachtinhtien = (Button) findViewById(R.id.butHome_Cachtinhtien);
        btnHome_phong = (Button) findViewById(R.id.butHome_Phong);
        btnHome_menu_dichvu = (Button) findViewById(R.id.butHome_Menu_Dichvu);
        btnHome_taikhoanphu = (Button) findViewById(R.id.butHome_Taikhoanphu);
        btnHome_thietlapkhac = (Button) findViewById(R.id.butHome_Thietlapkhac);
        btnHome_thongke = (Button) findViewById(R.id.butHome_Thongke);
        btnHome_lichsu = (Button) findViewById(R.id.butHome_Lichsu);
        btnHome_huongdan = (Button) findViewById(R.id.butHome_Huongdan);

        home_Toolab = (Toolbar) findViewById(R.id.home_Toolbar);
        home_Drawerlayout = (DrawerLayout) findViewById(R.id.home_DrawerLayout);
        home_NavigationView = (NavigationView) findViewById(R.id.home_NavigationViewMenu);
        home_listView = (ListView) findViewById(R.id.home_ListView);
        // =========== Chuyển màn hình ============

        btnHome_loaiphong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, LoaiPhong_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_cachtinhtien.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, CachTinhTien_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_phong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, Phong_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_menu_dichvu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, Menu_Dichvu_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_taikhoanphu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, TaiKhoanPhu_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_thietlapkhac.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, ThietLapKhac_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_thongke.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, Thongke_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_lichsu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, LichSu_Activity.class);
                startActivity( screenHome );
            }
        } );
        btnHome_huongdan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenHome = new Intent(QuanLy_HeThong_Activity.this, HuongDanSuDung_Activity.class);
                startActivity( screenHome );
            }
        } );
    }
}