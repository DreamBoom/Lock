package com.lock.bean;

public class LocationInfo {
    private double LonTitude;//经度
    private double Latitude;//纬度
    private String text;//信息内容
    public  String address;//详细地址 (搜索的关键字)
    public  String province;//省
    public  String city;//城市
    public  String district;//区域(宝安区)

    public double getLonTitude() {
        return LonTitude;
    }

    public void setLonTitude(double lonTitude) {
        LonTitude = lonTitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
