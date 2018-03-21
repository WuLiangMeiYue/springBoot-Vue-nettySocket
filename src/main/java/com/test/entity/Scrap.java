package com.test.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="easybuy_scrap")
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId;
    private String scrapCreator;
    private String scrapTittl;
    private String scrapText;
    private Date scrapCreatime;

    public Long getScrapId() {
        return scrapId;
    }

    public void setScrapId(Long scrapId) {
        this.scrapId = scrapId;
    }

    public String getScrapCreator() {
        return scrapCreator;
    }

    public void setScrapCreator(String scrapCreator) {
        this.scrapCreator = scrapCreator;
    }

    public String getScrapTittl() {
        return scrapTittl;
    }

    public void setScrapTittl(String scrapTittl) {
        this.scrapTittl = scrapTittl;
    }

    public String getScrapText() {
        return scrapText;
    }

    public void setScrapText(String scrapText) {
        this.scrapText = scrapText;
    }

    public Date getScrapCreatime() {
        return scrapCreatime;
    }

    public void setScrapCreatime(Date scrapCreatime) {
        this.scrapCreatime = scrapCreatime;
    }
}
