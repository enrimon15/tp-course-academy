package it.aesys.courses.springboot.personregistry.models.mapper;

import java.util.ArrayList;
import java.util.List;

public class Documents extends ArrayList<DocumentDTO> {

    private List<DocumentDTO> list = new ArrayList<>();

    public List<DocumentDTO> getList() {
        return list;
    }

    public void setList(List<DocumentDTO> list) {
        this.list = list;
    }
}
