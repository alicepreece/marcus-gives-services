package com.example.restservice.models;

public enum RegionEnum {
    SAMERICA("South America"),
    NAMERICA("North America"),
    AFRICA("Africa"),
    EUROPE("Europe"),
    MEAST("Middle East"),
    CANDSASIA("Central and South Asia"),
    EANDSEASIA("East and South East Asia"),
    OCEANIA("Oceania");

    private String region;

    RegionEnum(String region) {
            this.region = region;
    }

    public String getRegion() {
            return region;
    }
}
