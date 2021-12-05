package com.example.tugas7;

public class Ikan {
    private String _id, _ikan, _harga;
    public Ikan (String id, String ikan, String harga) {
        this._id = id;
        this._ikan = ikan;
        this._harga = harga;
    }
    public Ikan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_ikan() {
        return _ikan;
    }
    public void set_ikan(String _ikan) {
        this._ikan = _ikan;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
