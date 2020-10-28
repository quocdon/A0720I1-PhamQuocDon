package exercises.optional_demerging;

import java.util.Date;

public class Student {
    private String name;
    private String gender;
    private String birthday;

    public Student(String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        int day = Integer.valueOf(this.birthday.substring(0,2));
        int month = Integer.valueOf(this.birthday.substring(3,5));
        int year = Integer.valueOf(this.birthday.substring(6,10));
        Date date = new Date(year, month, day);
        return date;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
