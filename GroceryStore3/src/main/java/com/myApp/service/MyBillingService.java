package com.myApp.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.myApp.Dto.BillingDTO;
import com.myApp.Dto.OrdersDTO;

import org.springframework.stereotype.Service;

@Service
public class MyBillingService {
	public byte[] generateBillPdf(BillingDTO billing, List<OrdersDTO> myOrderItems,HttpSession session) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    
        
        String username = (String) session.getAttribute("myUsername");
        
        try {
            PdfWriter writer = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
  
         // Adding the heading
            Paragraph heading = new Paragraph("GROCERY STORE")
                    .setFontSize(20)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(heading);
            
            document.add(new Paragraph("Name: " + username));
            document.add(new Paragraph("Bill No: " + billing.getBill_no()));
            document.add(new Paragraph("Bill Date: " + billing.getBill_date()));
            document.add(new Paragraph("Order ID: " + billing.getOrder_id()));
            document.add(new Paragraph("Coupon Applied: " + billing.isCoupon_code()));
            document.add(new Paragraph("Total: Rs" + billing.getTotal()));
            document.add(new Paragraph(" ")); // Blank line

            document.add(new Paragraph("Order Items:"));
            for (OrdersDTO item : myOrderItems) {
                document.add(new Paragraph("Item: " + item.getItem_name() + ", Quantity: " + item.getQuantity() + ", Price: Rs" + item.getPrice()));
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toByteArray();
    }
}
