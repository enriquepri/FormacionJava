package com.bosonit.training;

public class Person {
    String name;
    String town;
    int age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ("Nombre:" + this.name + " Ciudad:" + this.town + " Edad:" + this.age);
    }

    public static class personBuilder{
        String name;
        String town;
        int age;
        public personBuilder(String[] parametros){
            if(parametros.length != 3){
                return;
            }

            this.name = parametros[0];
            if(parametros[1].isEmpty()){
                this.town = "unknown";
            }else{
                this.town = parametros[1];
            }
            if(parametros[2].isEmpty()){
                this.age = 0;
            }else{
                this.age = Integer.parseInt(parametros[2]);
            }
        }
        public Person build(){
            Person persona = new Person();
            persona.setAge(this.age);
            persona.setName(this.name);
            persona.setTown(this.town);
            return persona;
        }
    }
}
