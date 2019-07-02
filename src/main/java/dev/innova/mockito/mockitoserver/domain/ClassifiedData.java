package dev.innova.mockito.mockitoserver.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Data
@Document(collection = "classified")
public class ClassifiedData {
    @Id
    private String id;
    private String name;
    private String refId;
    private String description;
    private String category;
    private String subCategory;
    private Date postDate;
    private int price;
    private String location;
    private String contactNumber;
    private String publisher;
    private String contactEmail;
}
