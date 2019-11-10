package com.climbing.zone.enumeration;

public enum Quotation {
    C1("3", "V", "5.3", "4", "8", "11", "4B"),
    C2("3+", "V", "5.4", "4+", "10", "12", "4B"),
    C3("4A", "V", "5.5", "4+", "12", "13", "4B"),
    C4("4B", "V", "5.6", "5-", "14", "14", "4B"),
    C5("4C", "V+", "5.7", "5", "15", "15", "4C"),
    C6("5A", "VI-", "5.8", "5", "16", "16", "5A"),
    C7("5B", "VI", "5.9", "5+", "17", "17", "5A"),
    C8("5C", "VI+", "5.10A", "6-", "18", "18", "5B"),
    C9("6A", "VII-", "5.10B", "6", "19", "19", "5B"),
    C10("6A+", "VII-", "5.10C", "6+", "20", "20", "5C"),
    C11("6B", "VII", "5.10D", "6+", "21", "21", "5C"),
    C12("6B+", "VII+", "5.11A", "7-", "21", "22", "5C"),
    C13("6C", "VII+", "5.11B", "7-", "22", "23", "5C"),
    C14("6C+", "VIII-", "5.11C", "7", "23", "24", "6A"),
    C15("7A", "VIII", "5.11D", "7+", "24", "25", "6A"),
    C16("7A+", "VIII+", "5.12A", "7+", "25", "26", "6B"),
    C17("7B", "VIII+", "5.12D", "8-", "26", "27", "6B"),
    C18("7B+", "IX-", "5.12C", "8-", "27", "28", "6B"),
    C19("7C", "IX", "5.12D", "8", "28", "29", "6C"),
    C20("7C+", "IX+", "5.13A", "8", "29", "30", "6C"),
    C21("8A", "X-", "5.13B", "8+", "30", "31", "7A"),
    C22("8A+", "X-", "5.13C", "9-", "31", "32", "7A"),
    C23("8B", "X-", "5.13D", "9", "32", "33", "7A"),
    C24("8B+", "X+", "5.14A", "9", "33", "34", "7B"),
    C25("8C", "XI-", "5.14B", "9+", "34", "35", "7B"),
    C26("8C+", "XI", "5.14C", "9+", "35", "36", "7C"),
    C27("9A", "XII-", "5.15A", "10-", "36", "37", "7C"),
    C28("9A+", "XII", "5.15B", "10", "37", "38", "8A"),
    C29("9B", "XII+", "5.15C", "10+", "38", "39", "8A"),
    C30("9B+", "XIII-", "5.15D", "11-", "39", "40", "8A"),
    C31("9C", "XIII", "5.16A", "11", "40", "41", "8B"),
    C32("9C+", "XIII+", "5.16B", "11+", "41", "42", "8B");

    private String fr;
    private String uiaa;
    private String usa;
    private String norvege;
    private String australie;
    private String afrique;
    private String uk;

    Quotation(String fr, String uiaa, String usa, String norvege, String australie, String afrique, String uk) {
        this.fr = fr;
        this.uiaa = uiaa;
        this.usa = usa;
        this.norvege = norvege;
        this.australie = australie;
        this.afrique = afrique;
        this.uk = uk;
    }

    public String getCotationfr() {
        return this.fr;
    }

    public String getCotationUiaa() {
        return this.uiaa;
    }

    public String getCotationUsa() {
        return this.usa;
    }

    public String getCotationAustralie() {
        return this.australie;
    }

    public String getCotationNorvege() {
        return this.norvege;
    }

    public String getCotationAfrique() {
        return this.afrique;
    }

    public String getCotationUk() {
        return this.uk;
    }
}
