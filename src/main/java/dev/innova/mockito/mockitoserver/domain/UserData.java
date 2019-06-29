package dev.innova.mockito.mockitoserver.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserData {
    private String id;
    private String name;
    private String email;
}
