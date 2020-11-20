package com.digitalinnovation.salas.de.reuniao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@GeneratorType
@Table(name ="meetingroom" )
public class Room {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "date" , nullable = false)
    private String data;

    @Column(name = "startHour" , nullable = false)
    private String startHour;

    @Column(name ="endHour" , nullable = false)
    private String endHour;


    @Override
    public String toString(){

        return "ROOM [id =" + this.id+ ",name=" + this.name + ",data=" + this.data + ",inicio reuniao=" + this.startHour + ",fim reuniao= " + this.endHour +"]";

    }
}
