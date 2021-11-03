package com.sioux.smartparkingapp.models;

import javax.persistence.*;

@Entity
@Table(name = "ExampleModel")
public class ExampleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;


    public ExampleModel(String subject, String body )
    {
        this.setSubject(subject);
        this.setBody(body);
    }

    //Getter and setters
    //region
    public Long getId()
    {
        return id;
    }
    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }


    //endregion

    @Override
    public String toString()
    {
        return "ExampleModel{" + "id=" + this.getId() + ", subject='" + this.getSubject() + '\''
                + ", body='" + this.getBody() + '\'' + '}';
    }
}


