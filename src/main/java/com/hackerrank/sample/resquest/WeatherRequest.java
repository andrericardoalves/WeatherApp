package com.hackerrank.sample.resquest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class WeatherRequest {

    @NotEmpty
    private String location;

    @NotNull
    private Double temperature;

    @NotNull
    private LocalDateTime date;

    public WeatherRequest(){}
    private WeatherRequest(Builder builder) {
        setLocation(builder.location);
        setTemperature(builder.temperature);
        setDate(builder.date);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public static final class Builder {
        private @NotEmpty String location;
        private @NotNull Double temperature;
        private @NotNull LocalDateTime date;

        private Builder() {
        }

        public Builder location(@NotEmpty String val) {
            location = val;
            return this;
        }

        public Builder temperature(@NotNull Double val) {
            temperature = val;
            return this;
        }

        public Builder date(@NotNull LocalDateTime val) {
            date = val;
            return this;
        }

        public WeatherRequest build() {
            return new WeatherRequest(this);
        }
    }
}
