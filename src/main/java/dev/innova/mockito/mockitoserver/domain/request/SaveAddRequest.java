package dev.innova.mockito.mockitoserver.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaveAddRequest {
    private String name;
    private String refId;
    private String description;
    private String category;
    private String subCategory;
    private int price;
    private String location;
    private String contactNumber;
    private String publisher;
    private String contactEmail;
}
