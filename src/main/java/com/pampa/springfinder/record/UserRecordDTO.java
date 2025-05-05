package com.pampa.springfinder.record;


import java.text.Normalizer;

public record UserRecordDTO(String cpf, String name,  String gender, String date) {
    public UserRecordDTO {
        cpf = cpf != null ? cpf.replace(".", "").replace("-", "") : "";
        name = name != null ? Normalizer.normalize(name.toUpperCase(), Normalizer.Form.NFKD).replaceAll("\\p{M}", "") : "" ;
        gender = gender != null ? gender : "";
        date = date != null ? date : "";
    }
}
