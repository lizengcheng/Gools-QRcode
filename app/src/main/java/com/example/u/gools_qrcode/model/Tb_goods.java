package com.example.u.gools_qrcode.model;

/**
 * Created by U on 2018/1/5.
 */

public class Tb_goods {

    private int _id;
    private String name;
    private double prize;
    private String goodsId;

    public Tb_goods(int _id, String name, double prize, String goodsId, String mark) {
        this._id = _id;
        this.name = name;
        this.prize = prize;
        this.goodsId = goodsId;
        this.mark = mark;
    }

    public String getGoodsId() {

        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    private String mark;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
