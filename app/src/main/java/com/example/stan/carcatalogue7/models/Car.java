package com.example.stan.carcatalogue7.models;

import java.io.Serializable;

public class Car implements Serializable

    {
        public int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public int getCubicCapacity() {
            return cubicCapacity;
        }

        public void setCubicCapacity(int cubicCapacity) {
            this.cubicCapacity = cubicCapacity;
        }

        public String make;
        public String model;
        public int power;
        public int cubicCapacity;

        public Car(int id, String make, String model, int power, int cubicCapacity) {
            this.id = id;
            this.make = make;
            this.model = model;
            this.power = power;
            this.cubicCapacity = cubicCapacity;
        }



    public Car() {
        // public constructor is needed for Firebase parsing to work
    }



    }

