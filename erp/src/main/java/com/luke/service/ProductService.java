package com.luke.service;

import java.io.InputStream;

public interface ProductService {
    void importExcelToDatabase(InputStream excelInputStream) throws Exception;
}
