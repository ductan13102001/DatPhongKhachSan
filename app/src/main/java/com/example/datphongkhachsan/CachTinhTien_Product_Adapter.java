package com.example.datphongkhachsan;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CachTinhTien_Product_Adapter extends BaseAdapter {
    // Dữ liệu liên kết bởi Adapter là một mảng cách tính tiền
    ArrayList<CachTinhTien_Product>  CachTinhTien_arraylist = null;
    CachTinhTien_Product_Adapter(ArrayList<CachTinhTien_Product>  CachTinhTien_arraylist){
        this.CachTinhTien_arraylist = CachTinhTien_arraylist;
    }

    @Override
    public int getCount() {
        // Trả về tổng số phần tử, nó được gọi bởi ListView
        return CachTinhTien_arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        // Trả về dữ liệu ở vị trí i của Adapter, tương ứng là phần tử
        // Có chỉ số của i trong CachTinhTien_arraylist
        return CachTinhTien_arraylist.get( position );
    }

    @Override
    public long getItemId(int position) {
        // Trả về ID của phần
        return CachTinhTien_arraylist.get( position ).id_cachTinhTien;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        // View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        // Nếu null cần tạo mới

        View viewProduct_cachTinhTien;
        if(convertView == null){
            viewProduct_cachTinhTien = View.inflate( parent.getContext(), R.layout.activity_cach_tinh_tien_product_listview, null );
        }else{
            viewProduct_cachTinhTien = convertView;
        }

        // Nind dữ liệu phần tử vào View
        CachTinhTien_Product product_tinhtien = (CachTinhTien_Product) getItem( position );
        ((TextView) viewProduct_cachTinhTien.findViewById( R.id.txtName_loaiPhong_cachTinhTien )).setText( String.format( "%s" , product_tinhtien.name_loaiPhong_cachTinhTien) );
        ((TextView) viewProduct_cachTinhTien.findViewById( R.id.txtGiaTheoGio_CachTinhTien )).setText( String.format( "%d VND", product_tinhtien.giaThueTheoGio_cachTinhTien ) );
        ((TextView) viewProduct_cachTinhTien.findViewById( R.id.txtGiaTheoNgay_CachTinhTien )).setText( String.format( "%d VND", product_tinhtien.giaThueTheoNgay_cachTinhTien ) );
        ((TextView) viewProduct_cachTinhTien.findViewById( R.id.txtGiaQuaDem_CachTinhTien )).setText( String.format( "%d VND", product_tinhtien.giaThueQuaDem_cachTinhTien ) );

        return viewProduct_cachTinhTien;
    }
}
