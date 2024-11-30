package com.veemart.app.controller;

import com.veemart.app.dto.CatalogDto;
import com.veemart.app.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCatalog(@RequestBody CatalogDto catalogDto) {
        return catalogService.createCatalog(catalogDto);
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
    public String deleteCatalog(@PathVariable("name") String catalogName) {
        return catalogService.deleteCatalog(catalogName);
    }

    @RequestMapping(path="/{name}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CatalogDto getCatalog(@PathVariable("name") String catalogName) {
        return catalogService.getCatalog(catalogName);
    }

}
