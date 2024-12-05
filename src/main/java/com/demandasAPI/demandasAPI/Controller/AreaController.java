package com.demandasAPI.demandasAPI.Controller;


import com.demandasAPI.demandasAPI.Model.Area;
import com.demandasAPI.demandasAPI.Model.DTO.AreaDTO;
import com.demandasAPI.demandasAPI.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<Area> getAllAreas() {
        return areaService.getAllAreas();
    }


    @GetMapping("/{id}")
    public Area getAreaById(@PathVariable String id) {
        return areaService.getAreaById(id);
    }

    @PostMapping
    public Area createArea(@RequestBody AreaDTO area) {
        return areaService.createArea(area);
    }

    @PutMapping("/{id}")
    public Area updateArea(@PathVariable String id, @RequestBody AreaDTO areaDTO) {
        return areaService.updateArea(id, areaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable String id) {
        areaService.deleteArea(id);
    }

}
