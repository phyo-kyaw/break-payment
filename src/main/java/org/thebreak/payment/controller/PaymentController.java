package org.thebreak.payment.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.thebreak.payment.model.Payment;
import org.thebreak.payment.service.PaymentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "api/v1/payment")
public class PaymentController {
    // test payment
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/getToken")
    public ResponseEntity<Map<String, String>> getToken() {
        String token = paymentService.getToken(null);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return ResponseEntity.ok(tokenMap);
    }

    @GetMapping(value = "/pay/{nonce}")
    public ResponseEntity<?> makePayment(@RequestParam String bookingId, @RequestParam int amount, @PathVariable String nonce, @RequestParam int type) {
        // return responseResult directly from the service, so that it can get the message from braintree if errors occur;
        return paymentService.makePayment(bookingId, amount, nonce, type);
    }

    @GetMapping(value = "/getPageByType")
    public Page<Payment> findPaymentsByType(@RequestParam @Nullable Integer type, int page, int size){
        Page<Payment> paymentPage = paymentService.findPaymentsByType(type, page, size);

//        // map the list content to VO list
//        List<Payment> bookingList = paymentPage.getContent();
//        // assemble pageResult
//        PageResult<Payment> pageResult = new PageResult<>(paymentPage, bookingList);
//        return ResponseResult.success(pageResult);
        return paymentPage;
    };



}
