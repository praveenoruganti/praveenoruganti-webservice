package com.praveen.apachecxf.soap.service;

import javax.jws.WebService;

@WebService(serviceName="BookService", endpointInterface="com.praveen.apachecxf.soap.service.BookService")
public class BookServiceImpl implements BookService {
 
    public String getBookNameBasedOnISBN(String isbnNumber) {
 
        if(isbnNumber.equalsIgnoreCase("ISBN-2134")){
            return "Microbiology";
        }
        return "Invalid_ISBN_Number";
    }
}
