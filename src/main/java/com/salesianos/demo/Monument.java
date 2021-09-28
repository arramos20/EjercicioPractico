package com.salesianos.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Monument {

    @Id
    @GeneratedValue
    private Long id;

    private String countryCode;
    private String countryName;
    private String cityName;
    private String localization;
    private String monumentName;

    //@Column(columnDefinition = "TEXT")
    @Column(length = 1000)
    private String monumentDescription;
    private String photoURL;

    public Monument(String countryCode, String countryName, String cityName, String localization, String monumentName, String monumentDescription, String photoURL) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.cityName = cityName;
        this.localization = localization;
        this.monumentName = monumentName;
        this.monumentDescription = monumentDescription;
        this.photoURL = photoURL;
    }
}
