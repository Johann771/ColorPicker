package com.johann.colorfx.model;


public class Color {
    int red;
    int green;
    int blue;
    String hexValue;

    public Color(int red, int green, int blue) {
        if (red > 255 || red < 0) {
            throw new IllegalArgumentException("Incorrect value for red");
        }
        if (green > 255 || green < 0) {
            throw new IllegalArgumentException("Incorrect value for green");
        }
        if (blue > 255 || blue < 0) {
            throw new IllegalArgumentException("Incorrect value for blue");
        }

        this.red = red;
        this.green = green;
        this.blue = blue;

        String redHex = String.format("%02X", red);
        String greenHex = String.format("%02X", green);
        String blueHex = String.format("%02X", blue);

        this.hexValue = "#" + redHex + greenHex + blueHex;
    }


    public Color(String hexValue) throws IllegalArgumentException{
        if (hexValue == null){
            throw new IllegalArgumentException("null value");
        } else {
            if (hexValue.matches("^#[A-F0-9]{6}$")) {
                String redHex = hexValue.substring(1, 3);
                String greenHex = hexValue.substring(3, 5);
                String blueHex = hexValue.substring(5, 7);

                int red = Integer.parseInt(redHex, 16);
                int green = Integer.parseInt(greenHex, 16);
                int blue = Integer.parseInt(blueHex, 16);

                this.red = red;
                this.green = green;
                this.blue = blue;
                this.hexValue = hexValue;
            }
            else {
                throw new IllegalArgumentException("La chaîne ne respecte pas le format hexadécimal requis");
            }
        }
    }

    @Override
    public String toString() {
        return "[value="+this.hexValue+", "+"r="+this.red+", g="+this.green+", b="+this.blue+"]";
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) throws IllegalArgumentException{
        if (hexValue == null){
            throw new IllegalArgumentException("null value");
        } else {
            if (hexValue.matches("^#[A-F0-9]{6}$")) {
                String redHex = hexValue.substring(1, 3);
                String greenHex = hexValue.substring(3, 5);
                String blueHex = hexValue.substring(5, 7);

                int red = Integer.parseInt(redHex, 16);
                int green = Integer.parseInt(greenHex, 16);
                int blue = Integer.parseInt(blueHex, 16);

                this.red = red;
                this.green = green;
                this.blue = blue;
                this.hexValue = hexValue;
            }
            else {
                throw new IllegalArgumentException("La chaîne ne respecte pas le format hexadécimal requis");
            }
        }
    }






    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        if (red > 255 || red < 0) {
            throw new IllegalArgumentException("Incorrect value for red");
        } else {
            this.red = red;
            String redHex = String.format("%02X", red);
            this.hexValue = "#" + redHex + this.hexValue.substring(3, 7);
        }
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        if (green > 255 || green < 0) {
            throw new IllegalArgumentException("Incorrect value for green");
        } else {
            this.green = green;
            String greenHex = String.format("%02X", green);
            this.hexValue = "#" + this.hexValue.substring(1, 3) + greenHex + this.hexValue.substring(5, 7);
        }
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        if (blue > 255 || blue < 0) {
            throw new IllegalArgumentException("Incorrect value for blue");
        } else {
            this.blue = blue;
            String blueHex = String.format("%02X", blue);
            this.hexValue = "#" + this.hexValue.substring(1, 5) + blueHex;
        }
    }
}