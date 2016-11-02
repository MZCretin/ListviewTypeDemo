package com.fangrongjie.www.listviewtypedemo;

/**
 * Created by cretin on 16/10/31.
 */

public class Item {
    private String name;
    private String rank;
    private String phone;
    private String money;
    private int type;
    private String teamName;

    public Item(String name, String rank, String phone, String money, int type, String teamName) {
        this.name = name;
        this.rank = rank;
        this.phone = phone;
        this.money = money;
        this.type = type;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
