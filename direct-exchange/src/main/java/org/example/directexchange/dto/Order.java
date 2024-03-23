package org.example.directexchange.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order  implements Serializable {
    String id;
    String name;
}
