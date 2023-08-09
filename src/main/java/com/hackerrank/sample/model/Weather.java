package com.hackerrank.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double temperature;
    private String location;
    private LocalDateTime date;

    public Weather() {
    }

    private Weather(Builder builder) {
        setId(builder.id);
        setTemperature(builder.temperature);
        setLocation(builder.location);
        setDate(builder.date);
    }

    public static Builder builder() {
        return new Builder();
    }


    public Integer getId() {  return id;  }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTemperature() { return temperature;  }

    public void setTemperature(Double temperature) { this.temperature = temperature;  }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return id.equals(weather.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static final class Builder {
        private Integer id;
        private Double temperature;
        private String location;
        private LocalDateTime date;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder temperature(Double val) {
            temperature = val;
            return this;
        }

        public Builder location(String val) {
            location = val;
            return this;
        }

        public Builder date(LocalDateTime val) {
            date = val;
            return this;
        }

        public Weather build() {
            return new Weather(this);
        }
    }
}
