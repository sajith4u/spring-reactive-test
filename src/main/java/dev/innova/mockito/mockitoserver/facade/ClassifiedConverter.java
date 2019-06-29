package dev.innova.mockito.mockitoserver.facade;

import dev.innova.mockito.mockitoserver.domain.ClassifiedData;
import dev.innova.mockito.mockitoserver.domain.request.SaveAddRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClassifiedConverter {

    public ClassifiedData convert(SaveAddRequest saveAddRequest){
        ClassifiedData data = new ClassifiedData();
        data.setCategory(saveAddRequest.getCategory());
        data.setName(saveAddRequest.getName());
        data.setContactEmail(saveAddRequest.getContactEmail());
        data.setContactNumber(saveAddRequest.getContactNumber());
        data.setLocation(saveAddRequest.getLocation());
        data.setSubCategory(saveAddRequest.getSubCategory());
        data.setRefId(saveAddRequest.getRefId());
        data.setDescription(saveAddRequest.getDescription());
        data.setPostDate(new Date());
        data.setPublisher(saveAddRequest.getPublisher());
        data.setPrice(saveAddRequest.getPrice());
        return data;
    }
}
