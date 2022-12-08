package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DatPhong_Activity extends AppCompatActivity {
    Toolbar home_Toolab;
    DrawerLayout home_Drawerlayout;
    NavigationView home_NavigationView;
    ListView home_listView;
    ArrayList<ItemMenu> home_arraylist;
    MenuAdapter home_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dat_phong );

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
                        Intent sceenHome = new Intent(DatPhong_Activity.this, TrangChinh_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 1:
                        sceenHome = new Intent(DatPhong_Activity.this, Thue_TraPhong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 2:
                        sceenHome = new Intent(DatPhong_Activity.this, DatPhong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 3:
                        sceenHome = new Intent(DatPhong_Activity.this, QuanLyKho_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 4:
                        sceenHome = new Intent(DatPhong_Activity.this, QuanLy_ThuChi_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 5:
                        sceenHome = new Intent(DatPhong_Activity.this, QuanLy_HeThong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 6:
                        sceenHome = new Intent(DatPhong_Activity.this, TaiKhoan_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 7:
                        sceenHome = new Intent(DatPhong_Activity.this, HuongDanSuDung_Activity.class);
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

                home_Drawerlayout.openDrawer( GravityCompat.START);
            }
        });
    }
    public void anhxa(){
        home_Toolab = (Toolbar) findViewById(R.id.home_Toolbar);
        home_Drawerlayout = (DrawerLayout) findViewById(R.id.home_DrawerLayout);
        home_NavigationView = (NavigationView) findViewById(R.id.home_NavigationViewMenu);
        home_listView = (ListView) findViewById(R.id.home_ListView);
    }
}