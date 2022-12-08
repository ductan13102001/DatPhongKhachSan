package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class CachTinhTien_Activity extends AppCompatActivity {
    Toolbar home_Toolab;
    DrawerLayout home_Drawerlayout;
    NavigationView home_NavigationView;
    ListView home_listView;
    ArrayList<ItemMenu> home_arraylist;
    MenuAdapter home_adapter;

    CachTinhTien_Product_Adapter cachtinhtien_product_listview_adapter;
    ListView CachTinhTien_ListView;
    ArrayList<CachTinhTien_Product>  CachTinhTien_arraylist; // Mảng dữ liệu giá tiền các loại phòng

    Button butThem_CachTinhTien;
    Button butSua_CachTinhTien;
    Button butXoa_CachTinhTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cach_tinh_tien );

        anhxa();
        actionToolBar();
        actionMenu();
        action_CachTinhTien();
        action_Them();
        action_Sua();
        action_Xoa();
    }
    //==============================================================================================
    private void action_Them(){
        // Thêm listView mới
        butThem_CachTinhTien.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhThem = new Intent(CachTinhTien_Activity.this, Them_cachtinhtien_Activity.class);
                startActivity( mhThem );
            }
        } );
    }
    private void action_Sua(){
        // Sửa listView đã chọn
        butSua_CachTinhTien.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CachTinhTien_ListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        for(int i = 0; i < CachTinhTien_arraylist.toArray().length; i++){
                            if(i == position){
                                Intent mhSua = new Intent(CachTinhTien_Activity.this, Sua_cachtinhtien_Activity.class);
                                startActivity( mhSua );
                            }
                        }
                    }
                } );
            }
        } );
    }
    private void action_Xoa(){
        // Xoá listView đã chọn
        ArrayList<CachTinhTien_Product>  list = CachTinhTien_arraylist;
        butXoa_CachTinhTien.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CachTinhTien_ListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        for(int i = 0; i < CachTinhTien_arraylist.toArray().length; i++){
                            if(i == position){
                                // Xóa phần tử đầu tiên trong danh sách
                                CachTinhTien_arraylist.remove( position );
                                // Thông báo cho ListView biết dữ liệu đã thay đổi(cập nhật, xóa, ...)
                                cachtinhtien_product_listview_adapter.notifyDataSetChanged();
                            }
                        }
                    }
                } );
            }
        } );

    }
    //==============================================================================================
    private void action_CachTinhTien(){
        // Khởi tạo arrayList_cachTinhTien, tự sinh một số dữ liệu
        CachTinhTien_arraylist = new ArrayList<>();
        CachTinhTien_arraylist.add( new CachTinhTien_Product( 1,"Phòng đơn", 80000, 250000, 150000 ) );
        CachTinhTien_arraylist.add( new CachTinhTien_Product( 2,"Phòng đôi", 100000, 300000, 180000 ) );

        cachtinhtien_product_listview_adapter = new CachTinhTien_Product_Adapter( CachTinhTien_arraylist );

        CachTinhTien_ListView = findViewById( R.id.list_CachTinhTien );
        CachTinhTien_ListView.setAdapter( cachtinhtien_product_listview_adapter );

        // Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        CachTinhTien_ListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CachTinhTien_Product product = (CachTinhTien_Product) cachtinhtien_product_listview_adapter.getItem( position );
                // Làm gì đó khi chọn sản phẩm(ví dụ: tạo một Activity hiển thị chi tiết, biên tập,...)
                Toast.makeText(CachTinhTien_Activity.this, product.name_loaiPhong_cachTinhTien,Toast.LENGTH_LONG).show();
            }
        } );
    }
    //==============================================================================================
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
                        Intent sceenHome = new Intent(CachTinhTien_Activity.this, TrangChinh_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 1:
                        sceenHome = new Intent(CachTinhTien_Activity.this, Thue_TraPhong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 2:
                        sceenHome = new Intent(CachTinhTien_Activity.this, DatPhong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 3:
                        sceenHome = new Intent(CachTinhTien_Activity.this, QuanLyKho_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 4:
                        sceenHome = new Intent(CachTinhTien_Activity.this, QuanLy_ThuChi_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 5:
                        sceenHome = new Intent(CachTinhTien_Activity.this, QuanLy_HeThong_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 6:
                        sceenHome = new Intent(CachTinhTien_Activity.this, TaiKhoan_Activity.class);
                        startActivity( sceenHome );
                        break;
                    case 7:
                        sceenHome = new Intent(CachTinhTien_Activity.this, HuongDanSuDung_Activity.class);
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

        CachTinhTien_ListView = findViewById( R.id.list_CachTinhTien );

        butThem_CachTinhTien = (Button) findViewById( R.id.btnThem_CachTinhTien );
        butSua_CachTinhTien  = (Button) findViewById( R.id.btnSua_CachTinhTien );
        butXoa_CachTinhTien  = (Button) findViewById( R.id.btnXoa_CachTinhTien );
    }
}