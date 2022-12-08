package com.example.datphongkhachsan;

public class CachTinhTien_Product {
    // Model phần tử dữ liệu hiện - cách tính tiền
    int id_cachTinhTien;
    String name_loaiPhong_cachTinhTien;
    int giaThueTheoGio_cachTinhTien;
    int giaThueTheoNgay_cachTinhTien;
    int giaThueQuaDem_cachTinhTien;

    public CachTinhTien_Product(int id_cachTinhTien, String name_loaiPhong_cachTinhTien, int giaThueTheoGio_cachTinhTien, int giaThueTheoNgay_cachTinhTien, int giaThueQuaDem_cachTinhTien){
        this.id_cachTinhTien = id_cachTinhTien;
        this.name_loaiPhong_cachTinhTien = name_loaiPhong_cachTinhTien;
        this.giaThueTheoGio_cachTinhTien = giaThueTheoGio_cachTinhTien;
        this.giaThueTheoNgay_cachTinhTien = giaThueTheoNgay_cachTinhTien;
        this.giaThueQuaDem_cachTinhTien = giaThueQuaDem_cachTinhTien;
    }
}
