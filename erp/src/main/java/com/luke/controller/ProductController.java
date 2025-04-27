package com.luke.controller;

import com.luke.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@Tag(name = "product", description = "產品資料表")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/excel-upload", consumes = "multipart/form-data")
    @Operation(summary = "匯入上架成本表")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file)
    {
        try {
            productService.importExcelToDatabase(file.getInputStream());
            return ResponseEntity.ok("匯入成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("匯入失敗：" + e.getMessage());
        }
    }
}
