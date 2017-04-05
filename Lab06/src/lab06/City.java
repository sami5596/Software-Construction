package lab06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {
    @Id 
    @Column(name = "locId")
    int locId;
    //int metroCode, areaCode;
    @Column(name = "postalCode")
    String postalCode;
    
    @Column(name = "country")
    String country;
    
    @Column(name = "region")
    String region;
    
    @Column(name = "city")
    String city;
    
    @Column(name = "latitude")
    String latitude;
    
    @Column(name = "longitude")
    String longitude;
    
    City(){}
    
    City(String cntry, String regn, String cty, String posCode, String lat, String lon){
        this.country = cntry;
        this.region = regn;
        this.city = cty;
        this.postalCode = posCode;
        this.latitude = lat;
        this.longitude = lon;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }
    /*
    public int getMetroCode() {
        return metroCode;
    }

    public void setMetroCode(int metroCode) {
        this.metroCode = metroCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }
*/

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }   
}
