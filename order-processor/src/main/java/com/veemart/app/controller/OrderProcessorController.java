package com.veemart.app.controller;

import com.veemart.app.model.OrderedProductKey;
import com.veemart.app.service.OrderedProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/processor")
public class OrderProcessorController {
    @Autowired
    OrderedProcessorService orderedProcessorService;
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateOrderStatus(@RequestBody OrderedProductKey orderProductKey){
        return orderedProcessorService.updateProductQuantityAndOrderStatus(orderProductKey);
    }
}
