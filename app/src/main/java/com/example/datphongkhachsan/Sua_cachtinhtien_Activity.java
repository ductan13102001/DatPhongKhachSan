package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sua_cachtinhtien_Activity extends AppCompatActivity {
    Button butSua_Cachtinh, butCannel_Cachtinh;
    EditText edNameLoaiPhong;
    EditText edGiaTheoGio;
    EditText edGiaTheoNgay;
    EditText edGiaQuaDem;
    EditText edGiaQuaGio;

    CachTinhTien_Product_Adapter cachtinhtien_product_listview_adapter;
    ListView CachTinhTien_ListView;
    ArrayList<CachTinhTien_Product> CachTinhTien_arraylist;

    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sua_cachtinhtien );
        anhxa();

        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void anhxa(){
        butSua_Cachtinh   = (Button) findViewById( R.id.btnSua_Cachtinhtien );
        butCannel_Cachtinh = (Button) findViewById( R.id.btnCannel_Cachtinhtien );

        edNameLoaiPhong = (EditText) findViewById( R.id.editTenCachTinhTien );
        edGiaTheoGio    = (EditText) findViewById( R.id.editGiaThueTheoGio );
        edGiaTheoNgay   = (EditText) findViewById( R.id.editGiaThueTheoNgay );
        edGiaQuaDem     = (EditText) findViewById( R.id.editGiaThueQuaDem );
        edGiaQuaGio     = (EditText) findViewById( R.id.editGiaThueQuaGio );

        butSua_Cachtinh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CachTinhTien_arraylist = new ArrayList<>();
                int i = CachTinhTien_arraylist.toArray().length + 1;
                String name = String.valueOf( edNameLoaiPhong );
                int price_theoGio  = Integer.valueOf( String.valueOf( edGiaTheoGio ) );
                int price_theoNgay = Integer.valueOf( String.valueOf( edGiaTheoNgay ) );
                int price_quaDem   = Integer.valueOf( String.valueOf( edGiaQuaDem ) );

                CachTinhTien_arraylist.add(new CachTinhTien_Product( i, name, price_theoGio, price_theoNgay, price_quaDem));

                Intent mhCachTinh = new Intent(Sua_cachtinhtien_Activity.this, CachTinhTien_Activity.class);
                startActivity( mhCachTinh );
            }
        } );
//        cachtinhtien_product_listview_adapter = new CachTinhTien_Product_Adapter( CachTinhTien_arraylist );
//
//        CachTinhTien_ListView = findViewById( R.id.list_CachTinhTien );
//        CachTinhTien_ListView.setAdapter( cachtinhtien_product_listview_adapter );

        // Lắng nghe bắt sự kiện một phần tử danh sách được chọn

//        CachTinhTien_ListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                CachTinhTien_Product product = (CachTinhTien_Product) cachtinhtien_product_listview_adapter.getItem( position );
                // Làm gì đó khi chọn sản phẩm(ví dụ: tạo một Activity hiển thị chi tiết, biên tập,...)
//                Toast.makeText(Sua_cachtinhtien_Activity.this, product.name_loaiPhong_cachTinhTien,Toast.LENGTH_LONG).show();
//            }
//        } );

        //==========================================================================================
        butCannel_Cachtinh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhCannal = new Intent(Sua_cachtinhtien_Activity.this, CachTinhTien_Activity.class);
                startActivity( mhCannal );
            }
        } );
    }
}