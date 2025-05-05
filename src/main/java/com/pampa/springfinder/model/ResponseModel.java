package com.pampa.springfinder.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseModel implements Serializable {
    private List<UserModel> data;
}
