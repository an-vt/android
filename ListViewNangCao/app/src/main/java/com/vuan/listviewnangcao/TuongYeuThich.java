package com.vuan.listviewnangcao;

public class TuongYeuThich {
    private int imgAvatar;
    private String name;
    private String desciption;
    private int logo;

    public TuongYeuThich() {
    }

    public TuongYeuThich(int imgAvatar, String name, String desciption, int logo) {
        this.imgAvatar = imgAvatar;
        this.name = name;
        this.desciption = desciption;
        this.logo = logo;
    }

    public int getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(int imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "TuongYeuThich{" +
                "imgAvatar=" + imgAvatar +
                ", name='" + name + '\'' +
                ", desciption='" + desciption + '\'' +
                ", logo=" + logo +
                '}';
    }
}
